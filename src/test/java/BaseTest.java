import api.util.ParamsGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import step.ActionStep;
import step.AssertionStep;
import step.RestStep;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {
    protected RestStep restStep;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeSuite
    public void prepareForTest() {
        ParamsGenerator.getSID();
    }

    @BeforeMethod
    public void setUp() {
        restStep = new RestStep();
        actionStep = new ActionStep();
        assertionStep = new AssertionStep();
    }

    @AfterMethod()
    public void tearDown() {
        getBrowser().quit();
    }
}