package br.co.figueira.pages;

import org.openqa.selenium.By;

import br.co.figueira.BasePage;

public class ResumoPage extends BasePage {

	public void removerMovimentacao() {
		dsl.clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public void removerMovimentacaoDescricao(String desc) {
		dsl.clicarBotao(By.xpath(".//td[contains(text(),'"+desc+"')]/../td//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String mensagemDeConfirmação() {
		return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void setMes(String mes) {
		dsl.select("mes", mes);
	}
	
	public void setAno(String ano) {
		dsl.select("ano", ano);
	}
	
	public void buscar() {
		dsl.clicarBotao(By.xpath("//input[@value='Buscar']"));
	}
}
