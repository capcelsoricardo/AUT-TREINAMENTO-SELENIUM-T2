package mercury.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	WebDriver driver_;
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver_ = driver;
	}
	
	@FindBy(name = "firstName")
	private WebElement campoFirstName;
	
	@FindBy(name = "lastName")
	private WebElement campoLastName;
	
	@FindBy(name = "phone")
	private WebElement campoPhone;
	
	@FindBy(id = "userName")
	private WebElement campoEmail;
	
	@FindBy(name = "address1")
	private WebElement campoAddress;

	@FindBy(name = "address2")
	private WebElement campoAddress2;
	
	@FindBy(name = "city")
	private WebElement campoCity;
	
	@FindBy(name = "state")
	private WebElement campoStateProvince;
	
	@FindBy(name = "postalCode")
	private WebElement campoPostalCode;
	
	@FindBy(name = "country")
	private WebElement comboBoxContry;
	
	@FindBy(id = "email")
	private WebElement campoUserName;
	
	@FindBy(name = "password")
	private WebElement campoPassword;
	
	@FindBy(name = "confirmPassword")
	private WebElement campoConfirmPassword;
	
	@FindBy(name = "register")
	private WebElement botaoSubmit;

	public boolean checkPage() {
		return campoFirstName.isDisplayed();
	}
	
	public void preencherContactInformation(String firstName, String lastName, String phone, 
			String email) {
		campoFirstName.sendKeys(firstName);
		campoLastName.sendKeys(lastName);
		campoPhone.sendKeys(phone);
		campoEmail.sendKeys(email);
	}
	
	public void preencherMailingInformation(String address, String address2, String city, 
			String stateProvince, String postalCode, String country) {
		campoAddress.sendKeys(address);
		campoAddress2.sendKeys(address2);
		campoCity.sendKeys(city);
		campoStateProvince.sendKeys(stateProvince);
		campoPostalCode.sendKeys(postalCode);
		new Select(comboBoxContry).selectByVisibleText(country);
	}
	
	public void preencherUserInformation(String userName, String password, 
			String confirmPassword ) {
		campoUserName.sendKeys(userName);
		campoPassword.sendKeys(password);
		campoConfirmPassword.sendKeys(confirmPassword);
	}

	public void clickSubmit() {
		botaoSubmit.click();
	}
	
	public boolean checkMensagemDear(String firstName, String lastName) {
		
		List<WebElement> elementos = driver_.findElements(By.xpath("//b[contains(text(), 'Dear " + firstName + " " + lastName +"')]"));
		
		return elementos.size() > 0;
	}
	
	public boolean checkMensagemNote(String userName) {
		
		List<WebElement> elementos = driver_.findElements(By.xpath("//b[contains(text(), 'Your user name is " + userName + "')]"));
		
		return elementos.size() > 0;
	}
}