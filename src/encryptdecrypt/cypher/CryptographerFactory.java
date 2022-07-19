package encryptdecrypt.cypher;

import java.util.Locale;

public class CryptographerFactory {
    private final int key;

    private CryptographerFactory(int key) {
        this.key = key;
    }

    public static CryptographerFactory newInstance(int key) {
        return new CryptographerFactory(key);
    }

    public Cryptographer get(String type) {
        if ("unicode".equals(type.toLowerCase(Locale.ROOT)))
            return UnicodeCryptographer.newInstance(key);
        return ShiftCryptographer.newInstance(key);
    }
}
