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
        for (int i = 0; i < content.length(); i++){
            if(content.charAt(i) == '%' && content.charAt(i+1) == 'B') {
                i = findTrack1(i);
            }
        }
    }
    
    public int findTrack1(int index) {
        StringBuilder track1 = new StringBuilder();
        for (int i = index; i < content.length(); i++){
            if(content.charAt(i) == '?'){
                track1.append(content.charAt(i));
                System.out.println("Track 1: " + track1.toString());
                addCard(track1);
                return i + 1;
            } else if (i > index + 100) {
                return index + 1;
            } else {
                track1.append(content.charAt(i));
            }
        }
        
        return index;
    }

    public void addCard(StringBuilder s) {
        Card card = new Card(s);
        card.printCard();
//        Card[] temp = new Card[cards.length + 1];
//        for (int i = 0; i < cards.length; i++) {
//            temp[i] = cards[i];
//        }
//        temp[cards.length] = new Card(s);
    }
    
    public void printCards() {
        System.out.println("There is " + cards.length + " piece of credit "
                + "card information in the memory data!");
        for (int i = 0; i < cards.length; i++) {
            System.out.println("<Information of credit card " + i + ">:");
            cards[i].printCard();
        }
    }

}
