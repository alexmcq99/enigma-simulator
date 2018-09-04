Simulation of the German Enigma I Machine
by Alex McQuilkin

This simulation of the Enigma I includes options for the plugboard, order and
starting positions of the rotors, as well as the reflector.
It's written in Java, and must be executed from the command line.  The class
files are already included, so compilation is not necessary.

Arguments:
-inputfile [path to input file] --> Argument containing the path to a file containing the input for the enigma machine.  This argument can be omitted and replaced with the -string [input string] argument.
-string [input string] --> Argument containing the string to be encrypted by Enigma.  This argument can be omitted and replaced with the -inputfile [path to input file] argument, but one of them must be present.
-outputfile [path to output file] --> Optional argument containing the path to a file where the output of Enigma will be written.  If this argument is omitted, the output will simply be printed to the screen.
-leftrotor [rotor number] [starting position] --> Optional argument containing the rotor number and starting position of the leftmost (slowest) rotor.  The rotor number can be 1-5, and the starting position can be A-Z (must be a capital letter).  If this argument is omitted, the leftmost rotor will default to rotor #1 with starting position A.
-midrotor [rotor number] [starting position] --> Optional argument containing the rotor number and starting position of the middle (double stepping) rotor.  The rotor number can be 1-5, and the starting position can be A-Z (must be a capital letter).  If this argument is omitted, the middle rotor will default to rotor #2 with starting position A.
-rightrotor [rotor number] [starting position] --> Optional argument containing the rotor number and starting position of the rightmost (fastest) rotor.  The rotor number can be 1-5, and the starting position can be A-Z (must be a capital letter).  If this argument is omitted, the leftmost rotor will default to rotor #3 with starting position A.
-reflector [reflector letter] --> Optional argument containing the reflector letter, either A, B, or C.  If omitted, the reflector will default to B.
-plugboard [letter swap string] --> Optional argument containing a string of letters to swap with the plugboard.  The letter must be upper case, and each pair of letters in the string will be swapped in the plugboard.  Each letter not specified will be routed to itself.  If this argument is omitted, then the plugboard will simply route each letter to itself.

Examples:

java EnigmaSimulator -string ABCDE

This will set up an Enigma I machine with rotors 1, 2, and 3, from left to right, all in position A.  The reflector will be reflector B and the plugboard will route every letter to itself.  As the program finishes executing, it will print BJELR, which is what ABCDE routes to when encrypted by Enigma with these settings.

java EnigmaSimulator -inputfile input.txt -outputfile output.txt -leftrotor 3 A -midrotor 2 B -rightrotor 1 C -reflector C -plugboard AXCYBGDU

This will set up an Enigma I machine with rotors 3, 2, and 1, from left to right, in settings A, B, and C, respectively.  The plugboard for this Enigma I machine will also be set up to swap letter pairs A and X, C and Y, B and G, as well as D and U.  All other letters will be routed to themselves in the plugboard.  The program will read in a file called "input.txt" within the same directory as the source code and write the encrypted text to a file called "output.txt" within the same directory.  Any non-letter characters in "input.txt" will be removed and any lower case letters will be converted to uppercase to make encryption easier.