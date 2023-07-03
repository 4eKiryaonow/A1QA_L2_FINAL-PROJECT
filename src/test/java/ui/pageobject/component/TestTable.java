package ui.pageobject.component;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import model.TestModel;
import org.openqa.selenium.By;
import ui.util.ConditionalWait;

import java.util.List;
import java.util.stream.Collectors;

public class TestTable extends Form {
    private final By rowLocator = By.cssSelector(".table tr:not(:first-child)");
    private final By cellLocator = By.tagName("td");
    private final By linkLocator = By.tagName("a");
    private final String dynamicRowLocator = "//tr[td/a[text()='%s']]";
    private static final int NAME_INDEX = 0;
    private static final int METHOD_INDEX = 1;
    private static final int RESULT_INDEX = 2;
    private static final int START_TIME_INDEX = 3;
    private static final int END_TIME_INDEX = 4;
    private static final int DURATION_INDEX = 5;

    public TestTable() {
        super(By.xpath("//*[@class='table']"), "Test Table");
    }

    private List<ILabel> getTableRows() {
        ConditionalWait.waitUntilPresented(rowLocator);
        return getElementFactory().findElements(rowLocator, ILabel.class);
    }

    private ILabel findRowByName(String nameTest) {
        By rowLocator = By.xpath(String.format(dynamicRowLocator, nameTest));
        ConditionalWait.waitUntilPresented(rowLocator);
        return getElementFactory().getLabel(rowLocator, String.format("Test row with name %s", nameTest));
    }

    public TestModel getTest(String nameTest) {
        ILabel labelRow = findRowByName(nameTest);
        List<ITextBox> cellList = getCellFromRow(labelRow);
        return getTestFromRow(cellList);
    }

    private ITextBox getLinkTest(String nameTest) {
        ILabel labelRow = findRowByName(nameTest);
        List<ITextBox> cellList = getCellFromRow(labelRow);
        return cellList.get(NAME_INDEX).findChildElement(linkLocator, ITextBox.class);
    }

    public void clickLinkTest(String nameTest) {
        ITextBox link = getLinkTest(nameTest);
        link.clickAndWait();
    }

    private List<ITextBox> getCellFromRow(ILabel element) {
        return element.findChildElements(cellLocator, ITextBox.class);
    }

    private TestModel getTestFromRow(List<ITextBox> list) {
        TestModel testModel = new TestModel();
        testModel.setName(list.get(NAME_INDEX).getText());
        testModel.setMethod(list.get(METHOD_INDEX).getText());
        testModel.setStatus(list.get(RESULT_INDEX).getText());
        testModel.setStartTime(list.get(START_TIME_INDEX).getText());
        testModel.setEndTime(list.get(END_TIME_INDEX).getText());
        testModel.setDuration(list.get(DURATION_INDEX).getText());
        return testModel;
    }

    public List<TestModel> getTestList() {
        return getTableRows()
                .stream()
                .map(this::getCellFromRow)
                .map(this::getTestFromRow)
                .collect(Collectors.toList());
    }
}