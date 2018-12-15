package mercury.tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import mercury.pages.LoginPage;
import mercury.pages.RegisterPage;
import treinamento.config.SetUp;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src/test/resources/massa-de-dados.xls")
public class TestRegister {

	private WebDriver driver;

	@Before
	public void startTest() {
		
		SetUp setUp = new SetUp();
		driver = setUp.createBrowser("CHROME", "http://newtours.demoaut.com/");
	}

	@Test
	public void realizarRegistro(@Param(name = "FIRST_NAME") String first_name, @Param(name = "LAST_NAME") String last_name, 
			@Param(name = "PHONE") String phone, @Param(name = "EMAIL") String email, @Param(name = "ADDRESS") String address, 
			@Param(name = "ADDRESS_2") String address_2, @Param(name = "CITY") String city, 
			@Param(name = "STATE_PROVINCE") String state_province, @Param(name = "POSTAL_CODE") String postal_code, 
			@Param(name = "COUNTRY") String country, @Param(name = "USER_NAME") String user_name, 
			@Param(name = "PASSWORD") String password, @Param(name = "CONFIRM_PASSWORD") String confirm_password  ) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLinkRegister();
		
		RegisterPage registerPage = new RegisterPage(driver);
		
		Assert.assertTrue("Página Register NÃO foi apresentada com sucesso.", registerPage.checkPage());
		
		registerPage.preencherContactInformation(first_name, last_name, phone, email);
		
		registerPage.preencherMailingInformation(address, address_2, city, state_province, postal_code, country);
		
		registerPage.preencherUserInformation(user_name, password, confirm_password);

		registerPage.clickSubmit();
		
		
		Assert.assertTrue("Registro NÃO realizado com sucesso. A mensagem 'Dear " + first_name + " " + last_name + "' NÃO foi apresentada.",registerPage.checkMensagemDear(first_name, last_name));
		
		Assert.assertTrue("Registro NÃO realizado com sucesso. A mensagem 'Your user name is " + user_name +  "' NÃO foi apresentada.", registerPage.checkMensagemNote(user_name));
		
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
