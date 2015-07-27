package org.jwizard.control;

import javax.swing.JPanel;

import org.jwizard.beans.Wizard;
import org.jwizard.parser.WizardParser;
import org.jwizard.ui.JWizardUI;

public class JWizard {
	private JWizardUI ui;
	
	public JWizard(String wizardFileName) {
		WizardParser parser = new WizardParser(wizardFileName);
		
		Wizard wizard = parser.getWizard();
		this.ui = new JWizardUI();
		
		JWizardAction action = new JWizardAction(ui, wizard);
	}
	
	public JPanel getWizard() {
		return this.ui;
	}
}