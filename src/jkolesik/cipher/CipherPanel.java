package jkolesik.cipher;

import java.awt.*;
import javax.swing.*;
/**
 * Diese Klasse ist die Panel-Klasse der GUI nach dem MVC-Konzept.
 * @author jkolesik
 * @version 19-10-2018
 */
public class CipherPanel extends JPanel{
	private CipherModel Model;
	private CipherView View;
	/**
	 * Das ist ein überladener Konstruktor.
	 * @param v Ist ein Objekt vom Typ CipherView
	 * @param m Ist ein Objekt vom Typ CipherModel
	 */
	public CipherPanel (CipherView v, CipherModel m) {
		this.Model = m;
		this.View= v;
	}
	/**
	 * Diese Methode initialisiert die Zeichenfläche und zeichnet Texte aus dem Model.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawString("Verschlüsselter Text: "+"\n"+this.Model.getentText(), 5, 20);
		g.drawString("Entschlüsselter Text: "+"\n"+this.Model.getdecText(), 5, 40);
	}
}
