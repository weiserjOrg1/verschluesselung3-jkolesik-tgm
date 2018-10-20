package jkolesik.cipher;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
/**
 * Diese Klasse stellt die Swing-Elemente der GUI dar.
 * @author jkolesik
 * @version 19-10-2018
 */
public class CipherView extends JFrame {
	private JTextField textFieldAlphabet; //Textfeld zum Eingeben des Alphabets
	private JTextField textFieldEnt; //Textfeld zum Eingeben des zu verschlüsselnten Texts
	private JTextField textFieldDec; //Textfeld zum Eingeben des zu entschlüsselnten Texts
	private JTextField textFieldShiftValue; //Textfeld zum Eingeben des ShiftValue
	private JTextField keyWord;
	private JTextField transC;
	private JButton setextFieldAlphabet; //Button zum setten des Alphabets
	private JButton UseTransC;
	private JButton en;
	private JButton de;
	private JButton setShAlphabet;
	private JButton UseKeyW;
	private CipherModel Model;
	private CipherPanel Panel;
	private CipherController Controller;
	private Container EnDe;
	private Container EnDeT;
	private Container newA;
	private Container SetA;
	private Container keywordCipher;
	private Container transpositionCipher;
	/**
	 * Das ist der überladene Konstruktor
	 * @param m Ein Objekt vom Typ CipherModel
	 * @param c Ein Objekt vom Typ CipherController
	 */
	public CipherView(CipherModel m, CipherController c) {
		this.setTitle("Verschlüsselungen");
		this.Model = m;
		this.Controller = c;
		this.Panel = new CipherPanel(this, this.Model);
		this.setLayout(new GridLayout(5,2));
		this.EnDeT = new Container();
		this.EnDeT.setLayout(new GridLayout(2,1));
		this.textFieldEnt = new JTextField("entschlüsselter Text eingeben");
		this.textFieldDec = new JTextField("verschlüsselter Text eingeben");
		this.EnDeT.add(this.textFieldEnt);
		this.EnDeT.add(this.textFieldDec);
		this.add(this.EnDeT);
		this.newA = new Container();
		this.newA.setLayout(new GridLayout(2,1));
		this.textFieldAlphabet = new JTextField("Alphabet eingeben");
		this.setextFieldAlphabet = new JButton("neues Alphabet verwenden");
		this.newA.add(this.textFieldAlphabet);
		this.newA.add(this.setextFieldAlphabet);
		this.add(newA);
		this.add(this.Panel);
		this.SetA = new Container();
		this.SetA.setLayout(new GridLayout(2,1));
		this.textFieldShiftValue = new JTextField("Zahl zwischen 1 und 30 eingeben !");
		this.setShAlphabet = new JButton("Alphabet mit eingegebener Zahl erstellen.");
		this.SetA.add(this.textFieldShiftValue);
		this.SetA.add(this.setShAlphabet);
		this.add(this.SetA);
		this.EnDe = new Container();
		this.EnDe.setLayout(new GridLayout(2,1));
		this.en = new JButton("Verschlüsseln");
		this.de = new JButton("Entschlüsseln");
		this.EnDe.add(this.en);
		this.EnDe.add(this.de);
		this.add(this.EnDe);
		this.keywordCipher = new Container();
		this.keywordCipher.setLayout(new GridLayout(2,1));
		this.keyWord = new JTextField("Geben Sie ein Keyword ein!");
		this.UseKeyW = new JButton("Alphabet mit Keyword erstellen!");
		this.keywordCipher.add(this.keyWord);
		this.keywordCipher.add(this.UseKeyW);
		this.add(this.keywordCipher);
		this.UseKeyW.addActionListener(this.Controller);
		this.en.addActionListener(this.Controller);
		this.de.addActionListener(this.Controller);
		this.setextFieldAlphabet.addActionListener(this.Controller);
		this.setShAlphabet.addActionListener(this.Controller);
		this.transpositionCipher = new Container();
		this.transpositionCipher.setLayout(new GridLayout(2,1));
		this.transC = new JTextField("Geben Sie ein TranspositionsLevel ein");
		this.UseTransC = new JButton("Alphabet mit Transposition erstellen!");
		this.transpositionCipher.add(this.transC);
		this.transpositionCipher.add(this.UseTransC);
		this.UseTransC.addActionListener(this.Controller);
		this.add(this.transpositionCipher);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	
	public boolean buttonSetextFieldAlphabet(ActionEvent e) {
		if (e.getSource() == this.setextFieldAlphabet) return true;
		return false;
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	
	public boolean buttonEncrypt(ActionEvent e) {
		if (e.getSource() == this.en) return true;
		return false;
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	public boolean buttonDecrypt(ActionEvent e) {
		if (e.getSource() == this.de) return true;
		return false;
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	public boolean buttonKeyword(ActionEvent e) {
		if (e.getSource() == this.UseKeyW) return true;
		return false;
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	public boolean buttonTransposition(ActionEvent e) {
		if (e.getSource() == this.UseTransC) return true;
		return false;
	}
	/**
	 * Diese Methode setzt den Shift-Wert im Model.
	 */
	public void setWert() {
		String s = this.textFieldShiftValue.getText();
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Geben Sie eine korrekte Zahl ein!");
		}
		this.Model.setVer(i);
	}
	/**
	 * Diese Methode setzt das Keyword-Attribut im Model.
	 */
	public void setKW() {
		this.Model.setKeyword(this.keyWord.getText());
	}
	/**
	 * Diese Methode setzt das TranspositionsLevel im Model.
	 */
	public void setLevel() {
		String s = this.transC.getText();
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Geben Sie eine korrekte Zahl ein!");
		}
		this.Model.setLevel(i);
	}
	/**
	 * Diese Methode repaintet die GUI-Elemente.
	 */
	public void refresh() {
		this.repaint();
	}
	/**
	 * Diese Methode setzt das Text-Attribut im Model.
	 */
	public void setText() {
		this.Model.setextFieldAlphabet(this.textFieldAlphabet.getText());
	}
	/**
	 * Diese Methode setzt das zu entschlüsselte Text-Attribut im Model.
	 */
	public void setDe() {
		this.Model.setdecText(this.textFieldDec.getText());
	}
	/**
	 * Diese Methode setzt das zu verschlüsselte Text-Attribut im Model.
	 */
	public void setEn() {
		this.Model.setentText(this.textFieldEnt.getText());
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	public boolean buttonShift(ActionEvent e) {
		if (e.getSource() == this.setShAlphabet) return true;
		return false;
	}
	
}
