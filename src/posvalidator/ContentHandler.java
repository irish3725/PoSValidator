/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posvalidator;

import static java.lang.Math.pow;
import java.util.Queue;

/**
 *
 * @author alex
 */
public class ContentHandler {

    private StringBuilder content;
    private Card[] cards = new Card[0];

    public ContentHandler(StringBuilder s) {
        content = s;
    }

    public void findTracks() {
        //start checking each bit
        for (int i = 0; i < content.length() - 8; i++) {
            //if bit is 1, the following byte cannot be a character
            if (content.charAt(i) != '1') {
                StringBuilder character = new StringBuilder();
                int charVal = 0;
                for (int j = 0; j < 8; j++) {
                    if (content.charAt(i + j) == '1') {
                        charVal = charVal + (int) pow(2, 7 - j);
                    }
                }
                char c = (char) charVal;
                character.append(content.charAt(i));
                character.append(content.charAt(i + 1));
                character.append(content.charAt(i + 2));
                character.append(content.charAt(i + 3));
                character.append(content.charAt(i + 4));
                character.append(content.charAt(i + 5));
                character.append(content.charAt(i + 6));
                character.append(content.charAt(i + 7));
//                System.out.println("bin: " + character.toString() + "   dec: "
//                        + charVal + " char: " + c);
                if (c == '%') {
                    i = findTrack1(i);
                } else if (c == ';') {
                    i = findTrack2(i);
                }
            }
        }
    }

    public int findTrack1(int index) {
        StringBuilder track1 = new StringBuilder();
        StringBuilder PAN = new StringBuilder();
        StringBuilder fName = new StringBuilder();
        StringBuilder lName = new StringBuilder();
        StringBuilder exp = new StringBuilder();
        StringBuilder cvv = new StringBuilder();
        StringBuilder dd = new StringBuilder();
        for (int i = index; i < index + 10000; i = i + 8) {
            int charVal = 0;
            for (int j = 0; j < 8; j++) {
                if (content.charAt(i + j) == '1') {
                    charVal = charVal + (int) pow(2, 7 - j);
                }
            }
            //if charVal is '?'
            if (charVal == 63) {
                track1.append((char) charVal);
                if(track1.charAt(1) == 'B'){
                    addCard(track1);
                    System.out.println("Track 1: " + track1.toString());
                }
                return i;
            } else {
                track1.append((char) charVal);
            }
        }

        return index;
    }
    
    public int findTrack2(int index) {
        StringBuilder track2 = new StringBuilder();
        for (int i = index; i < index + 400; i = i + 8) {
            int charVal = 0;
            for (int j = 0; j < 8; j++) {
                if (content.charAt(i + j) == '1') {
                    charVal = charVal + (int) pow(2, 7 - j);
                }
            }
            //if charVal is '?'
            if (charVal == 63) {
                track2.append((char) charVal);
                System.out.println("Track 2: " + track2.toString());
                return i;
            } else {
                track2.append((char) charVal);
            }
        }

        return index;
    }

    public void addCard(StringBuilder s) {
        Card[] temp = new Card[cards.length + 1];
        for(int i = 0; i < cards.length; i++){
            temp[i] = cards[i];
        }
        temp[cards.length] = new Card(s);
    }
    
}
