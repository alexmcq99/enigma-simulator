public class Enigma {
    private Plugboard p;
    private Rotor right;
    private Rotor mid;
    private Rotor left;
    private Reflector ref;

    /**
     * Creates a new Enigma Machine object
     *
     * @param p the plugboard
     * @param right the rightmost rotor
     * @param mid the middle rotor
     * @param left the leftmost rotor
     * @param ref the reflector
     */
    public Enigma(Plugboard p, Rotor right, Rotor mid, Rotor left, Reflector ref) {
        this.p = p;
        this.right = right;
        this.mid = mid;
        this.left = left;
        this.ref = ref;
    }

    /**
     * Encrypts a letter with the enigma
     *
     * @param c the letter to encrypt
     * @return the encrypted letter
     */
    public char encryptChar(char c) {
        right.setJustRotated(false);
        mid.setJustRotated(false);
        left.setJustRotated(false);

        right.rotate();

        if (right.passedNotch()) {
            mid.rotate();
        } else if (mid.isNotched()) {
            mid.rotate();
        }
        if (mid.passedNotch() && mid.hasJustRotated()) {
            left.rotate();
        }

        char encrypted = p.plug(right.backwardScramble(mid.backwardScramble(left.backwardScramble(ref.reflect(left.forwardScramble(mid.forwardScramble(right.forwardScramble(p.plug(c)))))))));

        //System.out.println("\n\nOffsets:\nleft: " + (char)(left.getOffset() + 65) + "\tmid: " + (char)(mid.getOffset() + 65) + "\tright: " + (char)(right.getOffset() + 65) + "\n\n");
        //System.out.println("\n");
        return encrypted;
    }

    /**
     * Encrypts a String with the Enigma
     * @param s the String to encrypt
     * @return the encrypted String
     */
    public String encryptStr(String s) {
        String encrypted = "";
        for (int i = 0; i < s.length(); i++) {
            encrypted += encryptChar(s.charAt(i));
        }
        return encrypted;
    }
}
