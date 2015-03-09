package cenarios.accenture.fiancalocaticia;

import helper.TestHelper;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SC001FiancaLocaticiaSubscricaoPJ extends TestHelper {
	
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.fiancalocaticiapf";
		setUser("jose.kassimo.junior");
	}

	@Test
	public void testSC001FiancaLocaticiaPJ() throws Exception {
		this.driver.get(this.baseUrl + "novo-portal-web/segurosgerais/massificados/fiancalocaticia/subscricaocotacao.xhtml?token=ee4e2da0-492b-4389-aa96-36d4da01937e&codCotacao=31407371503887782&CodCotacaoCopia=31407371503887786&CodProduto=142&CodCorretor=71503&Acao=Incluir&Origem=Analise_Consulta&LoginAnalista=AdminFL");
		capturarTela();
		// Subscricao Cotacao
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
