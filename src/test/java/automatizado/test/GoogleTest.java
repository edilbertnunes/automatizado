package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;


public class GoogleTest extends BaseTest{

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes() {
        driver.get("https://www.google.com.br/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoBatataFrita() {

        //googlePage.inputPesquisa.sendKeys("Batata Frita" +Keys.ENTER);
        googlePage.pesquisar("Batata Frita");

        String resultado = googlePage.obterResultadoDaPesquisa();
        
        assertTrue(resultado, resultado.contains("Aproximadamente"));
    }

    @Test
    public void TC002_deveSerPossivelPesquisarNoGoogleOTextoNutella() {

        googlePage.pesquisar("Nutella");

        String resultado = googlePage.obterResultadoDaPesquisa();
        
        assertTrue(resultado, resultado.contains("resultados"));
    }

}