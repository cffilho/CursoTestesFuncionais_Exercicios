package br.co.figueira;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.co.figueira.Propriedades.TipoExecucao;


public class DriveFactory {
	
//	private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
	};
	
	private DriveFactory() {}
	
	public static WebDriver getDriver(){
		return threadDriver.get();
	}
	
	public static WebDriver initDriver(){
		WebDriver driver = null;
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
		switch (Propriedades.BROWSER) {
			
			case FIREFOX: 
			System.setProperty("webdriver.gecko.driver", "\\Users\\Figueira\\Documents\\Drivers\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

			case CHROME:
			System.setProperty("webdriver.chrome.driver", "\\Users\\Figueira\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
			case IE:
			System.setProperty("webdriver.ie.driver", "\\Users\\Figueira\\Documents\\Drivers\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		 }
		}
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch(Propriedades.BROWSER) {
			
			case FIREFOX: cap = DesiredCapabilities.firefox();
			break;
			
			case CHROME: cap = DesiredCapabilities.chrome();
			break;
			
			case IE: cap = DesiredCapabilities.internetExplorer();
			break;
			}
			
			try {
				driver = new RemoteWebDriver(new URL(""), cap);
			} catch (MalformedURLException exp){
				System.err.println("Falha na conexão com a Nuvem");
				exp.printStackTrace();
			}
			
		}
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
			DesiredCapabilities cap = null;
			switch(Propriedades.BROWSER) {
			
			case FIREFOX: 
				cap = DesiredCapabilities.firefox();
				break;
				
			case CHROME: 
				cap = DesiredCapabilities.firefox();
				break;
				
			case IE: 
				cap = DesiredCapabilities.internetExplorer();
				break;	
				
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://figueira:a4e61a62-3c37-4ce1-9b49-1f40a11d40b8@ondemand.saucelabs.com:80"), cap);
			} catch (MalformedURLException exp){
				System.err.println("Falha na conexão com a Nuvem");
				exp.printStackTrace();
			}
			
		}
				
		return driver;
	}

	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
	
}
