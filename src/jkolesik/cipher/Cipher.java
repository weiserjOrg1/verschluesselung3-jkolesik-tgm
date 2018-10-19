package jkolesik.cipher;

/**
 * Dieses Interface stellt die abstrakten Methoden encrypt und decrypt für die folgenden Cipher bereit.
 * @author jkolesik
 * @version 10.10.2018
 */
public interface Cipher {
	public String encrypt(String text);
	public String decrypt(String text);
}
