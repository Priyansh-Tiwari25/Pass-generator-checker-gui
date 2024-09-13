public class Alphabet {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS ="!@#$%^&*()-_=+[]{}|;:,.<>?/" ;
    private String alphabet;

    public Alphabet(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        StringBuilder sb = new StringBuilder();

        if (IncludeUpper) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (IncludeLower) {
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (IncludeNum) {
            sb.append("0123456789");
        }
        if (IncludeSym) {
            sb.append("!@#$%^&*()-_=+[]{}|;:,.<>?/");
        }

        alphabet = sb.toString();
    }

    public String getAlphabet() {
        return alphabet;
    }
}
