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
		if(this.View.buttonSetextFieldAlphabet(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setText();
			this.s1 = new SubstitutionCipher(this.Model.getextFieldAlphabet());
			this.alphT = true; this.shT = false; this.kCT = false; this.tCT = false;
		}
		if (this.View.buttonShift(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setWert();
			this.sh1 = new ShiftCipher(this.Model.getVer());
			this.shT = true; this.alphT = false; this.kCT = false; this.tCT = false;
		}
		
		if (this.View.buttonKeyword(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setKW();
			this.kC = new KeywordCipher(this.Model.getKeyWord());
			this.kCT = true; this.alphT = false; this.shT = false; this.tCT = false;
		}
		
		if(this.View.buttonDecrypt(e)) {
			this.View.setDe();
			if (this.alphT) this.Model.setdecText(this.s1.decrypt(this.Model.getdecText()));
			if (this.shT) this.Model.setdecText(this.sh1.decrypt(this.Model.getdecText()));
			if (this.kCT) this.Model.setdecText(this.kC.decrypt(this.Model.getdecText()));
			if (this.tCT) this.Model.setdecText(this.tC.decrypt(this.Model.getdecText()));

			this.View.refresh();
		}
		if(this.View.buttonEncrypt(e)) {
			this.View.setEn();
			if (this.alphT) this.Model.setentText(this.s1.encrypt(this.Model.getentText()));
			if (this.shT) this.Model.setentText(this.sh1.encrypt(this.Model.getentText()));
			if (this.kCT) this.Model.setentText(this.kC.encrypt(this.Model.getentText()));
			if (this.tCT) this.Model.setentText(this.tC.encrypt(this.Model.getentText()));
			this.View.refresh();
		}
		if (this.View.buttonTransposition(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setLevel();
			this.tC = new TranspositionCipher(this.Model.getLevel());
			this.kCT = false; this.alphT = false; this.shT = false; this.tCT = true;
		}
	}
	
}
