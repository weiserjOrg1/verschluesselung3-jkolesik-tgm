package jkolesik.cipher;

public class CipherModel {
	private String etext;
	private String dtext;
	private String alphabet;
	private int Ver;
	public String keyWord;
	public CipherModel() {
		this.etext = "";
		this.dtext = "";
		this.alphabet = "";
		this.keyWord = "";
		this.Ver = 0;
	}
	public String getEtext() {
		return etext;
	}
	public void setEtext(String etext) {
		this.etext = etext;
	}
	public String getDtext() {
		return dtext;
	}
	public void setDtext(String dtext) {
		this.dtext = dtext;
	}
	public String getAlphabet() {
		return alphabet;
	}
	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}
	public int getVer() {
		return Ver;
	}
	public void setVer(int ver) {
		Ver = ver;
	}
	public String getKeyWord() {
		return this.keyWord;
	}
	public void setKeyword(String KeyWord) {
		this.keyWord = KeyWord;
	}
	public void refresh() {
		this.etext = "";
		this.dtext = "";
		this.alphabet = "";
		this.keyWord = "";
		this.Ver = 0;
	}
}
