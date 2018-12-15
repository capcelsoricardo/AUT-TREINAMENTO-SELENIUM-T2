package google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	
	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	private WebElement campoPesquisar;
	
	public void pesquisar(String valor) {
		campoPesquisar.sendKeys(valor);
		campoPesquisar.sendKeys(Keys.ENTER);
	}
}
