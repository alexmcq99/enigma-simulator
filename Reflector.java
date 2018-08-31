public enum Reflector {
    A (new char[]{'E','J','M','Z','A','L','Y','X','V','B','W','F','C','R','Q','U','O','N','T','S','P','I','K','H','G','D'}),
    B (new char[]{'Y','R','U','H','Q','S','L','D','P','X','N','G','O','K','M','I','E','B','F','Z','C','W','V','J','A','T'}),
    C (new char[]{'F','V','P','J','I','A','O','Y','E','D','R','Z','X','W','G','C','T','K','U','Q','S','B','N','M','H','L'});

    private char[] output;

    /**
     * Creates a new Reflector object
     *
     * @param output the mapping of each letter depending on its index ('A' is 0, 'B' is 1, etc.)
     */
    Reflector(char[] output) {
        this.output = output;
    }

    /**
     * Reflects a given character
     * @param c the character to reflect
     * @return the reflected character
     */
    public char reflect(char c) {
        return output[(int)(c - 65)];
    }
}
