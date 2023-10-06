package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas pagesObject.
 * Todas as pages devem ser herdadas desta classe
 */
public abstract class BasePO {

    /** Driver base que será usado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para criação da fábrica de elementos (PageFactory).
     * @param driver Driver da página atual
     */
    public BasePO (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** Método que retorna o título da página atual */
    public String obterTituloPagina() {
        return driver.getTitle();
    }

    /**
     * Método que sabe escrever em qualquer WebElment do tipo input e dá um tab ao final
     * @param input Input a quala será escrito
     * @param texto Texto que será escrito no input
     */
    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
}
