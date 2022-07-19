package encryptdecrypt;

import encryptdecrypt.cypher.Cryptographer;
import encryptdecrypt.io.OutputHandler;
import encryptdecrypt.io.OutputHandlerFactory;
import encryptdecrypt.io.OutputInfo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ProgramArgs arguments = ProgramArgs.newInstance(args);
        Cryptographer cryptographer = Cryptographer
                .newFactory(arguments.getKey())
                .get(arguments.getAlgorithm());
        OutputInfo outputInfo = arguments.getOutputInfo();
        OutputHandler outputHandler = OutputHandlerFactory
                .get(outputInfo);

        try {
            String data = cryptographer.execute(arguments.getMode(), arguments.getData());
            outputHandler.output(data);
        } catch (IOException ex) {
            System.out.println("Deu ruim! Vazando!");
        }
    }
}
