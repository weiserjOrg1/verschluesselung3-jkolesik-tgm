package jkolesik.cipher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Diese Klasse stellt einen Controller nach dem MVC-Konzept dar und handelt die Benutzereingaben und Interaktionen mit der GUI.
 * @author jkolesik
 * @version 19-10-2018
 */

public class CipherController implements ActionListener {
	private CipherModel Model;
	private CipherView View;
	private SubstitutionCipher s1;
	private ShiftCipher sh1;
	private boolean alphT;
	private boolean shT;
	private boolean kCT;
	private boolean tCT;
	private KeywordCipher kC;
	private TranspositionCipher tC;
	/**
	 * Das ist der implementierende Konstruktor.
	 */
	public CipherController() {
		this.alphT = false;
		this.Model = new CipherModel();
		this.View = new CipherView(this.Model, this);
	}
	@Override
	/**
	 * Das ist die zu implementierende Methode des Actionlisteners und sie verarbeitet die Benutzereingaben.
	 */
	public void actionPerformed(ActionEvent e) {
		if(this.View.klickSA(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setText();
			this.s1 = new SubstitutionCipher(this.Model.getAlphabet());
			this.alphT = true; this.shT = false; this.kCT = false; this.tCT = false;
		}
		if (this.View.klickShA(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setWert();
			this.sh1 = new ShiftCipher(this.Model.getVer());
			this.shT = true; this.alphT = false; this.kCT = false; this.tCT = false;
		}
		
		if (this.View.klickUKW(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setKW();
			this.kC = new KeywordCipher(this.Model.getKeyWord());
			this.kCT = true; this.alphT = false; this.shT = false; this.tCT = false;
		}
		
		if(this.View.klickDe(e)) {
			this.View.setDe();
			if (this.alphT) this.Model.setDtext(this.s1.decrypt(this.Model.getDtext()));
			if (this.shT) this.Model.setDtext(this.sh1.decrypt(this.Model.getDtext()));
			if (this.kCT) this.Model.setDtext(this.kC.decrypt(this.Model.getDtext()));
			if (this.tCT) this.Model.setDtext(this.tC.decrypt(this.Model.getDtext()));

			this.View.refresh();
		}
		if(this.View.klickEn(e)) {
			this.View.setEn();
			if (this.alphT) this.Model.setEtext(this.s1.encrypt(this.Model.getEtext()));
			if (this.shT) this.Model.setEtext(this.sh1.encrypt(this.Model.getEtext()));
			if (this.kCT) this.Model.setEtext(this.kC.encrypt(this.Model.getEtext()));
			if (this.tCT) this.Model.setEtext(this.tC.encrypt(this.Model.getEtext()));
			this.View.refresh();
		}
		if (this.View.klickUseTransC(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setLevel();
			this.tC = new TranspositionCipher(this.Model.getLevel());
			this.kCT = false; this.alphT = false; this.shT = false; this.tCT = true;
		}
	}
	
}
