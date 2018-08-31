public class Plugboard {
    private char[] output;

    /**
     * Creates a new Plugboard object
     *
     * @param swaps the String containing each pair of letters to be swapped.
     *              Each pair of letters in the String, starting from the letters
     *              at indices 0 and 1, will be considered a pair to be swapped
     *              with the plugboard.  The letters must be uppercase.
     * @throws java.lang.IllegalArgumentException if swaps isn't formatted correctly
     */
    public Plugboard(String swaps) {
        //Check if the length of swaps is odd
        if (swaps.length() % 2 == 1) {
            throw new IllegalArgumentException("The given String must have even length.");
        }

        //Set up default plugboard before adding customizations
        //Each letter will be set to itself
        output = new char[26];
        for (int i = 0; i < output.length; i++) {
            output[i] = (char)(i + 65);
        }

        //Include customized swaps for the plugboard
        for (int i = 0; i < swaps.length(); i++) {
            char c = swaps.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (i % 2 == 0) {
                    output[c - 65] = swaps.charAt(i + 1);
                } else {
                    output[c - 65] = swaps.charAt(i - 1);
                }
            } else if (c >= 'a' && c <= 'z') {
                throw new IllegalArgumentException("Letters must be uppercase.");
            } else {
                throw new IllegalArgumentException("Only letters are allowed in the plugboard.");
            }
        }
    }

    /**
     * Creates a new Plugboard object with default swaps, so everything is mapped to itself
     */
    public Plugboard() {
        this("");
    }

    /**
     * Performs the plugboard's swap on the given character
     *
     * @param c the character to swap
     * @return the swapped character
     */
    public char plug(char c) {
        return output[c - 65];
    }
}
