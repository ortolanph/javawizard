package org.jwizard.page;

import java.util.Map;

import javax.swing.JPanel;

public interface WizardPage {
	public Map getParameters();
	public JPanel buildGUI();
}
