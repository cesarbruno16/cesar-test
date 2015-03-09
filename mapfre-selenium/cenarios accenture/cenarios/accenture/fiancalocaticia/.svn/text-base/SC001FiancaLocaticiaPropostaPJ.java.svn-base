package cenarios.accenture.fiancalocaticia;

import helper.TestHelper;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class SC001FiancaLocaticiaPropostaPJ extends TestHelper {

	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.fiancalocaticiapropostapj";
	}

	@Test
	public void testSC001FiancaLocaticiaProposta() throws Exception {
		this.driver.get(this.baseUrl + "/segurosgerais/massificados/fiancalocaticia/proposta/input.xhtml");
		
		//Tela input 
		preencherCampoTextoSemMascara("formInput:cotacao", "input.cotacao");		
		preencherCampoTextoSemMascara("formInput:corretor", "input.corretor");
		capturarTela();
		this.driver.findElement(By.id("formInput:botao")).click();
		
		// Tela Locador
		esperarElementoCarregado("formLocador:ddlTipoPessoa");
		selecionarDropDownIdDinamico("formLocador:ddlTipoPessoa", 2);
		Thread.sleep(2000);
		preencherCampoTextoComMascara("formLocador:txtCnpj", "locador.cnpj");
		this.driver.findElement(By.id("formLocador:txtNome")).click();
	    Thread.sleep(1000);
	    preencherCampoTextoSemMascara("formLocador:txtNome", "locador.nome");
	    preencherCampoTextoComMascara("formLocador:cep", "locador.cep");
	    this.driver.findElement(By.id("formLocador:txtNumEndereco")).click();
	    Thread.sleep(2000);
	    preencherCampoTextoSemMascara("formLocador:txtNumEndereco", "locador.numendereco");
	    preencherCampoTextoSemMascara("formLocador:txtDDD", "locador.ddd");
	    preencherCampoTextoComMascara("formLocador:txtFone", "locador.fone");
	    selecionarDropDownIdDinamico("formLocador:ddlPaisResidencia", 1);
	    selecionarDropDownIdDinamico("formLocador:ddlSegmento2", 3);
	    capturarTela();
	    this.driver.findElement(By.id("formLocador:btoProximo")).click();
	    
	    // Tela Seguro/Estipulante
	    esperarElementoCarregado("formSeguroEstipulantePropostaFianca:datInicioLocacao");
	    preencherCampoTextoComMascara("formSeguroEstipulantePropostaFianca:datInicioLocacao", "estipulante.datiniciolocacao");
	    preencherCampoTextoComMascara("formSeguroEstipulantePropostaFianca:txtDatTerminoLocacao", "estipulante.datterminolocacao");
	    selecionarDropDownIdDinamico("formSeguroEstipulantePropostaFianca:ddlIndice", 1);
	    selecionarDropDownIdDinamico("formSeguroEstipulantePropostaFianca:ddlPeriodicidade", 1);
	    capturarTela();
	    this.driver.findElement(By.id("formSeguroEstipulantePropostaFianca:btoProximo")).click();		
		
	    
	    // Tela Pagamento Efetivacao
	    esperarElementoCarregado("formEfetivacaoFianca:dataNascimentoConstituicao");
	    selecionarDropDownIdDinamico("formEfetivacaoFianca:ddlTipoPessoa", 2);
	    Thread.sleep(2000);
	    preencherCampoTextoComMascara("formEfetivacaoFianca:dataNascimentoConstituicao", "efetivacao.datnascimentoconstituicao");
	    preencherCampoTextoComMascara("formEfetivacaoFianca:cpfCnpj", "efetivacao.cnpj");
	    selecionarDropDownIdDinamico("formEfetivacaoFianca:formaPagamento", 3);
	    Thread.sleep(2000);
	    preencherCampoTextoComMascara("formEfetivacaoFianca:numEndereco", "efetivacao.numendereco");
		capturarTela();
		Thread.sleep(2000);
	    selecionarDropDownIdDinamico("formEfetivacaoFianca:qtdeParcelas", 1);
	    this.driver.findElement(By.id("formEfetivacaoFianca:btnEfetivar")).click();
	    Thread.sleep(2000);
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
