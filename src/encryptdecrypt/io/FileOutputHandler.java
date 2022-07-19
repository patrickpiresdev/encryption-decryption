package encryptdecrypt.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutputHandler implements OutputHandler {

    private final String outFile;

    private FileOutputHandler(String outFile) {
        this.outFile = outFile;
    }

    public static OutputHandler newInstance(String outFile) {
        return new FileOutputHandler(outFile);
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
