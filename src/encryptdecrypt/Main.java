package encryptdecrypt;

import encryptdecrypt.cypher.Cryptographer;
import encryptdecrypt.io.OutputMethod;
import encryptdecrypt.io.OutputMethodFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ProgramArgs arguments = ProgramArgs.newInstance(args);
        Cryptographer cryptographer = Cryptographer
                .newFactory(arguments.getKey())
                .get(arguments.getAlgorithm());
        OutputMethod outputMethod = OutputMethodFactory
                .get(arguments.getOutFile());

        try {
            String data = cryptographer.execute(arguments.getMode(), arguments.getData());
            outputMethod.output(data);
        } catch (IOException ex) {
            System.out.println("Deu ruim! Vazando!");
        }
    }
}
