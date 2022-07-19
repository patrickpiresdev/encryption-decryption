package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutputMethod implements OutputMethod {

    private final String outFile;

    public FileOutputMethod(String outFile) {
        this.outFile = outFile;
    }

    @Override
    public void output(String data) {
        try {
            write(data);
        } catch (FileNotFoundException ex) {
            System.out.printf("File not found: %s", outFile);
        }
    }

    private void write(String data) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(outFile);
        printWriter.print(data);
        printWriter.close();
    }
}
