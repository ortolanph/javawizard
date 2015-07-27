package org.jwizard.action;

import java.util.Map;

public interface WizardAction {
	public boolean execute(Map parameters);
	public boolean rollback();
}
