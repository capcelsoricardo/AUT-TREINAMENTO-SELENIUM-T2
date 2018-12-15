package mtp.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;

import google.pages.GooglePage;
import google.pages.ResultadoPesquisaGooglePage;
import mtp.pages.FabricaDeTestesPage;
import treinamento.config.SetUp;


public class TestsMTP {

	private WebDriver driver;

	@Before
	public void startTest() {
		
		SetUp setUp = new SetUp();
		driver = setUp.createBrowser("CHROME", "https://google.com.br");
	}

	@Test
	public void pesquisarGoogle() throws FindFailed {
		
		GooglePage googlePage = new GooglePage(driver);
		googlePage.pesquisar("Fábrica de Testes MTP");
		
		ResultadoPesquisaGooglePage resultadoPesquisaGooglePage = new ResultadoPesquisaGooglePage(driver);
		
		Assert.assertTrue("Link da MTP NÃO encontrado", resultadoPesquisaGooglePage.checkPesquisa());
		resultadoPesquisaGooglePage.clickLinkMTP();
		
		FabricaDeTestesPage fabricaDeTestesPage = new FabricaDeTestesPage(driver);
		
		Assert.assertTrue("Página Fabrica de Testes NÃO foi apresentada.",fabricaDeTestesPage.checkPage());
		
		fabricaDeTestesPage.clickButtonEuConcordoPorImagem();
		
		fabricaDeTestesPage.clickMenu();
		
		Assert.assertTrue("Mensagem da Fabrica de Testes NÃO foi apresentada.",fabricaDeTestesPage.checkMensagem());
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
