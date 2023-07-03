package step;

import model.TestModel;
import ui.model.User;
import ui.pageobject.MainPage;
import ui.pageobject.ProjectPage;
import ui.pageobject.TestPage;
import ui.pageobject.component.AddProjectModal;
import ui.util.BrowserUtil;
import util.StringSeeker;

import java.util.List;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static constant.RegExpConstants.IMAGE_CODE_REGEX;
import static constant.RegExpConstants.PROJECT_ID_REGEX;

public class ActionStep {
    private MainPage mainPage = new MainPage();
    private ProjectPage projectPage = new ProjectPage();
    private AddProjectModal addProjectModal = new AddProjectModal();
    private TestPage testPage = new TestPage();

    public void passAuthorization(User user) {
        BrowserUtil.authorize(user);
    }

    public void sendTokenAndRefreshPage(String token) {
        BrowserUtil.sendTokenViaCookie(token);
        getBrowser().refresh();
    }

    public void moveToProjectPage(String projectName) {
        mainPage.clickProject(projectName);
    }

    public String getProjectId(String projectName) {
        String link = mainPage.getLinkAttribute(projectName);
        return StringSeeker.getStringByRegEx(link, PROJECT_ID_REGEX.getRegExp());
    }

    public List<TestModel> getTestListFromProjectPage() {
        return projectPage.testTable().getTestList();
    }

    public void createProject(String projectName) {
        getBrowser().goBack();
        mainPage.clickAddProjectBtn();
        getBrowser().tabs().switchToLastTab();
        addProjectModal.createNewProject(projectName);
    }

    public void closeModalAddProjectAndReturnToMain() {
        BrowserUtil.closePopUp();
        getBrowser().refresh();
    }

    public void moveToTestPage(String testName) {
        projectPage.testTable().clickLinkTest(testName);
    }

    public boolean mainPageIsOpened() {
        return mainPage.state().waitForDisplayed();
    }

    public String getFooterText() {
        return mainPage.footer().getVersionText();
    }

    public boolean projectPageIsOpened() {
        return projectPage.state().waitForDisplayed();
    }

    public boolean successMessageIsDisplayed() {
        return addProjectModal.getSuccessMessage().state().waitForDisplayed();
    }

    public boolean modalAddProjectIsClosed() {
        return addProjectModal.state().waitForNotDisplayed();
    }

    public boolean testPageIsOpened() {
        return testPage.state().waitForDisplayed();
    }

    public List<String> projectList() {
        return mainPage.getProjectList();
    }

    public TestModel getTest(String testName) {
        return projectPage.testTable().getTest(testName);
    }

    public String getEncodeScreenshotFromLink() {
        return StringSeeker.getStringByRegEx(testPage.getAttachmentLink(), IMAGE_CODE_REGEX.getRegExp());
    }

    public boolean logFieldIsEmpty() {
        return testPage.getLogText().isEmpty();
    }
}