package Services.sequenceGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSequenceProvider implements SequenceProvider {
    private DateFormat dateFormat;

    public void setDateFormat() {
        this.dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
    }

    @Override
    public String getSequence() {
        StringBuilder stringBuilder = new StringBuilder();
        setDateFormat();
        stringBuilder.append(dateFormat.format(new Date()));
        stringBuilder.append("_");
        return stringBuilder.toString();
    }
}
