package Services.atomicTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;

public class AtomicTimeFromInternet {
    /*więcej informacji na temat pobierania czasu z internetów:
    *https://tf.nist.gov/tf-cgi/servers.cgi
    *https://www.rgagnon.com/javadetails/java-0589.html  */
    public static final String ATOMICTIME_SERVER = "129.6.15.30";
    public static final int ATOMICTIME_PORT = 13;

    public final static GregorianCalendar getAtomicTime() throws IOException {
        BufferedReader in = null;
        Socket conn = null;
        try {
            conn = new Socket(ATOMICTIME_SERVER, ATOMICTIME_PORT);
            in = new BufferedReader
                    (new InputStreamReader(conn.getInputStream()));
            String atomicTime;
            while (true) {
                if ((atomicTime = in.readLine()).contains("*")) {
                    break;
                }
            }
            TimeZone tz = TimeZone.getTimeZone("GMT+1"); // or .getDefault()
            int gmt = (tz.getRawOffset() + tz.getDSTSavings()) / 3600000;
            GregorianCalendar calendar = new GregorianCalendar();
            String[] fields = atomicTime.split(" ");

            String[] time = fields[2].split(":");
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0])+gmt);
            calendar.set(Calendar.MINUTE, Integer.parseInt(time[1]));
            calendar.set(Calendar.SECOND, Integer.parseInt(time[2]));
            return calendar;
        } catch (IOException e) {
            e.getMessage();
            throw e;
        } finally {
            if (in != null) {in.close();}
            if (conn != null) {conn.close();}
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(getAtomicTime().getTime());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
