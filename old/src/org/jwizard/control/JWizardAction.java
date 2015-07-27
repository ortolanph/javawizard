package org.jwizard.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import org.jwizard.action.WizardAction;
import org.jwizard.beans.Page;
import org.jwizard.beans.Wizard;
import org.jwizard.form.WizardForm;
import org.jwizard.ui.JWizardUI;

public class JWizardAction implements ActionListener {
	private JWizardUI ui;
	private Wizard wizard;
	private ArrayList pagesList;
	private int pControl;
	private HashMap pageMap = new HashMap();;

	public JWizardAction(JWizardUI ui, Wizard wizard) {
		this.ui = ui;
		this.wizard = wizard;
		
		pagesList = (ArrayList)this.wizard.getPages();
		
		setInstances();
		
		this.ui.setApplicationName(wizard.getApplication());
		this.ui.setForm(((WizardForm)pageMap.get("form")).buildGUI());
		this.ui.setPreviousEnabled(false);
		this.ui.setAction(this);
		this.ui.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if(command.equals("cancel")) {
			ui.setVisible(false);
		}
		
		if(command.equals("previous")) {
			pControl--;
			setInstances();
			
			WizardForm form = ((WizardForm)pageMap.get("form"));
			ui.setForm(form.buildGUI());
			
			((WizardAction)pageMap.get("action")).rollback();
			
			ui.setNext();
			
			if(pControl == 0) {
				ui.setPreviousEnabled(false);
			}
		}
		
		if(command.equals("next")) {
			ui.setPreviousEnabled(true);
			WizardForm form = ((WizardForm)pageMap.get("form"));
			
			if(((WizardAction)pageMap.get("action")).execute(form.getParameters())) {
				pControl++;
				setInstances();
				
				form = ((WizardForm)pageMap.get("form"));
				ui.setForm(form.buildGUI());
				
				if(pControl == pagesList.size() - 1) {
					ui.setFinish();
				}
			}
		}
		
		if(command.equals("finish")) {
			setInstances();
			WizardForm form = ((WizardForm)pageMap.get("form"));
			((WizardAction)pageMap.get("action")).execute(form.getParameters());
		}
	}
	
	private void setInstances() {
		Page currentPage = (Page)pagesList.get(pControl);
		
		pageMap.clear();
		
		String cForm = currentPage.getForm();
		String cAction = currentPage.getAction();
		
		try {
			WizardForm form = (WizardForm)Class.forName(cForm).newInstance();
			WizardAction action = (WizardAction)Class.forName(cAction).newInstance();
			
			pageMap.put("form", form);
			pageMap.put("action", action);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
