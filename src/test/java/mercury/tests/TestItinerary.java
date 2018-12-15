package mercury.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import mercury.pages.BookAFlightPage;
import mercury.pages.FlightConfirmationPage;
import mercury.pages.HomePage;
import mercury.pages.LoginPage;
import mercury.pages.SelectFligthPage;
import treinamento.config.SetUp;


public class TestItinerary {

	private WebDriver driver;

	@Before
	public void startTest() {
		
		SetUp setUp = new SetUp();
		driver = setUp.createBrowser("CHROME", "http://newtours.demoaut.com/");
	}

	@Test
	public void realizarItinerary() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.realizarLogin("mercury", "mercury");
		 
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue("Login NAO foi realizado com sucesso.", homePage.checkPage());
		
		homePage.preencherFlightDetails("One Way", "2", "New York", "January", "12", "San Francisco", "March", "12");
		homePage.preencherPreferences("Economy class", "Unified Airlines");
		homePage.clickContinue();
		
		SelectFligthPage selectFlightPage = new SelectFligthPage(driver);
		Assert.assertTrue("Página Select Flight NAO foi apresentada com sucesso.", selectFlightPage.checkPage());
		
		selectFlightPage.selecionarIdaEVolta();
		selectFlightPage.clickReserve();
		
		BookAFlightPage bookAFlightPage = new BookAFlightPage(driver);
		Assert.assertTrue("Página Book a Flight NAO foi apresentada com sucesso.", bookAFlightPage.checkPage());
		
		bookAFlightPage.preencherPassengers("Celso Ricardo", "de Oliveira Ferreira", "Hindu");
		bookAFlightPage.preencherCreditCard("Visa", "12345464575343456", "12", "2010", "Celso", "Ricardo", "Ferreira");
		bookAFlightPage.preencherBillingAddress("Rua Custodio", "São Paulo", "CR", "20334", "UNITED STATES");
		bookAFlightPage.preencherDeliveryAddress("Rua Paraiso do Luar", "Porto de Galinhas", "PG", "20334", "UNITED STATES");
		bookAFlightPage.clickSecurePurchase();
		
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		Assert.assertTrue("Página Flight Confirmation NAO foi apresentada com sucesso.", flightConfirmationPage.checkPage());
		
		Assert.assertTrue("Itinerario NAO foi realizado com sucesso.", flightConfirmationPage.checkMensagemItinerary());
		
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
