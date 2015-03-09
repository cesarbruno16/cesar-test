package exemplo;

import static org.junit.Assert.fail;
import helper.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Tela de Segurado - Visualizar o campo CPF/CNPJ Verificar se a máscara do
 * campo CPF/CNPJ se encontra como ___.___.___-__
 * 
 * @author leonardo.panta.leao
 * 
 */
public class Exemplo extends TestHelper {

	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.automais";
	}

	@Test
	public void testSC001Automais() throws Exception {
		this.driver.get(this.baseUrl + "/novo-endosso-web/inputEndosso.xhtml");
		capturarTela();
		this.driver.findElement(By.id("formInput:codigoCotacao")).clear();
		this.driver.findElement(By.id("formInput:codigoCotacao")).sendKeys(getParam("cotacao"));
		this.driver.findElement(By.id("formInput:corretor")).clear();
		this.driver.findElement(By.id("formInput:corretor")).sendKeys(getParam("corretor"));
		capturarTela();
		this.driver.findElement(By.id("formInput:chamar")).click();
		Thread.sleep(3200);
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
}
