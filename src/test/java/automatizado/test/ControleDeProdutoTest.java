package automatizado.test;


import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleDeProdutoPage;
     
    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com","admin@123");
        controleDeProdutoPage = new ControleDeProdutoPO(driver);

        assertEquals(controleDeProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
        controleDeProdutoPage.buttonAdicionar.click();
        // TODO: remover esse clique assim que o sistema for corrigido
        controleDeProdutoPage.buttonAdicionar.click();

        String titulo = controleDeProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);
    }
    
}
