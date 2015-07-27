package org.jwizard.beans;

import java.util.ArrayList;
import java.util.List;

public class Wizard {
	private String name;

	private String application;

	private List pages = new ArrayList();

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getPages() {
		return pages;
	}

	public void setPages(List pages) {
		this.pages = pages;
	}

	public void add(Page page) {
		pages.add(page);
	}

	public List getContent() {
		return pages;
	}
}
