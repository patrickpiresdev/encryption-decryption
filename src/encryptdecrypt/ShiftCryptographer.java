package encryptdecrypt;

public class ShiftCryptographer extends Cryptographer {
    public ShiftCryptographer(int key) {
        super(key);
    }

    public static Cryptographer newInstance(int key) {
        return new ShiftCryptographer(key);
    }

    @Override
    public String encrypt(String data) {
        StringBuilder encryptedMessageBuilder = new StringBuilder();
        for (char c : data.toCharArray())
            encryptedMessageBuilder.append(shouldEncrypt(c) ? encrypt(c) : c);
        return encryptedMessageBuilder.toString();
    }

    private boolean shouldEncrypt(char c) {
        return Character.isAlphabetic(c); // TODO: is this right?
    }

    private char encrypt(char c) {
        char C = Character.isUpperCase(c) ? 'A' : 'a';
        return (char) ((c-C+key)%26 + C);
    }

    @Override
    public String decrypt(String data) {
        StringBuilder encryptedMessageBuilder = new StringBuilder();
        for (char c : data.toCharArray())
            encryptedMessageBuilder.append(shouldEncrypt(c) ? decrypt(c) : c);
        return encryptedMessageBuilder.toString();
    }

    private char decrypt(char c) {
        char C = Character.isUpperCase(c) ? 'A' : 'a';
        int r = c-C-key;
        if (r < 0)
            return (char) ((Character.isUpperCase(c) ? 'Z' : 'z') + r + 1);
        return (char) (C+r);
    }
}
