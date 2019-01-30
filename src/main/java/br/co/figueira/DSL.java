package br.co.figueira;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import br.co.figueira.DriveFactory;

public class DSL {
	


	/** Text Field **/
	public void escrever(By by, String txt) {
		DriveFactory.getDriver().findElement(by).clear();
		DriveFactory.getDriver().findElement(by).sendKeys(txt);
		
	}
	
	public void escrever(String campo_id, String txt) {
		escrever(By.id(campo_id), txt);;
	}
	
	public String retornaTexto(String campo_id) {
		return DriveFactory.getDriver().findElement(By.id(campo_id)).getAttribute("value");
	}
	
	/** Radio Button **/
	public void selecionarRadio(By by) {
		DriveFactory.getDriver().findElement(by).click();
	}
	
	public void selecionarRadio(String campo_id) {
		selecionarRadio(By.id(campo_id));
	}
	
	public boolean radioEstaSelecionado(String campo_id) {
		return DriveFactory.getDriver().findElement(By.id(campo_id)).isSelected();
	}
	
	/** Check Button **/
	public void selecionarCheck(String campo_id) {
		DriveFactory.getDriver().findElement(By.id(campo_id)).click();
		
	}
	
	public boolean checkEstaSelecionado(String campo_id) {
		return DriveFactory.getDriver().findElement(By.id(campo_id)).isSelected();
	}
	
	/** Select Combo **/
	public void select(String campo_id, String valor) {
		WebElement element = DriveFactory.getDriver().findElement(By.id(campo_id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public String retornaSelect(String campo_id) {
			WebElement element = DriveFactory.getDriver().findElement(By.id(campo_id));
			Select combo = new Select(element);
			return combo.getFirstSelectedOption().getText();
	}
	
	public int retornaTamanhoCombo(String campo_id) {
		WebElement element = DriveFactory.getDriver().findElement(By.id(campo_id));
		Select combo = new Select(element);
		java.util.List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	/** Button **/
	public void clicarBotao(By by) {
		DriveFactory.getDriver().findElement(by).click();
	}
	
	public void clicarBotao(String id_campo) {
		clicarBotao(By.id(id_campo));
	}
	
	public String retornaTxtBotao(String campo_id) {
		return DriveFactory.getDriver().findElement(By.id(campo_id)).getAttribute("value");
	}
	
	/** Return text page **/
	public String retornaTxtPag(By by) {
		return DriveFactory.getDriver().findElement(by).getText();
	}
	
	public String retornaTxtPag(String campo_id) {
		return DriveFactory.getDriver().findElement(By.id(campo_id)).getText();
	}
	
	/** Click Link **/
	
	public void clicarLink(String link) {
		DriveFactory.getDriver().findElement(By.linkText(link)).click();
	}
	
	/** Alert **/
	public String obterTextoAlerta() {
		Alert alert = DriveFactory.getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String obterTextoAceitarAlerta() {
		Alert alert = DriveFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String obterTextoNegarAlerta() {
		Alert alert = DriveFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}
	
	public void escreverAlerta(String valor) {
		Alert alert = DriveFactory.getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/** Frames **/
	public void entrarFrame(String id_frame) {
		DriveFactory.getDriver().switchTo().frame(id_frame);
	}
	
	public void sairFrame() {
		DriveFactory.getDriver().switchTo().defaultContent();
	}
	
	/** Window **/
	public void entrarJanelaComID(String id_janela) {
		DriveFactory.getDriver().switchTo().window(id_janela);
	}
	
	public void fecharJanela() {
		DriveFactory.getDriver().close();
	}
	
	public void voltarPrincipal() {
		DriveFactory.getDriver().switchTo().window("");
	}
	
	}


