package encryptdecrypt.io;

public class StandardOutputHandler implements OutputHandler {
    private StandardOutputHandler() {}

    public static OutputHandler newInstance() {
        return new StandardOutputHandler();
    }

    @Override
    public void output(String data) {
        System.out.println(data);
    }
}
