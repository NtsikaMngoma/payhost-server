package za.co.payhost.server.api.utils;

import java.util.Random;

/**
 * @author Ntsika Mngoma - 27/12/2020
 *
 */
public class UniqueIdGenerator {
	public String generateAlphaNumberic() {
		// create a string of upper-case and lower-case characters and numbers
	    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	    String numbers = "0123456789";

	    // combine all strings
	    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 6;
	    
	    for(int i = 0; i < length; i++) {

	        // generate random index number
	        int index = random.nextInt(alphaNumeric.length());

	        // get character specified by index
	        // from the string
	        char randomChar = alphaNumeric.charAt(index);

	        // append the character to string builder
	        sb.append(randomChar);
	      }
	    return "MGSA" + sb.toString();
	}
}
