package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    public LoginPO(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "email")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    public void digitarEmail(String texto){
        inputEmail.sendKeys(texto + Keys.TAB);
    }

    public void digitarSenha(String texto) {
        inputSenha.sendKeys(texto + Keys.ENTER);
    }

    public String obterMensagem() {
        return this.spanMensagem.getText();
    }
    
}
