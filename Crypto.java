//Mdnazmul islam arman
import java.util.*;
public class Crypto {

    private static String msg;
    private static String msgE;
    private static String msgD;
    private static int key;

    public static void main(String[] args){
        //TODO: You can only call methods in main method
        int key = generateKey();
        String msg = generateMsg();
        String msgE = encryption(key,msg);
        
        String dec = decryption(key, msgE);
        System.out.println(msg);
        System.out.println(msgE);
        System.out.println(dec);
        System.out.println(bruteForce(msgE));
    }
    //method to geneate random 16 bit key
    private static int generateKey() {
        //TODO: implement step a (randomly generate 16-bit key)
        Random r = new Random();
        int rand1= r.nextInt(65536);
        return rand1;
    }
    //method to create random string message size 20
    private static String generateMsg() {
        //TODO: implement step b (randonly generate a string with an even number of characters)
        String SALTCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        //this method will create random string of length 20
         while (salt.length()<20)
		   {
			int index = (int)(rnd.nextFloat()* SALTCHAR.length());
			salt.append(SALTCHAR.charAt(index));
		   }

        return salt.toString();
    }
    //
    private static String encryption(int key, String msg) 
    {
        //TODO: implement step c (encrypt the message)
        int oi;
        int l= msg.length()/2;
        //orring the key half the time of the length of random generated string
        for(int u=0;u<l;u++)
        {
        	key = key | key;
        }
        //string builder to add the encrypted chars to the stringBuilder  
        StringBuilder xx = new StringBuilder(msg.length());
        
		  for(int i = 0; i < msg.length(); i++)
        {    
        oi = (Integer.valueOf(msg.charAt(i)) ^ key);
        char ch = (char)oi;
        xx.append(ch);
        
        }
		  // converting the stringBuilder to the string
        return xx.toString();
    }

    private static String decryption(int key, String msgE) {
        //TODO: implement step d (decryption)
        String s = msgE;
        StringBuilder yy = new StringBuilder(msgE.length());
        for(int i=0; i<s.length();i++)
        {
         char c =s.charAt(i);
         int o =Integer.valueOf(msgE.charAt(i));
         int p = o ^ key;
         char ch1 = (char)p;
         yy.append(ch1);
          
         }
        return yy.toString();
    }
    // Brute force method use a key of 16 bit to decrypt the data.
    private static String bruteForce(String msgE) {
        //TODO: implement bruteForce algorithm, you may need the above decryption(key,msgE) method
        int key = 45731;
        String s = msgE;
        StringBuilder yy = new StringBuilder(msgE.length());
        for(int i=0; i<s.length();i++)
        {
         char c =s.charAt(i);
         int o =Integer.valueOf(msgE.charAt(i));
         int p = o ^ key;
         char ch1 = (char)p;
         yy.append(ch1);
          
         }
        return yy.toString();
    }
}
