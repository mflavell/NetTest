/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nettest;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author matt
 */
public class NetTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket MyClient;
        if (args.length<2) {
            System.out.println("NetTest - By matt flavell ----------------------");
            System.out.println("Useage: nettest [server] [port]");
            System.out.println("https://github.com/mflavell/NetTest");
            System.out.println("------------------------------------------------");
        } else {
            if (isInteger(args[1])==false) {
                System.out.println("Invalid port number");
            } else  {
                long s_time = System.currentTimeMillis();
                try {                
                    MyClient = new Socket(args[0],Integer.parseInt(args[1]));
                    System.out.println("Connected ok");
                } catch (IOException e) {
                    String stack=e.getMessage();
                    if (stack.contentEquals(args[0])) {
                        System.out.println("Cannot resolve "+stack);
                    } else {
                        System.out.println(stack);
                    }
                } finally {
                    long e_time = System.currentTimeMillis();
                    long delay = e_time-s_time;
                    System.out.println("Took "+delay+" ms");
                }
            }
        }
    }
    
     public static boolean isInteger(String s) {
      boolean isValidInteger = false;
      try {
         Integer.parseInt(s);
         isValidInteger = true;
      } catch (NumberFormatException ex) {
         // s is not an integer
      } 
      return isValidInteger;
   }
    
}
