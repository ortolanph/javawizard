package org.jwizard.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JWizardUI extends JPanel {
	private JLabel lblApplicationName = new JLabel();
	private JButton btnNext = new JButton("Next");
	private JButton btnPrevious = new JButton("Previous");
	private JButton btnCancel = new JButton("Cancel");
	private JPanel pnlPages = new JPanel();
	private JPanel pnlCommands = new JPanel();
	
	public JWizardUI() {
		setLayout(new BorderLayout(20, 20));
		
		lblApplicationName.setText("");
		lblApplicationName.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
		pnlCommands.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlCommands.add(btnCancel);
		pnlCommands.add(btnPrevious);
		pnlCommands.add(btnNext);
		
		pnlPages.setLayout(new BorderLayout());
		
		btnCancel.setActionCommand("cancel");
		btnPrevious.setActionCommand("previous");
		btnNext.setActionCommand("next");
		
		add(lblApplicationName, BorderLayout.NORTH);
		add(pnlPages, BorderLayout.CENTER);
		add(pnlCommands, BorderLayout.SOUTH);
	}
	
	public void setApplicationName(String appName) {
		lblApplicationName.setText(appName);
	}
	
	public void setFinish() {
		btnNext.setText("Finish");
		btnNext.setActionCommand("finish");
	}
	
	public void setNext() {
		btnNext.setText("Next");
		btnNext.setActionCommand("next");
	}
	
	public void setAction(ActionListener action) {
		btnCancel.addActionListener(action);
		btnNext.addActionListener(action);
		btnPrevious.addActionListener(action);
	}

	public void setForm(JPanel panel) {
		pnlPages.removeAll();
		pnlPages.add(panel, BorderLayout.CENTER);
		updateUI();
	}
	
	public void setPreviousEnabled(boolean enabled) {
		btnPrevious.setEnabled(enabled);
	}
}
