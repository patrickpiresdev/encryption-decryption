package encryptdecrypt;

import encryptdecrypt.io.OutputInfo;
import encryptdecrypt.io.OutputMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ProgramArgs {
    public static final String DEFAULT_MODE = "enc";
    public static final int DEFAULT_KEY = 0;
    public static final String DEFAULT_DATA = "";
    public static final String DEFAULT_ALGORITHM = "shift";
    private Map<String, String> arguments;

    private ProgramArgs(String[] args) {
        arguments = new HashMap<>();
        for (int i = 0; i < args.length; i += 2)
            arguments.put(args[i], args[i+1]);
    }

    public static ProgramArgs newInstance(String[] args) {
        return new ProgramArgs(args);
    }

    public OutputInfo getOutputInfo() {
        String outFile = arguments.get("-out");
        if (outFile != null) return OutputInfo.newInstance(OutputMethod.FILE, outFile);
        return OutputInfo.newInstance();
    }

    public String getAlgorithm() {
        String algorithm = arguments.get("-alg");
        if (algorithm == null) return DEFAULT_ALGORITHM;
        return algorithm;
    }

    public int getKey() {
        String key = arguments.get("-key");
        if (key == null) return DEFAULT_KEY;
        return Integer.parseInt(key);
    }

    public String getMode() {
        String mode = arguments.get("-mode");
        if (mode == null) return DEFAULT_MODE;
        return mode;
    }

    public String getData() throws IOException {
        String dataSource = arguments.get("-data");
        if (dataSource != null) return dataSource;
        dataSource = arguments.get("-in");
        if (dataSource != null) return readDataFrom(dataSource);
        return DEFAULT_DATA;
    }

    public String readDataFrom(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
