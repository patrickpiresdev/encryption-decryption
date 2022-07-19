package encryptdecrypt.cypher;

public class UnicodeCryptographer extends Cryptographer {
    private UnicodeCryptographer(int key) {
        super(key);
    }

    public static Cryptographer newInstance(int key) {
        return new UnicodeCryptographer(key);
    }

    @Override
    public String encrypt(String data) {
        StringBuilder encryptedMessageBuilder = new StringBuilder();
        for (char c : data.toCharArray())
            encryptedMessageBuilder.append(encrypt(c));
        return encryptedMessageBuilder.toString();
    }

    private char encrypt(char c) {
        return (char) (c + key);
    }

    @Override
    public String decrypt(String data) {
        StringBuilder decryptedMessageBuilder = new StringBuilder();
        for (char c : data.toCharArray())
            decryptedMessageBuilder.append(decrypt(c));
        return decryptedMessageBuilder.toString();
    }

    private char decrypt(char c) {
        return (char) (c - key);
    }
}
