package exemplo;

import static org.junit.Assert.fail;
import helper.TestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

public class ExemploModal extends TestHelper {
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.modais";
	}

	@Test
	public void testSC001ComumModalCep() throws Exception {
		// FIXME acessando via input endosso

		this.driver.findElement(By.id("formInput:codigoCotacao")).clear();
		this.driver.findElement(By.id("formInput:codigoCotacao")).sendKeys("30404679170504342");
		this.driver.findElement(By.id("formInput:corretor")).clear();
		this.driver.findElement(By.id("formInput:corretor")).sendKeys("45130");
		this.driver.findElement(By.id("formInput:chamar")).click();

		// --------------------------------------------------------

		// this.driver.findElement(By.id("formNovoEndosso:apolice")).clear();
		// this.driver.findElement(By.id("formNovoEndosso:apolice")).sendKeys(getParam("cotacao"));
		// this.driver.findElement(By.id("formNovoEndosso:localizar")).click();
		// capturarTela();
		// this.driver.findElement(By.cssSelector("div.rf-edt-c-cnt")).click();
		// capturarTela();
		// this.driver.findElement(By.id("formNovoEndosso:botaoAlterar")).click();
		// capturarTela();

		Thread.sleep(3000l);

		this.driver
				.findElement(
						By.xpath("//a[@onclick=\"jsf.util.chain(this,event,'initProcess();','mojarra.jsfcljs(document.getElementById(\\'formMenu\\'),{\\'formMenu:j_idt38:3:j_idt40\\':\\'formMenu:j_idt38:3:j_idt40\\',\\'paginaAtual\\':\\'3\\'},\\'\\')');return false\"]"))
				.click();
		this.driver.findElement(By.cssSelector("a.modalPerfil")).click();
		Thread.sleep(1000l);

		selecionarDropDown("cepForm:estado", 20);
		Thread.sleep(1000l);
		this.driver.findElement(By.id("cepForm:cidadeInput")).clear();
		this.driver.findElement(By.id("cepForm:cidadeInput")).sendKeys("RIO DE JANEIRO");

		Thread.sleep(1000l);
		this.driver.findElement(By.id("cepForm:btnPesquisar")).click();

		this.driver.findElement(By.id("cepForm:logradouro")).click();
		this.driver.findElement(By.id("cepForm:logradouro")).sendKeys("Rua Artur Menezes");

		this.driver.findElement(By.id("cepForm:btnPesquisar")).click();

		this.driver.findElement(By.id("cepForm:panelCeps")).click();
		Thread.sleep(1000l);
		capturarTela();

		Thread.sleep(1000l);
		this.driver.findElement(By.cssSelector("li.even.selected")).click();

		this.driver.findElement(By.id("cepForm:btConfirmar")).click();

		Thread.sleep(2000l);
		capturarTela();

	}

	@After
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(final By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}
}
