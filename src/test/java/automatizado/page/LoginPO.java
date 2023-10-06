package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    //#endregion Região construtor
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    //#endregion Região construtor

    //#region Região dos WebElements
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    //#endregion Região dos WebElements


    //#region Região métodos
    /**
     * Método que obtem a mensagem disparada na tela
     * @return Texto da mensagem
     */
    public String obterMensagem() {
        return this.spanMensagem.getText();
    }

    public void executarAcaoDeLogar(String email, String senha) {
        escrever(inputEmail,email);
        escrever(inputSenha, senha);
        
        buttonEntrar.click();
    }

    //#endregion Região métodos
    
}
