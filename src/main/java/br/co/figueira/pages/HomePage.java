package br.co.figueira.pages;

import org.openqa.selenium.By;

import br.co.figueira.BasePage;

public class HomePage extends BasePage {
	
	public String getSaldo(String conta) {
		return dsl.retornaTxtPag(By.xpath(".//td[contains(text(),'"+conta+"')]/../td[2]"));
	}
	
	public void clicarReset() {
		dsl.clicarLink("reset");
	}

}
