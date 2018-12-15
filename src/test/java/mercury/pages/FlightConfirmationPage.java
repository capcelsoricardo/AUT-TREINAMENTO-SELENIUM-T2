package mercury.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import treinamento.config.SetUp;


public class FlightConfirmationPage {

	WebDriver driver_;
	public FlightConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver_ = driver;
	}
	
	@FindBy(xpath = "//img[@src='/images/masts/mast_confirmation.gif']")
	private WebElement imagemFlightConfirmation;
		
	@FindBy(xpath = "//font[contains(text(),'Your ')]")
	private WebElement mensagemItineraryPartOne;
	
	@FindBy(xpath = "//font[contains(text(),'itinerary has been booked!')]")
	private WebElement mensagemItineraryPartTwo;
	
	
	
	
	public boolean checkPage() {
		return imagemFlightConfirmation.isDisplayed();
	}
	
	
	public boolean checkMensagemItinerary() { 
	
		return (mensagemItineraryPartOne.isDisplayed() && mensagemItineraryPartTwo.isDisplayed());
	}
	
	
	
}