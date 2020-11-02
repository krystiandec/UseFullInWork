package Services.training.interviewIssues.stringConstantPool;

public class StringTask {
    public static void main(String[] args) {
        String string1 = "Hello".concat("World");                              // Linia-1
        String string2 = new String("HelloWorld");          // Linia-2
        String string3 = string1.intern();                                           // Linia-3
        System.out.println(string1 == string3);                                 // Linia-4
    }
}