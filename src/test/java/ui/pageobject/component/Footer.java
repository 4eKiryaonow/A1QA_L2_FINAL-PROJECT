package ui.pageobject.component;

import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class Footer extends Form {
    private final ITextBox versionText = getElementFactory().getTextBox(By.xpath("//*[@class='footer']//span"), "Version Text");

    public Footer() {
        super(By.className("footer"), "Footer Component");
    }

    public String getVersionText() {
        return versionText.getText();
    }
}