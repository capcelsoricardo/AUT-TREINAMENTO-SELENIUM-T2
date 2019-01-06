package broadleaf.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import treinamento.utils.Helper;

public class MenuPage {
	
	private Helper helper; 

	WebDriver driver_ = null;
	public MenuPage (WebDriver driver){
		PageFactory.initElements(driver, this);
		helper = new Helper(driver);
	}
	
	@FindBy(xpath = "//a[@class='nav-section blc-icon-catalog']")
	private WebElement linkCatalog;
	
	@FindBy(xpath = "//a[contains(text(),'Add-on Products')]")
	private WebElement subLinkCatalogAddProducts;
	
	@FindBy(xpath = "//li[@class='active']")
	private WebElement subLinkAllProducts;
	
	
	public void clickMenuCatalogAddOnProducts (){
		linkCatalog.click();
		
		if(helper.aguardarElementoClicavel(subLinkCatalogAddProducts, 10))
			subLinkCatalogAddProducts.click();
		else
			Assert.fail("SubLink 'Catalog Add Products NÃO foi apresentado com sucesso.");
			
	}
}
