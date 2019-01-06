package broadleaf.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import treinamento.utils.Helper;

public class AddOnProductsPage {

	private Helper helper = null;
	
	public AddOnProductsPage (WebDriver driver){
		PageFactory.initElements(driver, this);
		helper = new Helper(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Add-on Products')]")
	private WebElement titlePage;
	
	@FindBy(xpath = "//button[@class='button primary large add-main-entity']")
	private WebElement botaoAddProduct;
	
	@FindBy(id = "fields'defaultSku__name'.value")           
	private WebElement campoName;
	
	@FindBy(xpath = "//div[@class='redactor-editor']")
	private WebElement campoDescription;
	
	@FindBy(id = "fields'manufacturer'.value")           
	private WebElement campoManufacturer;
	
	@FindBy(id = "fields'defaultSku__embeddedSku__keywords'.value")           
	private WebElement campoKeywords;
	
	@FindBy(xpath = "//button[@class='to-one-lookup secondary button']")
	private WebElement botaoPesquisar;
	
	@FindBy(xpath = "//td[@title='Home']")
	private WebElement opcaoParentCategoryHome;
	
	@FindBy(xpath = "//button[@class='tiny radius dark row-action button primary tree-list-grid-lookup-select single-action-only']")
	private WebElement botaoParentCategorySelect;
	
	@FindBy(xpath = "//a[@href='#tab2']")
	private WebElement abaPricing;
	
	@FindBy(xpath = "//a[@href='#tab1']")
	private WebElement abaGeneral;
	
	@FindBy(id = "fields'defaultSku__retailPrice'.value")
	private WebElement campoMsrp;
	
	@FindBy(id = "fields'defaultSku__salePrice'.value")
	private WebElement campoPrice;
	
	@FindBy(id = "fields'defaultSku__cost'.value")
	private WebElement campoCost;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement botaoSave;
	
	@FindBy(xpath = "//span[contains(text(),'Successfully saved')]")
	private WebElement mensagemInclusaoComSucesso;
	
	
	public boolean checkPage() {
		return titlePage.isDisplayed();
	}
	
	public boolean checkMensagemInclusaoComSucesso() { 
		return mensagemInclusaoComSucesso.isDisplayed();
	}
	
	public boolean checkRegistroIncluido(String name) { 
		return helper.elementExist(name);
	}
	
	public void incluirProduto(String name, String description, String manufacturer, String keywords, String msrp,
			String price, String cost) { 
			
		botaoAddProduct.click();
		
		campoName.sendKeys(name);
		campoDescription.sendKeys(description);
		
		incluirParentCategory();
		
		campoManufacturer.sendKeys(manufacturer);
		campoKeywords.sendKeys(keywords);		
		
		abaGeneral.sendKeys(Keys.TAB, Keys.ENTER);
		
		campoMsrp.sendKeys(msrp);
		campoPrice.sendKeys(price);
		campoCost.sendKeys(cost);
		
		botaoSave.click();
	}

	public void incluirParentCategory() { 
		botaoPesquisar.click();
		opcaoParentCategoryHome.click();
		botaoParentCategorySelect.click();
	}
}
