package ui.pageobject;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import ui.pageobject.component.TestTable;

public class ProjectPage extends Form {
    private TestTable testTable;

    public ProjectPage() {
        super(By.xpath("//div[contains(text(), 'Total tests progress')]"), "Project Page");
        this.testTable = new TestTable();
    }

    public TestTable testTable() {
        return this.testTable;
    }
}