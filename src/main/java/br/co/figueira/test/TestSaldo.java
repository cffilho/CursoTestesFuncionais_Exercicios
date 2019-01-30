package br.co.figueira.test;

import org.junit.Assert;
import org.junit.Test;

import br.co.figueira.BaseTest;
import br.co.figueira.pages.HomePage;
import br.co.figueira.pages.MenuPage;

public class TestSaldo extends BaseTest {
	
	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void obterSaldo() {
		
		menuPage.home();
		
		Assert.assertEquals("534.00", homePage.getSaldo("Conta para saldo"));
		
	}

}
