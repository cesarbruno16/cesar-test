package cenarios.accenture.fiancalocaticia;

import static org.junit.Assert.fail;
import helper.TestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class SC001FiancaLocaticiaPropostaPF extends TestHelper {
	
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.fiancalocaticiapropostapf";
	}

	@Test
	public void testSC001FiancaLocaticiaPF() throws Exception {
		this.driver.get(this.baseUrl + "/segurosgerais/massificados/fiancalocaticia/proposta/input.xhtml");
		
		// Tela input
		preencherCampoTextoSemMascara("formInput:cotacao", "cotacao");
		preencherCampoTextoSemMascara("formInput:corretor", "corretor");
		capturarTela();
		this.driver.findElement(By.id("formInput:botao")).click();
		
		// Locador
		esperarElementoCarregado("formLocador:ddlTipoPessoa");
		selecionarDropDown("formLocador:ddlTipoPessoa", 1);
		Thread.sleep(2000);
		preencherCampoTextoComMascara("formLocador:txtCpf", "cpf");
		this.driver.findElement(By.id("formLocador:txtNumEndereco")).click();
		Thread.sleep(10000);
		preencherCampoTextoSemMascara("formLocador:txtNumEndereco", "numendereco");
		selecionarDropDown("formLocador:ddlRendaMensal", 2);
		capturarTela();
		this.driver.findElement(By.id("formLocador:btoProximo")).click(); 
		
		// Seguro / Estipulante
		esperarElementoCarregado("formSeguroEstipulantePropostaFianca:datInicioLocacao");
		preencherCampoTextoComMascara("formSeguroEstipulantePropostaFianca:datInicioLocacao", "datiniciolocacao");
		preencherCampoTextoComMascara("formSeguroEstipulantePropostaFianca:txtDatTerminoLocacao", "datterminolocacao");
		selecionarDropDown("formSeguroEstipulantePropostaFianca:ddlIndice", 1);
		selecionarDropDown("formSeguroEstipulantePropostaFianca:ddlPeriodicidade", 1);
		capturarTela();
		this.driver.findElement(By.id("formSeguroEstipulantePropostaFianca:btoProximo")).click();
		
		//Efetivação
		esperarElementoCarregado("formEfetivacaoFianca:ddlTipoPessoa");
		selecionarDropDown("formEfetivacaoFianca:ddlTipoPessoa", 1);
		Thread.sleep(2000);
		preencherCampoTextoComMascara("formEfetivacaoFianca:cpfCnpj", "txtcpf");
		preencherCampoTextoSemMascara("formEfetivacaoFianca:razaoSocial", "razaosocial");
		preencherCampoTextoComMascara("formEfetivacaoFianca:cep", "cep");
	    
		this.driver.findElement(By.id("formEfetivacaoFianca:txtDDD")).click();
		Thread.sleep(3000);
		
		preencherCampoTextoSemMascara("formEfetivacaoFianca:txtDDD", "ddd");
		preencherCampoTextoComMascara("formEfetivacaoFianca:telefone", "numtelefone");
		
		preencherCampoTextoComMascara("formEfetivacaoFianca:dataNascimentoConstituicao", "datnascimentoconstituicao");
		
		selecionarDropDown("formEfetivacaoFianca:ddlEstadoCivil", 1);
		

		selecionarDropDown("formEfetivacaoFianca:ddlSexo", 1);
		Thread.sleep(3000);
		selecionarDropDown("formEfetivacaoFianca:ddlSexo", 1);
		
		selecionarDropDown("formEfetivacaoFianca:ddlTipoDocumento", 1);
		
		preencherCampoTextoSemMascara("formEfetivacaoFianca:txtNumero", "txtnumero");

		selecionarDropDown("formEfetivacaoFianca:ddlOrgaoExpedidor", 1);
		
		preencherCampoTextoComMascara("formEfetivacaoFianca:txtDatExpedicao", "datexpedicao");
		
		selecionarDropDown("formEfetivacaoFianca:ddlPaisResidencia", 1);
		selecionarDropDown("formEfetivacaoFianca:ddlProfissao", 1);
		
		selecionarDropDown("formEfetivacaoFianca:formaPagamento", 3);
	    
	   preencherCampoTextoComMascara("formEfetivacaoFianca:numEndereco", "numendereco");
	    
	    selecionarDropDown("formEfetivacaoFianca:qtdeParcelas", 1);

	   // selecionarDropDown("formEfetivacaoFianca:diaPreferencial", 1);
	    
	    capturarTela();
	    
	    driver.findElement(By.id("formEfetivacaoFianca:btnEfetivar")).click();
	    
	    Thread.sleep(5000);
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
