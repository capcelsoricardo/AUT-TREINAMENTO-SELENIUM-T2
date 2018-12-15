package mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement linkSignOff;
	
	
	@FindBy(xpath = "//input[@value='roundtrip']")
	private WebElement radioButtonRoundTrip;
	
	@FindBy(xpath = "//input[@value='oneway']")
	private WebElement radioButtonOneWay;
		
	@FindBy(name = "passCount")
	private WebElement comboBoxPassengers;
	
	@FindBy(name = "fromPort")
	private WebElement comboBoxDepartingFrom;
	
	@FindBy(name = "fromMonth")
	private WebElement comboBoxOnMonth;
	
	@FindBy(name = "fromDay")
	private WebElement comboBoxOnDay;
	
	@FindBy(name = "toPort")
	private WebElement comboBoxArrivingIn;
	
	@FindBy(name = "toMonth")
	private WebElement comboBoxReturnMonth;
	
	@FindBy(name = "toDay")
	private WebElement comboBoxReturnDay;
	
	@FindBy(xpath = "//input[@value='Coach']")
	private WebElement radioButtonEconomyClass;
	
	@FindBy(xpath = "//input[@value='Business']")
	private WebElement radioButtonBusinessClass;
	
	@FindBy(xpath = "//input[@value='First']")
	private WebElement radioButtonFirstClass;
	
	@FindBy(name = "airline")
	private WebElement comboBoxAirline;
	
	@FindBy(name = "findFlights")
	private WebElement botaoContinue;

	
	
	public boolean checkPage() {
		return linkSignOff.isDisplayed();
	}
	
	public void preencherFlightDetails(String type, String passengers, String departFrom, String onMonth, String onDay, String arrivingIn, String returningMonth, String returningDay) { 
	
		if(type.toUpperCase().contains("ONE"))
			radioButtonOneWay.click();
		else
			radioButtonRoundTrip.click();
			
		new Select(comboBoxPassengers).selectByVisibleText(passengers);
		new Select(comboBoxDepartingFrom).selectByVisibleText(departFrom);
		new Select(comboBoxOnMonth).selectByVisibleText(onMonth);
		new Select(comboBoxOnDay).selectByVisibleText(onDay);
		new Select(comboBoxArrivingIn).selectByVisibleText(arrivingIn);
		new Select(comboBoxReturnMonth).selectByVisibleText(returningMonth);
		new Select(comboBoxReturnDay).selectByVisibleText(returningDay);
	}
	
	public void preencherPreferences(String serviceClass, String airline) { 
		
		if(serviceClass.toUpperCase().equals("ECONOMY CLASS")) 
			radioButtonEconomyClass.click();
		if(serviceClass.toUpperCase().equals("BUSINESS CLASS"))
			radioButtonBusinessClass.click();
		if(serviceClass.toUpperCase().equals("FIRST CLASS"))
			radioButtonFirstClass.click();
		
		new Select(comboBoxAirline).selectByVisibleText(airline);
	}
	
	public void clickContinue() { 
		botaoContinue.click();
	}
	
}
