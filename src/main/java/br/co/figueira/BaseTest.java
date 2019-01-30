package br.co.figueira;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.co.figueira.pages.LoginPage;


public class BaseTest {
	
	private LoginPage page = new LoginPage();
	
	@Before
	public void acessar() {
		
		page.acessar();
		page.setEmail("maria.jose@gmail.com");
		page.setPassword("123456");
		page.buttonEntrar();
		
	}
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void encerrar() throws IOException {
		
		
		TakesScreenshot ss = (TakesScreenshot) DriveFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + 
				"ss" + File.separator + 
				testName.getMethodName() + ".jpg"));
		
		if(Propriedades.CLOSE_BROWSER) {
		DriveFactory.killDriver();
		}
	}

}
