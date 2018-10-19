package jkolesik.cipher;
import javax.swing.JOptionPane;
/**
 * Diese Klasse stellt die Möglichkeit zur monoalphabetischen Verschlüsselung und Entschlüsselung dar.
 * @author jkolesik
 * @version 10.10.2018
 */

public class MonoAlphabeticCipher implements Cipher{

	private String secretAlphabet;//in dieser Variable wird das secretAlphabet gespeichert 
	/**
	 * Konstruktor der Klasse MonoAlphabeticCipher 
	 */
	public MonoAlphabeticCipher(){
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz"; //Setzt zu Beginn das Referenzalphabet
	}
	/**
	 * Getter-Methode des SectetAlphabet-Attributes
	 * @return gibt das Attribut SecretAlphabet zurück
	 */
	public String getSecretAlphabet(){
		return this.secretAlphabet;
	}
	
	/**
	 * Diese Methode setzt das Geheimalphabet und überprüft es mit 2 Hilfsmethoden, die weiters beschrieben werden.
	 * @param secretAlphabet
	 */
	
	protected void setSecretAlphabet(String secretAlphabet)throws NotSuitableException{
		secretAlphabet.toLowerCase();
		if(secretAlphabet.length() == this.secretAlphabet.length() && checkForMoreThanOne(secretAlphabet) == false && containsAlphabet(secretAlphabet) == true){
			this.secretAlphabet = secretAlphabet;
		}else {
			NotSuitableException suit = new NotSuitableException("Bitte ein g�ltiges SecretAlphabet eingeben");
			throw suit;
		}
	}
	
	/**
	 * Überprüft das Geheimalphabet auf das mehrmalige Vorkommen von Buchstaben und falls es so, ist return es false. 
	 * @param secretAlphabet übernimmt das zu überprüfende secretAlpahet
	 * @return gibt false zurück, wenn das secretAlphabet nicht den Prüfunden entspricht, true wenn schon.
	 */
	
	private boolean checkForMoreThanOne(String secretAlphabet) {
		for(int i = 0; i < secretAlphabet.length(); i++){
			if(secretAlphabet.indexOf(secretAlphabet.charAt(i)) == secretAlphabet.lastIndexOf(secretAlphabet.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * hier wird überprüft, ob das zu setzende secretAlphabet alle (und nur) Buchstaben des "normalen"
	 * Alphabets enthalten
	 * @param secretAlphabet übernimmt das zu setzende secretAlpahet
	 * @return gibt false zurück, wenn das secretAlphabet nicht den Regeln entspricht, true wenn schon.
	 */
	private boolean containsAlphabet(String secretAlphabet) {
		String alph = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < secretAlphabet.length(); i++) {
			if(secretAlphabet.indexOf(alph.charAt(i)) == -1){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Diese Methode verschlüsselt den Text nach der monoalphabetischen Verschlüsselung und gibt ihn anschließend zurück.
	 * @param text übernimmt den zu verschlüsselnden Text
	 * @return gibt den verschlüsselten Text zurück
	 */
	
	public String encrypt(String text) throws NotSuitableException{
		String newText = "";
		if(text != null && text != "") {
			text = text.toLowerCase();
			String referenceAlphabet = "abcdefghijklmnopqrstuvwxyz"; //Standard-Alphabet
			for(int i = 0; i < text.length(); i++) {
				try {
					newText += this.secretAlphabet.charAt(referenceAlphabet.indexOf(text.charAt(i)));
				}catch(StringIndexOutOfBoundsException e) {
					newText += text.charAt(i)+"";
				}
			}
		}else {
			NotSuitableException suit = new NotSuitableException("Parameter ist nicht zulässig; Muss ungleich leer oder null sein ");
			throw suit;
		}
		return newText;	
	}
	
	/**
	 * Diese Methode entschlüsselt einen verschlüsselten Text und gibt ihn zurück.
	 * @param text übernimmt den zu entschlüsselnden Text
	 * @return gibt den entschlüsselten Text zurück 
	 */
	
	public String decrypt(String text)throws NotSuitableException{
		String newText = "";
		if(text != null && text != "") {
			text = text.toLowerCase();
			String referenceAlphabet = "abcdefghijklmnopqrstuvwxyz";
			for(int i = 0; i < text.length(); i++) {
				try {
					newText += referenceAlphabet.charAt(this.secretAlphabet.indexOf(text.charAt(i)));
				}catch(StringIndexOutOfBoundsException e) {
					newText += text.charAt(i)+"";
				}
			}
		}else {
			NotSuitableException suit = new NotSuitableException("Parameter ist nicht zulässig; Muss ungleich leer oder null sein");
			throw suit;
		}
		return newText;
	}
}