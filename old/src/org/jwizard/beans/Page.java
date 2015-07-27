package org.jwizard.beans;

public class Page {
	private String form;
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String toString() {
		return action + ":" + form;
	}
}
