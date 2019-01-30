package br.co.figueira.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.co.figueira.BasePage;
import br.co.figueira.DriveFactory;

public class CriarMovimentacaoPage extends BasePage {

	public void setTipoMovimentacao(String tipo) {
		dsl.select("tipo", tipo);
	}
	
	public void setDataMovimentacao(String data) {
		dsl.escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		dsl.escrever("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		dsl.escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		dsl.escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		dsl.escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		dsl.select("conta", conta);
	}
	
	public void setPago() {
		dsl.selecionarRadio("status_pago");
	}
	
	public void setPendente() {
		dsl.selecionarRadio("status_pendente");
	}
	
	public void salvar() {
		dsl.clicarBotao(By.xpath("//button[@type='submit']"));
	}
	
	public String mensagemDeConfirmação() {
		return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String mensagemDeErro() {
		return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public List<String> obterErros(){
		List<WebElement> erros = DriveFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
	
	

}
