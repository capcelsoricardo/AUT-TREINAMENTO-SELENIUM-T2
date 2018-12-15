package mercury.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import treinamento.config.SetUp;


public class BookAFlightPage {

	WebDriver driver_;
	public BookAFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver_ = driver;
	}
	
	@FindBy(xpath = "//img[@src='/images/masts/mast_book.gif']")
	private WebElement imagemBookAFlight;
	
	
	@FindBy(name = "passFirst0")
	private WebElement campoFirstName;
	
	@FindBy(name = "passLast0")
	private WebElement campoLastName;
	
	@FindBy(name = "pass.0.meal")
	private WebElement comboBoxMeal;
	
	
	@FindBy(name = "creditCard")
	private WebElement comboBoxCardType;
	
	@FindBy(name = "creditnumber")
	private WebElement campoNumberCard;
	
	@FindBy(name = "cc_exp_dt_mn")
	private WebElement comboBoxDayExpirationCard;
	
	@FindBy(name = "cc_exp_dt_yr")
	private WebElement comboBoxYearExpirationCard;
	
	@FindBy(name = "cc_frst_name")
	private WebElement campoFirstNameCard;

	@FindBy(name = "cc_mid_name")
	private WebElement campoMiddleNameCard;
	
	@FindBy(name = "cc_last_name")
	private WebElement campoLastNameCard;
	
	
	@FindBy(name = "billAddress1")
	private WebElement campoAddress;
	
	@FindBy(name = "billCity")
	private WebElement campoCity;
	
	@FindBy(name = "billState")
	private WebElement campoStateProvince;
	
	@FindBy(name = "billZip")
	private WebElement campoPostalCode;
	
	@FindBy(name = "billCountry")
	private WebElement comboBoxCountry;
	
		
	@FindBy(name = "delAddress1")
	private WebElement campoAddressDelivery;
	
	@FindBy(name = "delCity")
	private WebElement campoCityDelivery;
	
	@FindBy(name = "delState")
	private WebElement campoStateProvinceDelivery;
	
	@FindBy(name = "delZip")
	private WebElement campoPostalCodeDelivery;
	
	@FindBy(name = "delCountry")
	private WebElement comboBoxCountryDelivery;
	
	
	@FindBy(name = "buyFlights")
	private WebElement botaoSecurePurchase;
	
	
	public boolean checkPage() {
		return imagemBookAFlight.isDisplayed();
	}
	
	
	public void preencherPassengers(String firstName, String lastName, String meal) { 
		
		campoFirstName.sendKeys(firstName);
		campoLastName.sendKeys(lastName);
		new Select(comboBoxMeal).selectByVisibleText(meal);
	}
	
	public void preencherCreditCard(String cardType, String number, String expirationDay, String expirationYear, String firstName, String middleName, String lastName) {		
		
		new Select(comboBoxCardType).selectByVisibleText(cardType);
		campoNumberCard.sendKeys(number);
		new Select(comboBoxDayExpirationCard).selectByVisibleText(expirationDay);
		new Select(comboBoxYearExpirationCard).selectByVisibleText(expirationYear);
		campoFirstNameCard.sendKeys(firstName);
		campoMiddleNameCard.sendKeys(middleName);
		campoLastNameCard.sendKeys(lastName);
	}
	
	public void preencherBillingAddress(String address, String city, String stateProvince, String postalCode, String country) { 
		campoAddress.sendKeys(address);
		campoCity.sendKeys(city);
		campoStateProvince.sendKeys(stateProvince);
		campoPostalCode.sendKeys(postalCode);
		new Select(comboBoxCountry).selectByVisibleText(country);
	}
	
	public void preencherDeliveryAddress(String address, String city, String stateProvince, String postalCode, String country) {
		campoAddressDelivery.sendKeys(address);
		campoCityDelivery.sendKeys(city);
		campoStateProvinceDelivery.sendKeys(stateProvince);
		campoPostalCodeDelivery.sendKeys(postalCode);
		new Select(comboBoxCountryDelivery).selectByVisibleText(country);
	}
	
	public void clickSecurePurchase() {
		botaoSecurePurchase.click();
	}
	
}