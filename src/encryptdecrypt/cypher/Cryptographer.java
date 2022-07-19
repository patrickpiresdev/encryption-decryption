package encryptdecrypt.cypher;

public abstract class Cryptographer {
    protected final int key;

    public Cryptographer(int key) {
        this.key = key;
    }

    public static CryptographerFactory newFactory(int key) {
        return CryptographerFactory.newInstance(key);
    }

    public String execute(String mode, String data) {
        return isEncryption(mode) ? encrypt(data) : decrypt(data);
    }

    private static boolean isEncryption(String mode) {
        return "enc".equals(mode);
    }

    public abstract String encrypt(String data);
    public abstract String decrypt(String data);
}
