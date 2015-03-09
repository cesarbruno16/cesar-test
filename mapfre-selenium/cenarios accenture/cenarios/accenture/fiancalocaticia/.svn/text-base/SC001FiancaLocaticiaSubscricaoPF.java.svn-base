package cenarios.accenture.fiancalocaticia;

import helper.TestHelper;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SC001FiancaLocaticiaSubscricaoPF extends TestHelper {
	
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.fiancalocaticiapf";
	}

	@Test
	public void testSC001FiancaLocaticiaPF() throws Exception {
		this.driver.get(this.baseUrl + "/segurosgerais/massificados/fiancalocaticia/subscricaocotacao.xhtml?token=aeec9f27-58ae-4183-b03f-d90cc9afc68c&codCotacao=30404689787487495&CodCotacaoCopia=30404689787487495&CodProduto=142&CodCorretor=89787&Acao=Incluir&Origem=Analise_Consulta&LoginAnalista=lraveli");
		// Subscricao Cotacao
		capturarTela();
		preencherCampoTextoSemMascara("formAnaliseSubscricao:idAnaliseAtual", "analiseatual");
		selecionarDropDown("formAnaliseSubscricao:ddlStatusAnalise", 1);
		rolarParaBaixo("formAnaliseSubscricao:btFinalizar");
		capturarTela();
		this.driver.findElement(By.id("formAnaliseSubscricao:btFinalizar")).click();
		rolarParaBaixo("formAnaliseSubscricao:formRodape:panelMessage");
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
