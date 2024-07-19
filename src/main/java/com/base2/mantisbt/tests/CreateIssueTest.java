package com.base2.mantisbt.tests;

// Importações necessárias para o teste
import com.base2.mantisbt.BaseTest;
import com.base2.mantisbt.pages.LoginPage;
import com.base2.mantisbt.pages.MainPage;
import com.base2.mantisbt.pages.ReportIssuePage;
import com.base2.mantisbt.pages.ViewIssuePage;
import com.base2.mantisbt.utils.TestData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class CreateIssueTest extends BaseTest {

    @Test
    public void testCreateNewIssue() {
        // Inicializa a página de login
        LoginPage loginPage = new LoginPage(driver);

        // Abre a página de login
        loginPage.open();

        // Realiza o login com dados válidos
        loginPage.login(TestData.VALID_USERNAME, TestData.VALID_PASSWORD);

        // Verifica se o nome do usuário logado está correto
        assertEquals(TestData.USER_ACCOUNT_NAME, driver.findElement(loginPage.accountLink).getText());

        // Inicializa a página principal
        MainPage mainPage = new MainPage(driver);

        // Clica no link para reportar um problema
        mainPage.clickReportIssueLink();

        // Inicializa a página de reportar problema
        ReportIssuePage reportIssuePage = new ReportIssuePage(driver);

        // Seleciona a categoria do problema
        reportIssuePage.selectCategory(TestData.ISSUE_CATEGORY);

        // Seleciona a reprodutibilidade do problema
        reportIssuePage.selectReproducibility(TestData.ISSUE_REPRODUCIBILITY);

        // Seleciona a severidade do problema
        reportIssuePage.selectSeverity(TestData.ISSUE_SEVERITY);

        // Seleciona a prioridade do problema
        reportIssuePage.selectPriority(TestData.ISSUE_PRIORITY);

        // Insere o resumo do problema
        reportIssuePage.enterSummary(TestData.ISSUE_SUMMARY);

        // Insere a descrição do problema
        reportIssuePage.enterDescription(TestData.ISSUE_DESCRIPTION);

        // Clica no botão para submeter o problema
        reportIssuePage.clickSubmitReportButton();

        // 1. Verificar a mensagem de sucesso
        String successMessage = "Operação realizada com sucesso.";
        assertTrue(reportIssuePage.isIssueCreated(), successMessage);

        // 2. Redirecionamento para a página de detalhes da issue (viewIssuePage)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera explícita pela URL da página de detalhes
        wait.until(ExpectedConditions.urlContains("view.php?id="));

        // 3. Verificar se o resumo da issue está presente na página de detalhes
        ViewIssuePage viewIssuePage = new ViewIssuePage(driver);
        assertThat(viewIssuePage.getIssueSummary(), containsString(TestData.ISSUE_SUMMARY));
    }
}
