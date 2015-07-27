package org.jwizard.form;

import java.util.Map;

import javax.swing.JPanel;

public interface WizardForm {
	public Map getParameters();
	public JPanel buildGUI();
}
