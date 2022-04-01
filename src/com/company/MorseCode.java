package com.company;

import java.util.Objects;

/**
 * An object that holds a valid character and its corresponding morse code encoding.
 */
public class MorseCode {

    /**
     * A private final variable of type char that will hold a valid character.
     */
    private final char character;

    /**
     * A private final variable of type String that will hold the morse code encoding for a character.
     */
    private final String encoding;

    /**
     * The non-default constructor for this class object. It will throw an IllegalArgumentException if invalid parameters are passed.
     *
     * @param character a variable of type char is passed that wll be initialized to a MorseCode object if it is valid.
     * @param encoding  a variable of type encoding containing a morse code is passed that will be initialized to a MorseCode object if it is valid.
     */
    public MorseCode(char character, String encoding) {

        if (!(character >= 32 && character <= 90) || (Objects.equals(encoding, "")) || (encoding == null)) {
            throw new IllegalArgumentException("The character " + character + " with conversion " + encoding + " is invalid");
        }
        else {
            this.character = character;
            this.encoding = encoding;
        }
    }

    /**
     * Gets the character associated with a MorseCode object.
     *
     * @return returns the char type character associated with a MorseCode object.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Gets the morse code encoding associated with a MorseCode object.
     *
     * @return returns the string type encoding associated with a MorseCode object.
     */
    public String getEncoding() {
        return encoding;
    }
}