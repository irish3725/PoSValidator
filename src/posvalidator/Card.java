/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posvalidator;

/**
 *
 * @author alex
 */
public class Card {

    String SS, FC, PAN, fName, lName, exp, cvv, dd;

    public Card(StringBuilder s) {
        int valid = 0;
        while (s.length() > 0) {
            switch (valid) {
                case 0:
                    SS = Character.toString(s.charAt(0));
                    valid++;
                    s.deleteCharAt(0);
                    break;
                case 1:
                    FC = Character.toString(s.charAt(0));
                    valid++;
                    s.deleteCharAt(0);
                    break;
            }
        }
    }
}
