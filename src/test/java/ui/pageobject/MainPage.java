package ui.pageobject;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ui.pageobject.component.Footer;
import ui.util.ConditionalWait;

import java.util.List;
import java.util.stream.Collectors;

import static ui.constant.PageConstants.LINK_ATTRIBUTE;

public class MainPage extends Form {
    private final By projectListLocator = By.xpath("//div[@class='list-group']/a");
    private final IButton addProjectBtn = getElementFactory().getButton(By.xpath("//a[@href='addProject']"), "Add Project Button");
    private Footer footer;

    public MainPage() {
        super(By.xpath("//div[contains(text(), 'Available projects')]"), "Main Page");
        this.footer = new Footer();
    }

    public Footer footer() {
        return this.footer;
    }

    public void clickAddProjectBtn() {
        ConditionalWait.waitUntilClickable(addProjectBtn.getLocator());
        addProjectBtn.clickAndWait();
    }

    private List<ITextBox> projectList() {
        ConditionalWait.waitUntilPresented(projectListLocator);
        ConditionalWait.waitUntilPresented(projectListLocator);
        return getElementFactory()
                .findElements(projectListLocator, ITextBox.class);
    }

    public List<String> getProjectList() {
        return projectList()
                .stream()
                .map(IElement::getText)
                .collect(Collectors.toList());
    }

    private ITextBox getProject(String projectName) {
        return projectList()
                .stream()
                .filter(iTextBox -> iTextBox.getText().equals(projectName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Project not found"));
    }

    public void clickProject(String projectName) {
        ITextBox projectBtn = getProject(projectName);
        ConditionalWait.waitUntilClickable(projectBtn.getLocator());
        projectBtn.clickAndWait();
    }

    public String getLinkAttribute(String projectName) {
        return getProject(projectName).getAttribute(LINK_ATTRIBUTE.getPageConstant());
    }
}