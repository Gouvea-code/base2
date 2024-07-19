package com.base2.mantisbt.tests;

// Importações necessárias para o teste
import com.base2.mantisbt.BaseTest;
import com.base2.mantisbt.pages.LoginPage;
import com.base2.mantisbt.pages.MainPage;
import com.base2.mantisbt.pages.ReportIssuePage;
import com.base2.mantisbt.pages.ViewIssuePage;
import com.base2.mantisbt.utils.TestData;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.AssertJUnit.assertEquals;

public class CreateIssueMessageErrorTest extends BaseTest {

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

        // Inicializa a página de visualização do problema
        ViewIssuePage viewIssuePage = new ViewIssuePage(driver);

        // Obtém a mensagem de erro
        String errorMessage = viewIssuePage.getErrorMessage();

        // Verifica se a mensagem de erro contém o texto esperado
        assertThat(viewIssuePage.getErrorMessage(), containsString("Por favor, utilize o botão \"Voltar\" de seu navegador web para voltar à pagina anterior. Lá você pode corrigir quaisquer problemas identificados neste erro ou escolher uma outra ação. Você também pode clicar em uma opção da barra de menus para ir diretamente para outra seção."));
    }
}
