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
        loginPage.executarAcaoDeLogar("","");
        
        loginPage.buttonEntrar.click();
        String mensagem = loginPage.obterMensagem();
        
        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazio() {
        loginPage.executarAcaoDeLogar("teste","");
        
        loginPage.buttonEntrar.click();
        String mensagem = loginPage.obterMensagem();
        
        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("","teste");

        loginPage.buttonEntrar.click();
        String mensagem = loginPage.obterMensagem();
        
        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }
}
