import java.io.*;
import java.util.Scanner;

public class EnigmaSimulator {
    public static void main(String[] args) throws Exception {
        String input = "";
        String output = "";
        Plugboard p = new Plugboard();
        Rotor right = new Rotor(3);
        Rotor mid = new Rotor(2);
        Rotor left = new Rotor(1);
        Reflector ref = Reflector.B;

        int i = 0;
        while (i < args.length) {
            if (args[i].equals("-inputfile")) {
                //check if there is a valid argument following this flag
                if (i + 1 == args.length || args[i + 1].charAt(0) == '-') {
                    throw new IllegalArgumentException("You must include a file path after the flag \"-inputfile\"");
                }

                //put file into string
                File file = new File(args[i + 1]);
                Scanner sc = new Scanner(file);
                sc.useDelimiter("\\Z");
                input = sc.next();

                i += 2;
            } else if (args[i].equals("-outputfile")) {
                //check if there is a valid argument following this flag
                if (i + 1 == args.length || args[i + 1].charAt(0) == '-') {
                    throw new IllegalArgumentException("You must include a file path after the flag \"-outputfile\"");
                }

                output = args[i + 1];
                i += 2;
            } else if (args[i].equals("-string")) {
                //check if there is a valid argument following this flag
                if (i + 1 == args.length || args[i + 1].charAt(0) == '-') {
                    throw new IllegalArgumentException("You must include a String after the flag \"-string\"");
                }

                input = args[i + 1];
                i += 2;
            } else if (args[i].equals("-rightrotor")) {
                //check if there is a valid argument following this flag
                if (i + 1 == args.length || i + 2 == args.length || args[i + 1].charAt(0) == '-' || args[i + 2].charAt(0) == '-') {
                    throw new IllegalArgumentException("You must include a rotor number and a starting position (letter) after the flag \"-rightrotor\"");
                }

                right = new Rotor(Integer.parseInt(args[i + 1]), args[i + 2].charAt(0));
                i += 3;
            } else if (args[i].equals("-midrotor")) {
                //check if there is a valid argument following this flag
                if (i + 1 == args.length || i + 2 == args.length || args[i + 1].charAt(0) == '-' || args[i + 2].charAt(0) == '-') {
                    throw new IllegalArgumentException("You must include a rotor number and a starting position (letter) after the flag \"-midrotor\"");
                }

                mid = new Rotor(Integer.parseInt(args[i + 1]), args[i + 2].charAt(0));
                i += 3;
            } else if (args[i].equals("-leftrotor")) {
                //check if there is a valid argument following this flag
                if (i + 1 == args.length || i + 2 == args.length || args[i + 1].charAt(0) == '-' || args[i + 2].charAt(0) == '-') {
                    throw new IllegalArgumentException("You must include a rotor number and a starting position (letter) after the flag \"-leftrotor\"");
                }

                left = new Rotor(Integer.parseInt(args[i + 1]), args[i + 2].charAt(0));
                i += 3;
            } else if (args[i].equals("-reflector")) {
                //check if there is a valid argument following this flag
                if (i + 1 == args.length || args[i + 1].charAt(0) == '-') {
                    throw new IllegalArgumentException("You must include a reflector letter after the flag \"-reflector\"");
                }

                if (args[i + 1].equals("A")) {
                    ref = Reflector.A;
                } else if (args[i + 1].equals("B")) {
                    ref = Reflector.B;
                } else {
                    ref = Reflector.C;
                }
                i += 2;
            } else if (args[i].equals("-plugboard")) {
                //check if there is a valid argument following this flag
                if (i + 1 == args.length || args[i + 1].charAt(0) == '-') {
                    throw new IllegalArgumentException("You must include a String of pairs of letters after the flag \"-plugboard\"");
                }

                p = new Plugboard(args[i + 1]);
                i += 2;
            } else if (args[i].charAt(0) == '-') {
                throw new IllegalArgumentException(args[i] + " is not a valid flag.");
            } else {
                throw new IllegalArgumentException(args[i] + " wasn't properly flagged.");
            }
        }

        if (input.equals("")) {
            throw new IllegalArgumentException("You did not specify a file or String for your input.");
        }

        //remove non alphabetical characters
        input.replaceAll("[^A-Za-z]+", "");
	input = input.toUpperCase();

        Enigma machine = new Enigma(p, right, mid, left, ref);
        String encrypted = machine.encryptStr(input);

        if (output.equals("")) {
            System.out.println(encrypted);
        } else {
            try {
                File file = new File (output);
                BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
                out.write(encrypted);
                out.flush();
                out.close();
            } catch(FileNotFoundException e) {
                System.out.println("File not found");
            } catch(IOException e) {
                System.out.println("IOException found");
            }
        }
    }
}
