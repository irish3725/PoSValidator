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
    String FC, PAN, fName, lName, exp, cvv, dd;
    
    public Card(StringBuilder s){
        int valid = 0;
        while(s.length() > 0){
            if(valid == 0) {
                char c = s.charAt(0);
                FC = Character.toString(c);
                System.out.println(FC);
                s.deleteCharAt(0);
            }
        }
    }
    
}
