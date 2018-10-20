package jkolesik.cipher;
/**
 * Diese Klasse stellt das Model nach dem MVC-Konzept dar und kümmert sich um die notwendigen Daten.
 * @author jkolesik
 * @version 19-10-2018
 */
public class CipherModel {
	private String entText;
	private String decText;
	private String alphabet;
	private int Ver;
	private String keyWord;
	private int level;
	/**
	 * Das ist der implementierte Konstruktor.
	 */
	public CipherModel() {
		this.entText = "";
		this.decText = "";
		this.alphabet = "";
		this.keyWord = "";
		this.Ver = 0;
		this.level = 0;
	}
	/**
	 * Diese Methode liefert den verschlüsselte Text zurück.
	 * @return der verschlüsselte text
	 */
	public String getentText() {
		return entText;
	}
	/**
	 * Diese Methode setzt den verschlüsselten Text.
	 * @param entText der verschlüsselte Text
	 */
	public void setentText(String entText) {
		this.entText = entText;
	}
	/**
	 * Diese Methode liefert den entschlüsselten Text
	 * @return
	 */
	public String getdecText() {
		return decText;
	}
	/**
	 * Diese Methode settet den zu entschlüsselten Text
	 * @param decText
	 */
	public void setdecText(String decText) {
		this.decText = decText;
	}
	/**
	 * Diese Methode returnt das Geheimalphabet.
	 * @return
	 */
	public String getextFieldAlphabet() {
		return alphabet;
	}
	/**
	 * Diese Methode settet das Geheimalphabet.
	 * @param alphabet das Alphabet was gesettet wird
	 */
	public void setextFieldAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}
	/**
	 * Diese Methode returnt den ShiftValue.
	 * @return
	 */
	public int getVer() {
		return Ver;
	}
	/**
	 * Diese Methode setzt den ShiftValue.
	 * @param ver der ShiftValue
	 */
	public void setVer(int ver) {
		Ver = ver;
	}
	/**
	 * Diese Methode returnt das Keyword, welches das Geheimalphabet erzeugt.
	 * @return
	 */
	public String getKeyWord() {
		return this.keyWord;
	}
	/**
	 * Diese Methode settet das Keyword, welches zur Bildung eines neuen Geheimalphabets benutzt wird.
	 * @param KeyWord
	 */
	public void setKeyword(String KeyWord) {
		this.keyWord = KeyWord;
	}
	/**
	 * Diese Methode setzt alle Daten auf Ausgangszustand zurück.
	 */
	public void refresh() {
		this.entText = "";
		this.decText = "";
		this.alphabet = "";
		this.keyWord = "";
		this.Ver = 0;
	}
	/**
	 * Diese Methode settet das Transposition-Level.
	 * @param i das Level
	 */
	public void setLevel(int i) {
		this.level = i;
	}
	/**
	 * Diese Methode returnt das aktuelle Level der Transposition.
	 * @return
	 */
	public int getLevel() {
		return this.level;
	}
}
