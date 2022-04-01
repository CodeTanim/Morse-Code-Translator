package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *  A class that can be used to convert a character, a string or a file into its corresponding morse code and display the results.
 */
public class Translator {
    // To throw the FileNotFound exception in the constructor, use the try block to open the file
    // and if that fails the compiler will automatically throw a FileNotFound exception, you are gonna then
    // use the catch block to catch that exception and throw it in that block with a specific message. What that will do
    // is send the exception to the method calling the constructor.

    /**
     * An ArrayList of type MorseCode. It is used to store MorseCode objects which contain characters and their morse code encoding.
     */
    private final ArrayList <MorseCode> listMorseCodes = new ArrayList <> ();

    /**
     * The non-default constructor for the Translator class. It takes in the file containing the morse code conversions,
     * and stores them in an ArrayList if they are valid.
     * @param fileName The name of the file is passed as a string.
     * @throws FileNotFoundException If failed to open the file throw this exception.
     */
    public Translator(String fileName) throws FileNotFoundException {

        Scanner file;

        try {
            file = new Scanner(new File(fileName)); // opens the file
            // Now need to read the contents of the file and store it in the array list.

            while (file.hasNextLine()) {
                // need to skip lines that don't have two entries (array size != 2 ) and if the line is empty.

                String line = file.nextLine(); // read one line from the input file
                String[] arrTokens = line.split(";"); // Split over
                // Each tokenized array will pass the element in the 0th and 1st position to the
                // non default constructor of the MorseCode object in the arraylist.

                if (arrTokens.length != 2) {

                    if (Objects.equals(line, "")) {
                        // Skips the entire the iteration of the loop when a blank or empty line is encountered.
                        continue;
                    }
                    System.out.println("Got an invalid line: " + line); // Prints an error message for a line that is not blank but still invalid since it doesn't have two entries.
                }
                else {
                    // When initializing the MorseCode object, the arguments passed may not be valid, in which case we need to handle the IllegalArgumentException
                    // that the MorseCode class will throw.
                    try {
                        char[] character = arrTokens[0].toCharArray(); // Convert the string at the index = 0 of the tokenized array into a character, so we can pass it.
                        MorseCode obj = new MorseCode(character[0], arrTokens[1]); // A new MorseCode object with valid input for character and encoding is created.
                        listMorseCodes.add(obj); // That object is added to the arraylist containing MorseCode objects.
                    }
                    catch (IllegalArgumentException ex2) {
                        System.out.println(ex2.getMessage()); // Prints any error caught by initializing the MorseCode object.
                    }

                }
            }

        }
        catch (FileNotFoundException ex1) {
            throw new FileNotFoundException("Failed to open file: " + fileName);
        }

        file.close(); // Deallocate.

    }

    /**
     * Prints the contents of the ArrayList which contains all valid characters and their morse code encodings.
     */
    public void printList() {

        System.out.println();
        for (MorseCode obj: listMorseCodes) {
            System.out.printf(" '%s' %s %s %n", obj.getCharacter(), " => ", '"' + obj.getEncoding() + '"'); // Print the character and its morse code encoding side by side.
        }
    }

    /**
     * Gets a MorseCode object from our ArrayList.
     * @param c A char type variable is passed.
     * @return A MorseCode object is returned IF the character passed as the argument matches the character from a MorseCode object in the MorseCode ArrayList.
     * Otherwise, if a match is not found, null is returned.
     */
    public MorseCode get(char c) {
        for (MorseCode obj: listMorseCodes) {
            if (c == obj.getCharacter()) {
                return obj;
            }
        }
        return null;
    }

    /**
     * Converts a string to a morse code and prints that morse code.
     * @param s The string to be converted is passed as the parameter.
     */
    public void convert(String s) {
        // First covert the string to a character array.
        // Then convert the entire array of characters to uppercase since morse code doesn't care about case,
        // and we only have the morse code conversions for the upper case stored.

        // Handling empty or null string
        if (s == null || s.equals("")) {
            return;
        }

        // Convert input string to a character array
        char[] character = s.toCharArray();

        // Convert all letters to uppercase
        int n = character.length;
        for (int i = 0; i < n; i++) {
            character[i] = Character.toUpperCase(character[i]);
        }

        // Find the morse code encoding for each character of the original inputted string and print it.
        for (char c: character) {
            MorseCode obj = get(c);
            if (obj != null) {
                String encoding = obj.getEncoding();
                System.out.print(encoding + " ");
            }

            else {
                if(c!= ' ') {
                    System.out.print("? ");
                }
            }
        }
        System.out.println();
    }

    /**
     * Converts and prints the corresponding morse code for an entire file.
     * @param fileName The name of the file to be converted and printed is passed as a string parameter.
     * @throws FileNotFoundException An exception with a message is thrown when the method fails to open the file.
     */
    public void convertFile(String fileName) throws FileNotFoundException {
        // Prints the corresponding Morse code for the entire file.
        // Basically a large scale version of the convert method.
        Scanner file;
        try {
            file = new Scanner(new File(fileName)); // Tries opening the file. Will throw an exception if file not found.
            while (file.hasNextLine()) {
                String line = file.nextLine();
                convert(line);
            }
        }
        catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Failed to open file: " + fileName);
        }
        file.close();
    }

}
