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

    }

    public void addCard(StringBuilder s) {
        Card[] temp = new Card[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            temp[i] = cards[i];
        }
        temp[cards.length] = new Card(s);
    }

}
