package jkolesik.cipher;
/**
 * Diese Klasse stellt eine Exception dar, die eine NumberFormatException erweitert.
 * @author jkolesik
 * @version 13-10-2018
 */
public class NotSuitableException extends NumberFormatException{

	public NotSuitableException(String text) {
		super(text);
	}
}
