package jkolesik.cipher;

public class TranspositionCipher implements Cipher{
	private int level;
	private String text;
	public TranspositionCipher(int level) {
		this.setTranspositionLevel(level);
	}
	
	public void setTranspositionLevel(int level) throws NotSuitableException {
		if (this.level >= 1 && this.level <= 5) {
		this.level = level;
		} else {
			NotSuitableException suit = new NotSuitableException("TranspositionLevel ist zu gering/hoch");
			throw suit;
		}
	}

	@Override
	public String encrypt(String text) {
		String text1 = text.replaceAll("\\s", "");
		char[][] rail = new char[this.level] [text1.length()]; //Erzeugt die benötigte Matrix
		//Für Abstand halten - zum encrypten und decrypten
		
		for (int i = 0; i<this.level;i++) {
			for (int j = 0; j<text1.length();j++) {
				rail[i][j] = '.';
			}
		}
		
		int row = 0;
		int check = 0;
		for (int i = 0; i<text1.length();i++) {
			if (check == 0) {
				rail[row][i] = text1.charAt(i);
				row++;
					if (row == this.level) {
						check = 1;
						row--;
					}
			} else if (check == 1) {
				row--;
				rail[row][i] = text1.charAt(i);
				if (row == 0) {
					check = 0;
					row = 1;
				}
			}
		}
		String temp ="";
		
		for (int i = 0; i<this.level;i++) {
			for (int j = 0; j<text1.length();j++) {
				temp += rail[i][j];
			}
		}
		temp = temp.replaceAll("\\.", "");
		this.text = temp;
		return temp;
	}

	@Override
	public String decrypt(String text) {
		String text1 = text.replaceAll("\\s", "");
char[][] rail = new char[this.level] [text1.length()]; //Erzeugt die benötigte Matrix
		
for (int i = 0; i<this.level;i++) {
	for (int j = 0; j<text1.length();j++) {
		rail[i][j] = '.';
	}
}

		int row = 0;
		int check = 0;
		for (int i = 0; i<text1.length();i++) {
			if (check == 0) {
				rail[row][i] = text1.charAt(i);
				row++;
					if (row == this.level) {
						check = 1;
						row--;
					}
					
			} else if (check == 1) {
				row--;
				rail[row][i] = text1.charAt(i);
				if (row == 0) {
					check = 0;
					row = 1;
				}
			}
		}
		
		
		int order = 0;
		for (int i = 0; i<this.level;i++) {
			for (int j = 0; j<text1.length();j++) {
				String temp = rail [i][j] + "";
				if (temp.matches("\\.")) {
					continue;
				}else {
					rail[i][j] = text1.charAt(order);
					order++;
				}
			}
		}
		
		//Zurückverwandeln in eine 1 Zeilen Ausgabe
		String temp = "";
		int check1 = 0;
		int row1 = 0;
		for (int i = 0; i<text1.length();i++) {
			if (check1 == 0) {
				temp += rail[row1][i];
				row1++;
				if (row1 == this.level) {
					check1 = 1;
					row1--;
				}
				} else if (check1 == 1) {
					row1--;
					temp += rail[row1][i];
					if (row1 == 0) {
						check1 = 0;
						row1 = 1;
				}
			}
		}
			
		
	
		temp = temp.replaceAll("\\.", "");
		this.text = temp;
		return temp;
	}
	
	public String getInhalt() {
		return this.text;
	}
	public void setInhalt(String t) {
		this.text = t;
	}
	
}
