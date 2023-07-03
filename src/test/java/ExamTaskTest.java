import api.dto.CreateTestRequest;
import api.util.ParamsGenerator;
import hoard.TestDataManager;
import model.TestModel;
import org.testng.annotations.Test;
import util.LoggerManager;
import util.RandomStringUtil;

import java.util.List;

public class ExamTaskTest extends BaseTest {
    @Test(testName = "Comparing Test list and creation new project")
    public void compareTestListAndCreationProjectTest() {
        LoggerManager.info("Шаг 1. Запросом к апи получить токен согласно номеру варианта");
        String token = restStep.getToken(TestDataManager.getVariant());
        LoggerManager.info("Шаг 2. Перейти на сайт. Пройти необходимую авторизацию. С помощью cookie передать сгенерированный на шаге 1 токен(параметр token). Обновить страницу.");
        actionStep.passAuthorization(TestDataManager.getUser());
        boolean pageIsOpened = actionStep.mainPageIsOpened();
        assertionStep.pageIsOpened(pageIsOpened);
        actionStep.sendTokenAndRefreshPage(token);
        pageIsOpened = actionStep.mainPageIsOpened();
        String footerText = actionStep.getFooterText();
        assertionStep.checkVariantOnMainPage(pageIsOpened, TestDataManager.getVariant(), footerText);
        LoggerManager.info("Шаг 3. Перейти на страницу проекта Nexage. Запросом к апи получить список тестов в JSON\\XML -формате.");
        String projectId = actionStep.getProjectId(TestDataManager.getProjectName());
        actionStep.moveToProjectPage(TestDataManager.getProjectName());
        pageIsOpened = actionStep.projectPageIsOpened();
        assertionStep.pageIsOpened(pageIsOpened);
        List<TestModel> testListAPI = restStep.getTestList(projectId);
        List<TestModel> testListUI = actionStep.getTestListFromProjectPage();
        assertionStep.checkTestListOnProjectPage(testListUI, testListAPI);
        LoggerManager.info("Шаг 4.1. Вернуться на предыдущую страницу в браузере(страница проектов). Нажать на +Add. Ввести название проекта, и сохранить.");
        String projectName = RandomStringUtil.getRandomString(TestDataManager.getLengthRandomString());
        actionStep.createProject(projectName);
        assertionStep.successMessageIsDisplayed(actionStep.successMessageIsDisplayed());
        LoggerManager.info("Шаг 4.2. Для закрытия окна добавления проекта вызвать js-метод closePopUp(). Обновить страницу.");
        actionStep.closeModalAddProjectAndReturnToMain();
        assertionStep.modalAddProjectIsClosed(actionStep.modalAddProjectIsClosed());
        pageIsOpened = actionStep.mainPageIsOpened();
        assertionStep.projectInProjectList(projectName, actionStep.projectList(), pageIsOpened);
        LoggerManager.info("Шаг 5. Перейти на страницу созданного проекта. Добавить тест через API(вместе с логом и скриншотом текущей страницы)");
        actionStep.moveToProjectPage(projectName);
        CreateTestRequest request = ParamsGenerator.createTestRequest(projectName, TestDataManager.getLengthRandomString());
        String encodeScreenshot = restStep.addTest(request);
        TestModel test = actionStep.getTest(request.getTestName());
        assertionStep.testIsOnProjectPage(request.getTestName(), request.getMethodName(), test);
        actionStep.moveToTestPage(request.getTestName());
        pageIsOpened = actionStep.testPageIsOpened();
        String actualEncode = actionStep.getEncodeScreenshotFromLink();
        assertionStep.checkLogAndScreenshot(pageIsOpened, actionStep.logFieldIsEmpty(), encodeScreenshot, actualEncode);
    }
}