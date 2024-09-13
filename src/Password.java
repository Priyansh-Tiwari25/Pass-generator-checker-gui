public class Password {
    String Value;
    int Length;

    public Password(String s) {
        Value = s;
        Length = s.length();
    }

    public int CharType(char C) {
        int val;

        // Char is Uppercase Letter
        if ((int) C >= 65 && (int) C <= 90)
            val = 1;

            // Char is Lowercase Letter
        else if ((int) C >= 97 && (int) C <= 122) val = 2;

            // Char is Digit
        else if ((int) C >= 48 && (int) C <= 57) val = 3;

            // Char is Symbol
        else val = 4;

        return val;
    }

    public String calculateScore() {
        int i;
        int types = 0;
        boolean found[] = new boolean[4];

        for (i = 0; i < Value.length(); i++) {
            if (CharType(Value.charAt(i)) == 1) found[0] = true;
            else if (CharType(Value.charAt(i)) == 2) found[1] = true;
            else if (CharType(Value.charAt(i)) == 3) found[2] = true;
            else found[3] = true;
        }

        if (found[0]) types++;
        if (found[1]) types++;
        if (found[2]) types++;
        if (found[3]) types++;

        // Lowercase letter - Value = 1
        // Uppercase letter - Value = 2
        // Number - Value = 3
        // Symbol - Value = 4

        if (types == 1) {
            return "Your password is Weak";
        } else if (types == 2) {
            return "Your password is Fair";
        } else if (types == 3) {
            return "Your password is Good";
        } else if (types == 4) {
            return "Your password is Strong";
        }

        return "Error: Unable to check password strength.";
    }

    @Override
    public String toString() {
        return Value;
    }
}
