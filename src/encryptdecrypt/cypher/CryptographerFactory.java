package encryptdecrypt.cypher;

import java.util.Locale;

public class CryptographerFactory {
    private final int key;

    public CryptographerFactory(int key) {
        this.key = key;
    }

    public static CryptographerFactory newInstance(int key) {
        return new CryptographerFactory(key);
    }

    public Cryptographer get(String type) {
        switch (type.toLowerCase(Locale.ROOT)) {
            case "shift":
                return ShiftCryptographer.newInstance(key);
            case "unicode":
                return UnicodeCryptographer.newInstance(key);
            default:
                return null;
        }
    }
}
