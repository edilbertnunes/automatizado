package automatizado.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

/**
 * Ordena a execução do teste seguindo o nome 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
        loginPage.executarAcaoDeLogar("","");
        
        String mensagem = loginPage.obterMensagem();
        
        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazio() {
        loginPage.executarAcaoDeLogar("teste","");
        
        String mensagem = loginPage.obterMensagem();
        
        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("","teste");

        String mensagem = loginPage.obterMensagem();
        
        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaIncorretos() {
        loginPage.executarAcaoDeLogar("teste","teste");

        String mensagem = loginPage.obterMensagem();
        
        assertEquals(mensagem,"E-mail ou senha inválidos");
    }

    @Test
    public void TC005_deveLogarNoSistemaComEmailESenhaCorretos() {
        
        loginPage.executarAcaoDeLogar("admin@admin.com","admin@123");

        assertEquals(loginPage.obterTituloPagina(),"Controle de Produtos");      
    }
}

