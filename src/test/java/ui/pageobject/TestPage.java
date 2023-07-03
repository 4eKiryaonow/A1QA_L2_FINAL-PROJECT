package ui.pageobject;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import static ui.constant.PageConstants.LINK_ATTRIBUTE;

public class TestPage extends Form {
    private final ITextBox logTextField = getElementFactory().getTextBox(By.xpath("//div[text()='Logs']//..//td"), "Log Text Field");
    private final ILabel attachmentLabel = getElementFactory().getLabel(By.xpath("//div[text()='Attachments']//..//a"), "Attachment Label");

    public TestPage() {
        super(By.xpath("//div[@class='panel-heading' and text()='Common info']"), "Test Page");
    }

    public String getLogText() {
        return logTextField.getText();
    }

    public String getAttachmentLink() {
        return attachmentLabel.getAttribute(LINK_ATTRIBUTE.getPageConstant());
    }
}