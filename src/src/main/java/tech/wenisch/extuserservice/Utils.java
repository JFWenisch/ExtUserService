package tech.wenisch.extuserservice;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Random;

public class Utils {

	public static String generateShortHash(String input) {
        try {
            // Create a SHA-256 digest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Encode the hash in Base64
            String base64Hash = Base64.getUrlEncoder().withoutPadding().encodeToString(hash);

            // Return a shorter version of the hash (e.g., first 8 characters)

         // Convert Base64 to alphanumeric lowercase string 
           return base64Hash.replaceAll("[^a-z0-9]", "").toLowerCase().substring(0,12);
           
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }


	    public static String generateMnemonicPhrase(List<String> words, int numberOfWords) {
	        Random random = new Random();
	        StringBuilder mnemonicPhrase = new StringBuilder();

	        for (int i = 0; i < numberOfWords; i++) {
	            int index = random.nextInt(words.size());
	            mnemonicPhrase.append(words.get(index));
	            if (i < numberOfWords - 1) {
	                mnemonicPhrase.append("-");
	            }
	        }

	        return mnemonicPhrase.toString();
	    }
	

}
