package automatizado.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.page.LoginPO;

public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
    }


    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
        loginPage.digitarEmail("");
        loginPage.digitarSenha("");
        loginPage.buttonEntrar.click();
        String mensagem = loginPage.obterMensagem();
        
        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }
}
