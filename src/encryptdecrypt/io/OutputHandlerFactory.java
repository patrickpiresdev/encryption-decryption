package encryptdecrypt.io;

public class OutputHandlerFactory {
    public static OutputHandler get(OutputInfo outputInfo) {
        if (outputInfo.method() == OutputMethod.FILE)
            return FileOutputHandler.newInstance(outputInfo.outFile());
        return StandardOutputHandler.newInstance();
    }
}
