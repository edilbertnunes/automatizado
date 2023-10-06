package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herença para todoas as classes de teste
 */
public abstract class BaseTest {

    /** Driver do navegador da página atual */
    
    protected static WebDriver driver;
     /** caminhoa base da URL do sistema a ser testado */
    private static final String URL_BASE = "file:///C:/Users/edinunes/dev/workspace-vscode/selenium-weberson/automatizado/sistema/login.html";
    // trocar versão do driver para versão do seu navegador. Observe que a versão utilizada neste projeto é a 117
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v117.0.5938.149.exe";

    /** Método para inicar o driver do navegador antes de qualquer classe de teste */
    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /** Método que finaliza o driver do navegador depois de qualquer classe de teste */
    @AfterClass
    public static void finalizar() {
        driver.quit();
    }

}
