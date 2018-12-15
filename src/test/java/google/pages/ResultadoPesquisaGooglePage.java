package google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultadoPesquisaGooglePage {
	
	public ResultadoPesquisaGooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[contains(text(), 'Serviços de Garantia da Qualidade - Fábrica de Testes | MTP')]")
	private WebElement linkMTP;
	
	public void clickLinkMTP() {
		linkMTP.click();
	}
	
	public boolean checkPesquisa() {
		return linkMTP.isDisplayed();
	}
}
