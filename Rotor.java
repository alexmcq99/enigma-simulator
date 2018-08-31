public class Rotor {
    private char[] output;
    private int offset;
    private int turnoverPos;
    private boolean justRotated;

    /**
     * Creates a new rotor of a given number and starting position
     *
     * @param rotorNum the number of the rotor (Enigma I rotors)
     * @param startingPos the starting position, with 'A' being 0, 'B' being 1, etc.
     */
    public Rotor(int rotorNum, char startingPos) {
        //Sets output array and turnover position according to the rotor number
        if (rotorNum == 1) {
            output = new char[]{'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'};
            turnoverPos = 17;
        } else if (rotorNum == 2) {
            output = new char[]{'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
            turnoverPos = 5;
        } else if (rotorNum == 3) {
            output = new char[]{'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O'};
            turnoverPos = 22;
        } else if (rotorNum == 4) {
            output = new char[]{'E','S','O','V','P','Z','J','A','Y','Q','U','I','R','H','X','L','N','F','T','G','K','D','C','M','W','B'};
            turnoverPos = 10;
        } else if (rotorNum == 5) {
            output = new char[]{'V','Z','B','R','G','I','T','Y','U','P','S','D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K'};
            turnoverPos = 0;
        }

        //set the starting position
        this.offset = startingPos - 65;

        //set justRotated
        justRotated = false;
    }

    /**
     * Creates a new Rotor object with the default starting position of 'A'
     * @param rotorNum the number of the rotor (Enigma I rotors)
     */
    public Rotor(int rotorNum) {
        this(rotorNum, 'A');
    }

    /**
     * Scrambles a character forwards through the given rotor
     *
     * @param c the character to scramble
     * @return the scrambled character
     */
    public char forwardScramble(char c) {
        //System.out.println("Forwards: Current Offset: " + (char)(offset + 65) + ", " + "Took in " + c + ", offset it to " + (char)(((c - 65 + offset) % 26) + 65) + ", changed it to " + output[(c - 65 + offset) % 26] + ", and de-offset to " + (char)(((output[(c - 65 + offset) % 26] - 65 - offset + 26) % 26) + 65));
        return (char)(((output[(c - 65 + offset) % 26] - 65 - offset + 26) % 26) + 65);
    }

    /**
     * Scrambles a character backwards through the given rotor
     *
     * @param c the character to scramble
     * @return the scrambled character
     */
    public char backwardScramble(char c) {
        for (int i = 0; i < output.length; i++) {
            if ((char)(((c - 65 + offset) % 26) + 65) == output[i]) {
                //System.out.println("Backwards: Took in " + c + ", offset it to " + (char)(((c - 65 + offset) % 26) + 65) + ", changed it to " + (char)(i + 65) + ", and de-offset to " + (char)(((i - offset + 26) % 26) + 65));
                return (char)(((i - offset + 26) % 26) + 65);
            }
        }
        return ' ';
    }

    /**
     * Rotates the rotor
     */
    public void rotate() {
        offset++;
        offset %= 26;
        justRotated = true;
    }

    /**
     * @return if the rotor is in the notch position
     */
    public boolean isNotched() {
        return offset == ((turnoverPos + 25) % 26);
    }
    /**
     * @return if the rotor just passed the notch
     */
    public boolean passedNotch() {
        return offset == turnoverPos;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Sets the instance variable justRotated
     *
     * @param justRotated the value to set the instance variable justRotated to
     */
    public void setJustRotated(boolean justRotated) {
        this.justRotated = justRotated;
    }

    /**
     * @return if the rotor has just rotated
     */
    public boolean hasJustRotated() {
        return justRotated;
    }
}
