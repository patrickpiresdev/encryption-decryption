package encryptdecrypt.io;

public class OutputInfo {
    private final OutputMethod method;
    private final String outFile;

    private OutputInfo(OutputMethod method, String outFile) {
        this.method = method;
        this.outFile = outFile;
    }

    public static OutputInfo newInstance(OutputMethod method, String outFile) {
        return new OutputInfo(method, outFile);
    }

    public static OutputInfo newInstance() {
        return new OutputInfo(OutputMethod.STD, null);
    }

    public OutputMethod method() {
        return method;
    }

    public String outFile() {
        return outFile;
    }
}
