package org.jboss.tools.bpmn2.itests.editor.constructs;

import org.jboss.reddeer.swt.impl.button.CheckBox;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.text.LabeledText;

import org.jboss.tools.bpmn2.itests.editor.properties.datatypes.JBPM5DataType;

/**
 * 
 * @author mbaluch
 */
public class JBPM5Process extends Process {

	/**
	 * 
	 * @param name
	 */
	public JBPM5Process(String name) {
		super(name);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		properties.selectTab("Process");
		new LabeledText("Id").setText(id);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setProcessName(String name) {
		properties.selectTab("Process");
		new LabeledText("Name").setText(name);
	}
	
	/**
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		properties.selectTab("Version");
		new LabeledText("Id").setText(version);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setPackageName(String name) {
		properties.selectTab("Process");
		new LabeledText("Package Name").setText(name);
	}
	
	/**
	 * 
	 * @param b
	 */
	public void setAddHoc(boolean b) {
		properties.selectTab("Process");
		properties.selectCheckBox(new CheckBox("Ad Hoc"), b);
	}
	
	/**
	 * 
	 */
	public void setExecutable(boolean b) {
		super.setExecutable(b);
	}
	
	/**
	 * ISSUES:
	 * 	1) Does nothing. The name is set but not visible in the file.
	 */
	public void setNameAttribute(String name) {
		properties.selectTab("Definitions");
		new LabeledText("Name").setText(name);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setTargetNamespaceAttribute(String name) {
		properties.selectTab("Definitions");
		new LabeledText("Target Namespace").setText(name);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setTypeLanguageAttribute(String name) {
		properties.selectTab("Definitions");
		new LabeledText("Type Language").setText(name);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setExpressionLanguageAttribute(String name) {
		properties.selectTab("Definitions");
		new LabeledText("Expression Language").setText(name);
	}
	
	/**
	 * 
	 * @param name
	 */
	public void addDataType(String name) {
		properties.selectTab("Definitions");
		properties.toolbarButton("Data Type List", "Add").click();
		bot.textWithLabel("Data Type").setText(name);
		bot.toolbarButtonWithTooltip("Close").click();
//		new JBPM5DataType(name, 0).add();
	}
	
	public void addImport(String dataType) {
		properties.selectTab("Definitions");
		properties.toolbarButton("Imports", "Add").click();
		
//		SWTBot windowBot = Bot.get().shell("Browse for a Java type to Import").bot();
		
		new LabeledText("Type:").setText(dataType);
		new PushButton("OK");
	}
	
	public void addMessage(String name, JBPM5DataType dataType) {
		properties.selectTab("Definitions");
		
		bot.toolbarButtonWithTooltip("Add", 2).click();
		bot.textWithLabel("Name").setText(name);
		
		dataType.add();
		
		bot.toolbarButtonWithTooltip("Close").click();
	}
	
	public void addError(String name, String code, JBPM5DataType dataType) {
		properties.selectTab("Definitions");
		
		bot.toolbarButtonWithTooltip("Add", 3).click();
		bot.textWithLabel("Name").setText(name);
		bot.textWithLabel("Error Code").setText(code);
		
		dataType.add();
		
		bot.toolbarButtonWithTooltip("Close").click();
	}
	
	public void addEscalation(String name, String code) {
		properties.selectTab("Definitions");
		
		bot.toolbarButtonWithTooltip("Add", 4).click();
		bot.textWithLabel("Escalation Code").setText(name);
		bot.toolbarButtonWithTooltip("Close").click();
	}
	
	public void addSignal(String name) {
		properties.selectTab("Definitions");
		
		bot.toolbarButtonWithTooltip("Add", 5).click();
		bot.textWithLabel("Name").setText(name);
		bot.toolbarButtonWithTooltip("Close").click();
	}
	
	public void addGlobalVariable(String name, String dataType) {
		properties.selectTab("Data Items");
		
		bot.toolbarButtonWithTooltip("Add", 0).click();
		bot.textWithLabel("Name").setText(name);
		
		new JBPM5DataType(dataType).add();
		
		bot.toolbarButtonWithTooltip("Close").click();
	}
	
	public void addLocalVariable(String name, String dataType) {
		properties.selectTab("Data Items");
		
		bot.toolbarButtonWithTooltip("Add", 0).click();
		bot.textWithLabel("Name").setText(name);
		
		new JBPM5DataType(dataType).add();
		
		bot.toolbarButtonWithTooltip("Close").click();
	}
	
	public void addInterface() {
		throw new UnsupportedOperationException();
	}
}