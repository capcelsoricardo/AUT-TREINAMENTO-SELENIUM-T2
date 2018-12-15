package mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "userName")
	private WebElement campoUsuario;
	
	@FindBy(name = "password")
	private WebElement campoPassword;
	
	@FindBy(name = "login")
	private WebElement botaoSignIn;
	
	@FindBy(linkText = "REGISTER")
	private WebElement linkRegister;
	
	public void realizarLogin(String user, String pass) {
		campoUsuario.sendKeys(user);
		campoPassword.sendKeys(pass);
		botaoSignIn.click();
	}
	
	public void clickLinkRegister() {
		linkRegister.click();
	}
	
}
