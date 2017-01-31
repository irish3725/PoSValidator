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

    String SS, FC, PAN, fName, lName, expY, expM, serviceCode,
            cvv, pin, dd;
    boolean valid = true;

    public Card(StringBuilder s) {
        buildCard(s);
    }
    
    public void buildCard(StringBuilder s) {
        int count = 0;
        while (s.length() > 0 && valid) {
            switch (count) {
                case 0:
                    SS = Character.toString(s.charAt(0));
                    count++;
                    s.deleteCharAt(0);
                    break;
                case 1:
                    FC = Character.toString(s.charAt(0));
                    count++;
                    s.deleteCharAt(0);
                    break;
                case 2:
                    StringBuilder num = new StringBuilder();
                    while (s.charAt(0) != '^') {
                        if (((int) s.charAt(0) < 47 && (int) s.charAt(0) > 58)
                                || s.length() < 2) {
                            valid = false;
                            break;
                        }
                        num.append(s.charAt(0));
                        s.deleteCharAt(0);
                    }
                    PAN = num.toString();
                    s.deleteCharAt(0);
                    count++;
                    break;
                case 3:
                    StringBuilder name = new StringBuilder();
                    while (s.charAt(0) != '/') {
                        if (name.length() > 26 || s.length() < 2) {
                            valid = false;
                            break;
                        }
                        name.append(s.charAt(0));
                        s.deleteCharAt(0);
                    }
                    fName = name.toString();
                    s.deleteCharAt(0);
                    count++;
                    break;
                case 4:
                    name = new StringBuilder();
                    while (s.charAt(0) != '^') {
                        if (name.length() > 26 || s.length() < 2) {
                            valid = false;
                            break;
                        }
                        name.append(s.charAt(0));
                        s.deleteCharAt(0);
                    }
                    lName = name.toString();
                    s.deleteCharAt(0);
                    count++;
                    break;
                case 5:
                    num = new StringBuilder();
                    // get expiration year
                    num.append(s.charAt(0));
                    s.deleteCharAt(0);
                    num.append(s.charAt(0));
                    s.deleteCharAt(0);
                    expY = num.toString();
                    // get expiration month
                    num = new StringBuilder();
                    num.append(s.charAt(0));
                    s.deleteCharAt(0);
                    num.append(s.charAt(0));
                    s.deleteCharAt(0);
                    expM = num.toString();
                    // get service code
                    num = new StringBuilder();
                    num.append(s.charAt(0));
                    s.deleteCharAt(0);
                    num.append(s.charAt(0));
                    s.deleteCharAt(0);
                    num.append(s.charAt(0));
                    s.deleteCharAt(0);
                    serviceCode = num.toString();
                    count++;
                    break;
                case 6:
                    num = new StringBuilder();
                    while ((int) s.charAt(0) > 47 && (int) s.charAt(0) < 58) {
                        num.append(s.charAt(0));
                        s.deleteCharAt(0);
                    }
                    if (s.length() == 0 || s.charAt(0) != '?') {
                        valid = false;
                        break;
                    } else {
                        dd = num.toString();
                        s.deleteCharAt(0);
                        break;
                    }
                default:
                    System.out.println("reached default in buildCard() Switch");
                    valid = false;
                    break;
            }
        }
    }

    public void printCard() {
        if (valid) {
            System.out.println("Cardholder's name: " + fName + " " + lName);
            System.out.println("Card Number: " + PAN);
            System.out.println("Expiration Date: " + expM + "/20" + expY);
        } else {
            System.out.println("not valid card");
        }
    }
}
