package jkolesik.cipher;

import javax.swing.JOptionPane;

public class KeywordCipher extends MonoAlphabeticCipher{
	private String keyword;
	public KeywordCipher(String d) {
		this.keyword = d;
	}
	
	public void setKeyword(String d) throws NotSuitableException {
		for (int i = 0; i<d.length();i++) {
			int pos = i;
				for (int j = 0; j<d.length();j++) {
					if (pos == j) {
						
					}else if (d.charAt(i) == d.charAt(j)) {
						NotSuitableException suit = new NotSuitableException("Im Keyword existiert mehrfach der selbe Buchstabe");
						throw suit;
					}
				}
		}
		
		this.keyword = d.toUpperCase();
		String temp = "";
		for (int i = 0; i<this.keyword.length();i++) {
			temp += this.keyword.charAt(i);
		}
		for (int i = 0; i<26;i++) {
			temp += (char) (i+65);
		}
		
		for (int i = 0; i<temp.length();i++) {
			Boolean found = false;
			for (int j = 0; j<this.keyword.length();j++) {
				if (temp.charAt(i) == this.keyword.charAt(j)) {
					found = true;
					break;
				}
			}
			if (found == false) this.keyword += temp.charAt(i);
		}
			super.setSecretAlphabet(this.keyword.toLowerCase());
		}
	}
	
	


