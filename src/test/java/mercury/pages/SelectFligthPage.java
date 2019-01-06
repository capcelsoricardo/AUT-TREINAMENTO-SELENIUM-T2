package mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SelectFligthPage {

	WebDriver driver_;
	public SelectFligthPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver_ = driver;
	}
	
	@FindBy(xpath = "//input[@name='outFlight']//following::input[1]")
	private WebElement radioButtonDepart;

	
	@FindBy(xpath = "//input[@name='inFlight']//following::input[1]")
	private WebElement radioButtonReturn;
	
	@FindBy(name = "reserveFlights")
	private WebElement botaoReserve;
	
	public boolean checkPage() {
		return botaoReserve.isDisplayed();
	}
	
	public void selecionarIdaEVolta() {
		radioButtonDepart.click();
		radioButtonReturn.click();
	}
	
	public void clickReserve() {
		botaoReserve.click();
	}
}