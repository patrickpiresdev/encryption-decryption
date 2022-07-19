package encryptdecrypt.io;

public class StandardOutputMethod implements OutputMethod {
    @Override
    public void output(String data) {
        System.out.println(data);
    }
}
