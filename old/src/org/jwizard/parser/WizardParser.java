package org.jwizard.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.jwizard.beans.Page;
import org.jwizard.beans.Wizard;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class WizardParser {
	private Wizard wizard;

	public WizardParser(String file) {
		XStream xStream = new XStream(new DomDriver());
		
		xStream.alias("wizard", Wizard.class);
		xStream.alias("page", Page.class);
		
		try {
			wizard = (Wizard)xStream.fromXML(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Wizard getWizard() {
		return wizard;
	}
}
