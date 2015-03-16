/**
 * @author sakshyamdahal
 *
 */
public class CaesarCipher {
	// encryption and decryption array
	private char[] encoder = new char[26];
	private char[] decoder = new char[26];

	public CaesarCipher(int rotation)
	{
		// encoder and decoder initialization based on rotation key
		for (int i = 0; i < 26; i++)
		{
			encoder[i] = (char) ('A' + (i+rotation)%26);
			decoder[i] = (char) ( 'A' + (i + 26 - (rotation)%26) %26);
		}

	}

	// encrypt a message
	public String encrypt(String message)
	{
		return transform(message, encoder);
	}
	
	// decrypt a message
	public String decrypt(String message)
	{
		return transform(message, decoder);
	}
	
	// transform a message with a given transformation array
	public String transform(String message, char[] transformer)
	{
		char[] msg = message.toUpperCase().toCharArray();
		int index;
		for (int i = 0; i < msg.length; i++)
		{
			// only perfrom transformation if the character is alphabetic
			if (Character.isAlphabetic(msg[i]))
			{
				index = msg[i] - 'A';
				
				// preserve the case
				if (Character.isLowerCase(message.charAt(i)))
					msg[i] = Character.toLowerCase(transformer[index]);
				else
					msg[i] = transformer[index];
			}
			
		}
		
		return new String(msg);
	}
	
}
