package cenarios.accenture.fiancalocaticia;

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
public class SC001FiancaLocaticiaPF extends TestHelper {

	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		carregarConfiguracoes();
		this.nomeCenario = "cenario01.accenture.fianca.locaticia";
	}

	@Test
	public void testSC001FiancaLocaticaPF() throws Exception {
		this.driver.get(this.baseUrl + "novo-portal-web/segurosgerais/massificados/fiancalocaticia/cotacao/input.xhtml");
		capturarTela();

//		escreverChaveProperties("cenario01.accenture.fiancalocaticiapropostapf.cotacao", "cotacaoquevaivir");
		
		//Remover
		//		selecionarDropDown("formInput:passo", 4);

		//		this.driver.findElement(By.id("formInput:codigoCotacao")).clear();
		//		this.driver.findElement(By.id("formInput:codigoCotacao")).sendKeys("30404629680486981");

		preencherCampoTextoSemMascara("formInput:corretor", "corretor");

		capturarTela();
		//		selecionarDropDown("formInput:tipoAcao", 2);
		this.driver.findElement(By.id("formInput:chamar")).click();

		//Tela de Seguro/Locatário
		esperarElementoCarregado("formSeguroLocatario:ddlFinalidade");
		selecionarDropDown("formSeguroLocatario:ddlFinalidade", 1);
		Thread.sleep(2000);
		preencherCampoTextoComMascara("formSeguroLocatario:cpf", "seguro.locatario.cpf");
		preencherCampoTextoSemMascara("formSeguroLocatario:nome", "seguro.locatario.nome");
		capturarTela();
		this.driver.findElement(By.id("formSeguroLocatario:btoProximo")).click();

		//Tela de locatario/imovel
		String cotacao = this.driver.findElement(By.id("formResumo:numeroCotacaoResumo")).getText();
		escreverChaveProperties("cenario01.accenture.fiancalocaticiapropostapf.cotacao",cotacao);
		esperarElementoCarregado("frmLocatario:txtDtNascimento");
		preencherCampoTextoSemMascara("frmLocatario:txtDtNascimento", "locatario.imovel.data.nascimento");
		selecionarDropDown("frmLocatario:ddlNacionalidade", 1);
		preencherCampoTextoSemMascara("frmLocatario:nomeBancoInput", "locatario.imovel.banco");
		selecionarDropDown("frmLocatario:ddlOcupacaoLocatario", 8);
		this.driver.findElement(By.id("frmLocatario:dtAtividade")).sendKeys(getParam("locatario.imovel.data.admissao"));
		this.driver.findElement(By.id("frmLocatario:txtRenda")).sendKeys(getParam("locatario.imovel.renda.comprovada"));
		selecionarDropDown("frmLocatario:ddlCpRenda", 1);
		preencherCampoTextoSemMascara("frmLocatario:cep", "locatario.imovel.cep");
		preencherCampoTextoSemMascara("frmLocatario:txtNumeroImovel", "locatario.imovel.numero");
		capturarTela();
		this.driver.findElement(By.id("frmLocatario:btoProximo")).click();

		//Tela de coberturas
		esperarElementoCarregado("formTelaCoberturas:tableCoberturas:0:inputCobertura");
		preencherCampoTextoSemMascara("formTelaCoberturas:tableCoberturas:0:inputCobertura", "coberturas.alguel");
		capturarTela();
		this.driver.findElement(By.id("formTelaCoberturas:btoProximo")).click();

		//Tela de cálculo
		capturarTela();
		esperarElementoCarregado("frmCalculoCotacao:nomeBancoInput");
		preencherCampoTextoSemMascara("frmCalculoCotacao:nomeBancoInput", "calculo.nome.banco");
		preencherCampoTextoSemMascara("frmCalculoCotacao:codigoComissao", "calculo.operacao");
		this.driver.findElement(By.id("frmCalculoCotacao:btnCalcular")).click();
		capturarTela();
		this.driver.findElement(By.id("frmCalculoCotacao:btoEfetivar")).click();

		//Tela de ficha cadastral
		esperarElementoCarregado("formFichaCadastral:ddlSexo");
		selecionarDropDown("formFichaCadastral:ddlSexo", 1);
		selecionarDropDown("formFichaCadastral:ddlEstadoCivil", 1);
		preencherCampoTextoSemMascara("formFichaCadastral:txtDDDR", "ficha.cadastral.ddd.residencial");
		this.driver.findElement(By.id("formFichaCadastral:txtFoneR")).click();
		this.driver.findElement(By.id("formFichaCadastral:txtFoneR")).clear();
		this.driver.findElement(By.id("formFichaCadastral:txtFoneR")).sendKeys(getParam("ficha.cadastral.telefone.residencial"));
		preencherCampoTextoSemMascara("formFichaCadastral:txtDDDCelular", "ficha.cadastral.ddd.celular");
		preencherCampoTextoSemMascara("formFichaCadastral:txtFoneCelular", "ficha.cadastral.telefone.celular");
		this.driver.findElement(By.id("formFichaCadastral:main")).click();
		selecionarDropDown("formFichaCadastral:ddlProfissao", 1);
		selecionarDropDown("formFichaCadastral:ddlResidencia", 1);
		preencherCampoTextoSemMascara("formFichaCadastral:desEmpresa1", "ficha.cadastral.empresa");
		preencherCampoTextoSemMascara("formFichaCadastral:dddEmprego1", "ficha.cadastral.empresa.ddd");
		preencherCampoTextoSemMascara("formFichaCadastral:numTelEmprego1", "ficha.cadastral.empresa.telefone");
		preencherCampoTextoSemMascara("formFichaCadastral:desCargo", "ficha.cadastral.cargo");
		clickById("formFichaCadastral:botaoIncluir");
		Thread.sleep(2000);
		preencherCampoTextoComMascara("formFichaCadastral:ddlNomeCompleto", "ficha.cadastral.referencia.nome");
		preencherCampoTextoSemMascara("formFichaCadastral:ddlDddTelefoneComercial", "ficha.cadastral.referencia.telefone.com.ddd");
		preencherCampoTextoSemMascara("formFichaCadastral:ddlTelefoneComercial", "ficha.cadastral.referencia.telefone.com");
		preencherCampoTextoSemMascara("formFichaCadastral:ddlDddTelefoneResidencial", "ficha.cadastral.referencia.telefone.res.ddd");
		preencherCampoTextoSemMascara("formFichaCadastral:ddlTelefoneResidencial", "ficha.cadastral.referencia.telefone.res");
		preencherCampoTextoSemMascara("formFichaCadastral:ddlDddTelefoneCelular", "ficha.cadastral.referencia.telefone.cel.ddd");
		preencherCampoTextoSemMascara("formFichaCadastral:ddlTelefoneCelular", "ficha.cadastral.referencia.telefone.cel");

		selecionarDropDown("formFichaCadastral:ddlParentesco", 1);
		capturarTela();
		clickById("formFichaCadastral:botaoSalvar");

		rolarParaBaixo("formFichaCadastral:btoSubscricao");

		this.driver.findElement(By.id("formFichaCadastral:btoSubscricao")).click();
		Thread.sleep(8000);
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
