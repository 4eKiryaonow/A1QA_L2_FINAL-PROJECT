package step;

import model.TestModel;
import org.testng.Assert;
import util.SortUtil;

import java.util.List;


public class AssertionStep {
    public void pageIsOpened(boolean isOpened) {
        Assert.assertTrue(isOpened, "Page is not opened");
    }

    public void checkVariantOnMainPage(boolean isOpened, String variant, String footerText) {
        pageIsOpened(isOpened);
        Assert.assertTrue(footerText.contains(variant), "Footer doesn't contain the variant");
    }

    public void testListIsSortedByDate(List<TestModel> testModelList) {
        Assert.assertEquals(testModelList, SortUtil.sortTestList(testModelList), "List on Page is not sorted");
    }

    public void testListIsEqualAPI(List<TestModel> testModelList, List<TestModel> testListAPI) {
        Assert.assertTrue(testListAPI.containsAll(testModelList), "List on Page is not equals API");
    }

    public void checkTestListOnProjectPage(List<TestModel> testModelList, List<TestModel> testListAPI) {
        testListIsSortedByDate(testModelList);
        testListIsEqualAPI(testModelList, testListAPI);
    }

    public void successMessageIsDisplayed(boolean isDisplayed) {
        Assert.assertTrue(isDisplayed, "Success message is not displayed");
    }

    public void modalAddProjectIsClosed(boolean isClosed) {
        Assert.assertTrue(isClosed, "Modal Add Project is nor closed");
    }

    public void projectInProjectList(String projectName, List<String> projectList, boolean isOpened) {
        pageIsOpened(isOpened);
        Assert.assertTrue(projectList.contains(projectName));
    }

    public void testIsOnProjectPage(String testName, String methodName, TestModel test) {
        Assert.assertEquals(test.getName(), testName, "Test Name doesn't match");
        Assert.assertEquals(test.getMethod(), methodName, "Test Method doesn't match");
    }

    public void checkLogAndScreenshot(boolean isOpened, boolean logIsEmpty, String encodeScreenshot, String actualEncodedImage) {
        pageIsOpened(isOpened);
        Assert.assertFalse(logIsEmpty, "Log Field is empty");
        Assert.assertEquals(encodeScreenshot, actualEncodedImage, "Screenshot code doesn't match");
    }
}
