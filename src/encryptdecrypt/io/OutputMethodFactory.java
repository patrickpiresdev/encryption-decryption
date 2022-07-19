package encryptdecrypt.io;

public class OutputMethodFactory {
    public static OutputMethod get(String outFile) {
        if (outFile == null) return new StandardOutputMethod();
        return new FileOutputMethod(outFile);
    }
}
