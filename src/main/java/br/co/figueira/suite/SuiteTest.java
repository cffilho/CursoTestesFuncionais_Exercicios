package br.co.figueira.suite;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.co.figueira.DriveFactory;
import br.co.figueira.pages.HomePage;
import br.co.figueira.pages.LoginPage;
import br.co.figueira.test.TestContas;
import br.co.figueira.test.TestExcluirContaComMovimentação;
import br.co.figueira.test.TestMovimentacao;
import br.co.figueira.test.TestResumo;
import br.co.figueira.test.TestSaldo;


	@RunWith(Suite.class)
	@SuiteClasses({
		
		TestContas.class,
		TestMovimentacao.class,
		TestExcluirContaComMovimentação.class,
		TestSaldo.class,
		TestResumo.class
		
		
				})
	
	public class SuiteTest {
		
	private static LoginPage loginPage = new LoginPage();
	private static HomePage homePage = new HomePage();
	
	@BeforeClass
	public static void reset() {
		
		loginPage.acessar();
		loginPage.setEmail("maria.jose@gmail.com");
		loginPage.setPassword("123456");
		loginPage.buttonEntrar();
		
		homePage.clicarReset();
		
		DriveFactory.killDriver();
		
	}
		
		
	}
