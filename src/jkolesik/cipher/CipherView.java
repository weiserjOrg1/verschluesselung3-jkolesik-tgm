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
	private JTextField tAlphabet; //Textfeld zum Eingeben des Alphabets
	private JTextField tTexten; //Textfeld zum Eingeben des zu verschlüsselnten Texts
	private JTextField tTextde; //Textfeld zum Eingeben des zu entschlüsselnten Texts
	private JTextField iShift; //Textfeld zum Eingeben des ShiftValue
	private JButton setAlphabet; //Button zum setten des Alphabets
	private Container EnDe;
	private Container EnDeT;
	private Container newA;
	private Container transpositionCipher;
	private JTextField transC;
	private JButton UseTransC;
	private JButton en;
	private JButton de;
	private CipherModel Model;
	private CipherPanel Panel;
	private CipherController Controller;
	private JButton setShAlphabet;
	private Container SetA;
	private Container kCipher;
	private JTextField keyWord;
	private JButton UseKeyW;
	
	/**
	 * Das ist der überladene Konstruktor
	 * @param m Ein Objekt vom Typ CipherModel
	 * @param c Ein Objekt vom Typ CipherController
	 */
	public CipherView(CipherModel m, CipherController c) {
		this.setTitle("Cipher");
		this.Model = m;
		this.Controller = c;
		this.Panel = new CipherPanel(this, this.Model);
		this.setLayout(new GridLayout(5,2));
		this.EnDeT = new Container();
		this.EnDeT.setLayout(new GridLayout(2,1));
		this.tTexten = new JTextField("entschlüsselter Text eingeben");
		this.tTextde = new JTextField("verschlüsselter Text eingeben");
		this.EnDeT.add(this.tTexten);
		this.EnDeT.add(this.tTextde);
		this.add(this.EnDeT);
		this.newA = new Container();
		this.newA.setLayout(new GridLayout(2,1));
		this.tAlphabet = new JTextField("Alphabet eingeben");
		this.setAlphabet = new JButton("neues Alphabet verwenden");
		this.newA.add(this.tAlphabet);
		this.newA.add(this.setAlphabet);
		this.add(newA);
		this.add(this.Panel);
		this.SetA = new Container();
		this.SetA.setLayout(new GridLayout(2,1));
		this.iShift = new JTextField("Geben Sie eine Zahl zwischen 1 und 30 ein!");
		this.setShAlphabet = new JButton("Alphabet mit eingegebenem Wert erstellen.");
		this.SetA.add(this.iShift);
		this.SetA.add(this.setShAlphabet);
		this.add(this.SetA);
		this.EnDe = new Container();
		this.EnDe.setLayout(new GridLayout(2,1));
		this.en = new JButton("Verschlüsseln");
		this.de = new JButton("Entschlüsseln");
		this.EnDe.add(this.en);
		this.EnDe.add(this.de);
		this.add(this.EnDe);
		this.kCipher = new Container();
		this.kCipher.setLayout(new GridLayout(2,1));
		this.keyWord = new JTextField("Geben Sie ein Keyword ein!");
		this.UseKeyW = new JButton("Alphabet mit Keyword erstellen!");
		this.kCipher.add(this.keyWord);
		this.kCipher.add(this.UseKeyW);
		this.add(this.kCipher);
		this.UseKeyW.addActionListener(this.Controller);
		this.en.addActionListener(this.Controller);
		this.de.addActionListener(this.Controller);
		this.setAlphabet.addActionListener(this.Controller);
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
	
	public boolean klickSA(ActionEvent e) {
		if (e.getSource() == this.setAlphabet) return true;
		return false;
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	
	public boolean klickEn(ActionEvent e) {
		if (e.getSource() == this.en) return true;
		return false;
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	public boolean klickDe(ActionEvent e) {
		if (e.getSource() == this.de) return true;
		return false;
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	public boolean klickUKW(ActionEvent e) {
		if (e.getSource() == this.UseKeyW) return true;
		return false;
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	public boolean klickUseTransC(ActionEvent e) {
		if (e.getSource() == this.UseTransC) return true;
		return false;
	}
	/**
	 * Diese Methode setzt den Shift-Wert im Model.
	 */
	public void setWert() {
		String s = this.iShift.getText();
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
		this.Model.setAlphabet(this.tAlphabet.getText());
	}
	/**
	 * Diese Methode setzt das zu entschlüsselte Text-Attribut im Model.
	 */
	public void setDe() {
		this.Model.setDtext(this.tTextde.getText());
	}
	/**
	 * Diese Methode setzt das zu verschlüsselte Text-Attribut im Model.
	 */
	public void setEn() {
		this.Model.setentText(this.tTexten.getText());
	}
	/**
	 * Diese Methode prüft ob der betreffende Button der Eventauslöser war
	 * @param e Ein Objekt vom Typ ActionEvent
	 * @return Je nachdem ob Button Eventauslöser war
	 */
	public boolean klickShA(ActionEvent e) {
		if (e.getSource() == this.setShAlphabet) return true;
		return false;
	}
	
}
