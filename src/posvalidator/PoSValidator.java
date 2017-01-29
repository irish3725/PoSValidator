/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posvalidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alex
 */
public class PoSValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;
        String FILENAME = "~/test.txt";

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            br = new BufferedReader(new FileReader(FILENAME));
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

//        String input;
//        if (args.length == 0) {
//            input = "no input";
//        } else {
//            input = args[0];
//        }
//        System.out.println(input);
    }

}
