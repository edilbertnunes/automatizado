package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected static WebDriver driver;
    private static final String URL_BASE = "file:///C:/Users/edinunes/dev/workspace-vscode/selenium-weberson/automatizado/sistema/login.html";
    // trocar versão do driver para versão do seu navegador. Observe que a versão utilizada neste projeto é a 117
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v117.0.5938.149.exe";

    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterClass
    public static void finalizar() {
        driver.quit();
    }

}
