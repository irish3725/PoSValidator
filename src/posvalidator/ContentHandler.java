/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posvalidator;

import java.util.Queue;

/**
 *
 * @author alex
 */
public class ContentHandler {

    private StringBuilder content;

    public ContentHandler(StringBuilder s) {
        content = s;
    }

    public void test() {
        int count = 0;
        String start = "01011";
        StringBuilder cur = new StringBuilder();
        boolean valid = false;

        StringBuilder output = new StringBuilder();
        //gets each individual character from sting of bits 
        for (int i = 0; i < content.length() - 5; i++) {
            char c = 'q';
            //will hold string of bits for new character
            StringBuilder character = new StringBuilder();
            character.append(content.charAt(i));
            character.append(content.charAt(i + 1));
            character.append(content.charAt(i + 2));
            character.append(content.charAt(i + 3));
            character.append(content.charAt(i + 4));
            
            c = toChar(character.toString());
            
            if(c == ';'){
                output = new StringBuilder();
                output.append(c);
                valid = true;
            } else if (c == '?' && valid) {
                output.append(c);
                System.out.println(output.toString());
            } else if (c == 'q') {
                output = new StringBuilder();
                valid = false;
            } else {
                output.append(c);
            }
            
        }

    }

    public void findTrack2() {
        int count = 0;
        String start = "01011";
        StringBuilder cur = new StringBuilder();

        for (int i = 0; i < content.length(); i++) {

            cur.append(content.charAt(i));
            if (cur.length() > 5) {
                cur.deleteCharAt(0);
            }
            if (cur.length() == 5 && cur.toString().equals(start)) {
                i = findTrack2(i + 1, cur);
            }
        }
    }

    /*  findTrack2()
    *   takes in index of what is probably the beginning of a track2
    *   and finds out if it really is the beginning of a track2.
    *   If it really is a track2, it prints this track. returns the
    *   next index to start checking for a new track2.
     */
    public int findTrack2(int index, StringBuilder s) {
        StringBuilder cur = new StringBuilder();
        String end = "11111";
        boolean foundEnd = false;
        int nextIndex = index;

        for (int i = index; i < index + 210; i++) {
            s.append(content.charAt(i));
            if (cur.length() > 5) {
                cur.deleteCharAt(0);
            }
            if (cur.length() == 5 && cur.toString().equals(end)) {
                foundEnd = true;
                nextIndex = i + 1;
                break;
            }
        }

        if (foundEnd) {
            printTrack(s);
            return nextIndex;
        }
        return index + 210;
    }

    /*  printTrack()
    *   takes in a string of bits as a StringBuilder and prints the string
    *   of characters that those bits represent.
     */
    public void printTrack(StringBuilder s) {
        StringBuilder output = new StringBuilder();
        //gets each individual character from sting of bits 
        for (int i = 0; i < s.length(); i = i + 5) {
            //will hold string of bits for new character
            StringBuilder character = new StringBuilder();
            character.append(s.charAt(i));
            character.append(s.charAt(i + 1));
            character.append(s.charAt(i + 2));
            character.append(s.charAt(i + 3));
            character.append(s.charAt(i + 4));
            //gets character from string of bits and appends it to output
            output.append(toChar(character.toString()));
        }
        //prints final output
        System.out.println(output.toString());
    }

    /*  toChar()
    *   takes a in bits as a string and returns the character represented
    *   by that string of bits.
     */
    public char toChar(String s) {
        char c = 'q';
        switch (s) {
            case "10000":
                c = '0';
                break;
            case "00001":
                c = '1';
                break;
            case "00010":
                c = '2';
                break;
            case "10011":
                c = '3';
                break;
            case "00100":
                c = '4';
                break;
            case "10101":
                c = '5';
                break;
            case "10110":
                c = '6';
                break;
            case "00111":
                c = '7';
                break;
            case "01000":
                c = '8';
                break;
            case "11001":
                c = '9';
                break;
            case "11010":
                c = ':';
                break;
            case "01011":
                c = ';';
                break;
            case "11100":
                c = '<';
                break;
            case "01101":
                c = '=';
                break;
            case "01110":
                c = '>';
                break;
            case "11111":
                c = '?';
                break;
        }
        return c;
    }
}
