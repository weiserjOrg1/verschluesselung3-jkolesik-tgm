package jkolesik.cipher;

public class ShiftCipher extends MonoAlphabeticCipher{
	/**
	 * Konstruktor für die Klasse ShiftCipher	
	 * @param i übernimmt, um wie viele Stellen die Buchstaben verschoben werden sollen
	 */
	public ShiftCipher(int i) {
		shift(i);
	}
	/**
	 * die SetterMethode für den Shift
	 * @param i übernimmt, um wie viele Stellen die Buchstaben verschoben werden sollen
	 */
	public void setextFieldShiftValueValue(int i) {
		if(i != 0) {
			shift(i);
		}
	}
	/**
	 * Diese Methode shiftet das Alphabet um soviele Stellen, wie es vom Benutzer eingegeben wurde
	 * @param i übernimmt, um wie viele Stellen die Buchstaben verschoben werden sollen
	 */
	private void shift(int i){
		char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
					   'u','v','w','x','y','z'};
		char[] newAlph = new char[alph.length];
		for(int j = 0; j < i; j++) {
			newAlph[0] = alph[alph.length-1];
			for(int x = 1; x < alph.length; x++) {
				newAlph[x] = alph[x-1];
			}
			alph = newAlph;
			if(j != i-1) {
				newAlph = new char[alph.length];
			}
			
		}
		if(i != 0) {
			String alphabet = "";
			for(int y = 0; y < newAlph.length; y++) {
				alphabet += newAlph[y]+"";
			}
			super.setSecretAlphabet(alphabet);
		}else {
			String alphabet = "";
			for(int y = 0; y < alph.length; y++) {
				alphabet += alph[y]+"";
			}
			super.setSecretAlphabet(alphabet);
		}
	}
}