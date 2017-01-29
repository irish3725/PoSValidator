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
public class PoSValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input;
        if(args.length == 0){
            input = "no input";
        } else{
            input = args[0];
        }
        System.out.println(input);
    }
    
}
