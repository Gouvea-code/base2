package com.base2.mantisbt.tests;

// Importações necessárias para o teste
import com.base2.mantisbt.BaseTest;
import com.base2.mantisbt.pages.LoginPage;
import com.base2.mantisbt.utils.TestData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        // Inicializa a página de login
        LoginPage loginPage = new LoginPage(driver);

        // Abre a página de login
        loginPage.open();

        // Realiza o login com dados válidos
        loginPage.login(TestData.VALID_USERNAME, TestData.VALID_PASSWORD);

        // Verifica se o nome do usuário logado está correto
        assertEquals(TestData.USER_ACCOUNT_NAME, driver.findElement(loginPage.accountLink).getText());
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        // Inicializa a página de login
        LoginPage loginPage = new LoginPage(driver);

        // Abre a página de login
        loginPage.open();

        // Tenta realizar o login com dados inválidos
        loginPage.login("invalid_user", "invalid_password");

        // Verifica se a mensagem de falha está correta
        assertEquals("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.", loginPage.getFailureMessage());
    }
}
