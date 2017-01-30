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
        String FILENAME = "memorydump.dmp";
        StringBuilder contents = new StringBuilder();
        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            br = new BufferedReader(new FileReader(FILENAME));
            while ((sCurrentLine = br.readLine()) != null) {
//                String s = "foo";
                byte[] bytes = sCurrentLine.getBytes();
                StringBuilder binary = new StringBuilder();
                for (byte b : bytes) {
                    
                    int val = b;
                    for (int i = 0; i < 8; i++) {
                        contents.append((val & 128) == 0 ? 0 : 1);
                        binary.append((val & 128) == 0 ? 0 : 1);
                        val <<= 1;
                    }
                }
//                System.out.println(/*"'" + sCurrentLine + "' to binary: " + */binary);
//                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
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
        
        ContentHandler c = new ContentHandler(contents);
        c.findTracks();
//        System.out.print(contents);
        
        
    }

}
