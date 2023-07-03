package ui.pageobject.component;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import ui.util.ConditionalWait;

public class AddProjectModal extends Form {
    private final IButton saveProjectBtn = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Save Project Button");
    private final ITextBox successMessage = getElementFactory().getTextBox(By.cssSelector("div.alert-success"), "Success message");
    private final ITextBox projectNameField = getElementFactory().getTextBox(By.xpath("//input[@id='projectName']"), "Input Project Name");

    public AddProjectModal() {
        super(By.id("addProjectForm"), "Add Project Modal Form");
    }

    public void clickSaveProjectBtn() {
        ConditionalWait.waitUntilClickable(saveProjectBtn.getLocator());
        saveProjectBtn.clickAndWait();
    }

    public void inputProjectName(String projectName) {
        ConditionalWait.waitUntilPresented(projectNameField.getLocator());
        projectNameField.sendKeys(projectName);
    }

    public void createNewProject(String projectName) {
        inputProjectName(projectName);
        clickSaveProjectBtn();
    }

    public ITextBox getSuccessMessage() {
        return this.successMessage;
    }
}