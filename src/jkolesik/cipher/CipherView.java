package jkolesik.cipher;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class CipherView extends JFrame {
	private JTextField tAlphabet;
	private JTextField tTexten;
	private JTextField tTextde;
	private JTextField iShift;
	private JButton setAlphabet;
	private Container EnDe;
	private Container EnDeT;
	private Container newA;
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
	public CipherView(CipherModel m, CipherController c) {
		this.setTitle("Cipher");
		this.Model = m;
		this.Controller = c;
		this.Panel = new CipherPanel(this, this.Model);
		this.setLayout(new GridLayout(4,2));
		this.EnDeT = new Container();
		this.EnDeT.setLayout(new GridLayout(2,1));
		this.tTexten = new JTextField("entschl�sselter Text eingeben");
		this.tTextde = new JTextField("verschl�sselter Text eingeben");
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
		this.en = new JButton("Verschl�sseln");
		this.de = new JButton("Entschl�sseln");
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
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public boolean klickSA(ActionEvent e) {
		if (e.getSource() == this.setAlphabet) return true;
		return false;
	}
	public boolean klickEn(ActionEvent e) {
		if (e.getSource() == this.en) return true;
		return false;
	}
	public boolean klickDe(ActionEvent e) {
		if (e.getSource() == this.de) return true;
		return false;
	}
	public boolean klickUKW(ActionEvent e) {
		if (e.getSource() == this.UseKeyW) return true;
		return false;
	}
	public void refresh() {
		this.repaint();
	}
	public void setText() {
		this.Model.setAlphabet(this.tAlphabet.getText());
	}
	public void setDe() {
		this.Model.setDtext(this.tTextde.getText());
	}
	public void setEn() {
		this.Model.setEtext(this.tTexten.getText());
	}
	public boolean klickShA(ActionEvent e) {
		if (e.getSource() == this.setShAlphabet) return true;
		return false;
	}
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
	public void setKW() {
		this.Model.setKeyword(this.keyWord.getText());
		
	}
}
