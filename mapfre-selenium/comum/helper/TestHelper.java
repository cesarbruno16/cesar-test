package helper;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import exception.TestException;

/**
 * 
 * Classe obrigat�ria para os planos de testes
 * 
 * @author caio.rodrigo.santos
 * 
 */
public class TestHelper {
	
	List<String> lista = new ArrayList<String>();
	public WebDriver driver;
	public String baseUrl;
	public String nomeCenario;
	private int counter = 1;
	private String user = "";
	//private String saveImagesFolder = "C:\\Users\\" + user + "\\Documents\\Mapfre - Projeto Arquitetura\\";
	private String saveImagesFolder = "C:\\Users\\" + user + "\\Documents\\Mapfre - Projeto Arquitetura\\";

	/**
	 * Retorna o valor de acordo com a key
	 * 
	 * @param key
	 * @return String
	 * @throws TestException
	 */
	public String getParam(final String key) throws TestException {

		ResourceBundle rb = ResourceBundle.getBundle("cenarios");
		return (String) rb.getObject(this.nomeCenario + "." + key);

	}

	/**
	 * M�todo utilizado apenas para trazer as configura��es do projeto
	 * 
	 * @param key
	 * @return String
	 * @throws TestException
	 */
	public String getConfig(final String key) throws TestException {

		ResourceBundle rb = ResourceBundle.getBundle("dominio");
		return (String) rb.getObject("config." + key);

	}

	/**
	 * Incluir este m�todo para tirar print 
	 * 
	 * @throws TestException
	 * @throws InterruptedException
	 */
	public void capturarTela() throws TestException, InterruptedException {

		String nome = StringUtils.deleteWhitespace(this.nomeCenario.replace('.', ' '));
		
		try {

			// Tira print
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			// Seta o diretorio para o servidor
			File dirMapfre = new File(saveImagesFolder + "/");
			dirMapfre.mkdir();
			File dir = new File(saveImagesFolder + nome + "/");
			dir.mkdir();
			
			// Caso seja a primeira vez, limpar os arquivos
			if (this.counter == 0) {
				FileUtils.cleanDirectory(dir);
			}
			
			// Joga o print na pasta
			ImageIO.write(image, "jpg", new File(saveImagesFolder + nome + "/" + nome + this.counter++ + ".jpg"));

		} catch (Exception e) {

			throw new TestException("Um problema ocorreu com o screenshot");

		}

	}

	/**
	 * Incluir este m�todo para tirar print, passar o tempo de espera antes do
	 * print no parametro
	 * 
	 * @throws TestException
	 * @throws InterruptedException
	 */
	public void capturarTela(final long tempo) throws TestException, InterruptedException {

		Thread.sleep(tempo);

		String nome = StringUtils.deleteWhitespace(this.nomeCenario.replace('.', ' '));
		try {

			// Tira print
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit()
					.getScreenSize()));
			// Seta o diretorio para o servidor
			File dir = new File(saveImagesFolder
					+ nome + "/");
			dir.mkdir();
			// Caso seja a primeira vez, limpar os arquivos
			if (this.counter == 0) {
				FileUtils.cleanDirectory(dir);
			}
			// Joga o print na pasta
			ImageIO.write(image, "jpg", new File(
					saveImagesFolder + nome + "/"
							+ nome + this.counter++ + ".jpg"));

		} catch (Exception e) {

			throw new TestException("Um problema ocorreu com o screenshot");

		}

	}

	/**
	 * Utilizar este m�todo no Setup para carregar as configura��es b�sicas.
	 * 
	 * @throws TestException
	 */
	public void carregarConfiguracoes() throws TestException {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		File file = new File("driver\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		this.driver = new InternetExplorerDriver(capabilities);
		this.baseUrl = getConfig("base.url");
		setUser(getConfig("user"));
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * M�todo respons�vel por selecionar o componente passado. <br>
	 * </br> <b>Exemplo de um componente: formSegurado:sexo:0
	 * 
	 * @param componente
	 */
	public void selecionarRadioButton(final String componente) {

		clickById(componente);

	}

	/**
	 * M�todo respons�vel por clicar em componente passado por ID. <br>
	 * </br> <b>Exemplo de um componente: formSegurado:sexo:0
	 * 
	 * @param componente
	 */
	public void clickById(final String componente) {

		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("document.getElementById('" + componente + "').click();");

	}

	/**
	 * M�todo respons�vel por selecionar o componente passado. <br>
	 * by name </br> <b>Exemplo de um nome componente: formSegurado:sexo:0
	 * 
	 * @param name
	 */
	public void selecionarCheckBox(final String name) {
		clickByName(name);

	}

	/**
	 * M�todo respons�vel por clicar e componente passado por name. <br>
	 * by name </br> <b>Exemplo de um nome componente: formSegurado:sexo:0
	 * 
	 * @param name
	 */
	public void clickByName(final String name) {

		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("document.getElementsByName('" + name + "')[0].click();");
	}

	/**
	 * M�todo utilizado especificamente para a tela de Perfil. <br>
	 * </br> � necess�rio buscar o id do componente, para isso, v� at� a tela de
	 * perfil, <br>
	 * </br> aperte F12, selecione o DropDown e na div "name", voc� encontrar�
	 * algo assim: formAvaliacaoRisco:id_395_CND_37_30404710049635886_1_0. <br>
	 * </br> O id que deve ser passado � o "id_395". <br>
	 * </br> Exemplo de um id v�lido: <b>id_395</b> <br>
	 * </br> Exemplo de um index v�lido: 2
	 * 
	 * @param id
	 * @param index
	 */
	public void selecionarDropDownIdDinamico(final String id, final int index) {

		List<WebElement> targetElement = this.driver.findElements(By.xpath("//select[contains(@id, '" + id + "')]"));
		selecionarDropDown(targetElement.get(0).getAttribute("id"), index);

	}

	/**
	 * M�todo utilizado especificamente para a tela de Perfil. � necess�rio
	 * buscar o id do componente, para isso, v� at� a tela de perfil, <br>
	 * </br> aperte F12, selecione o Radio e no campo "id", voc� encontrar� algo
	 * assim: formAvaliacaoRisco:id_98_CND_37_30404710049635886_1_0:0. <br>
	 * </br> O id que deve ser passado � o "id_98" <br>
	 * </br> O radioOpcao que deve ser passado � o numero ap�s o ":", neste caso
	 * o 0.
	 * 
	 * @param idRadio
	 * @param radioOpcao
	 */
	public void selecionarRadioIdDinamico(final String idRadio, final int radioOpcao) {

		List<WebElement> targetElement = this.driver.findElements(By.xpath("//input[contains(@id, '" + idRadio
				+ "') and contains(@id, ':" + radioOpcao + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("document.getElementById('" + targetElement.get(0).getAttribute("id") + "').click();");

	}

	/**
	 * M�todo respons�vel por selecionar o componente com o index passado. <br>
	 * </br> <b>Exemplo de um componente: formSegurado:codProfissao <br>
	 * </br> O index, deve ser o value do campo no dropdown.
	 * 
	 * @param componente
	 * @param index
	 */
	public void selecionarDropDown(final String componente, final int index) {

		Select dropdown = new Select(this.driver.findElement(By.id(componente)));
		dropdown.selectByIndex(index);

	}

	/**
	 * Utilizar este m�todo quando precisar limpar um inputText.
	 * 
	 * @return String
	 */
	public String limparCampo() {

		return Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

	}

	/**
	 * 
	 * @param idInput
	 * @param parametro
	 */
	public void escreverInputIdDinamico(final String idInput, final String parametro) {

		List<WebElement> targetElement = this.driver
				.findElements(By.xpath("//input[contains(@id, '" + idInput + "')]"));

		this.driver.findElement(By.id(targetElement.get(0).getAttribute("id"))).sendKeys(limparCampo() + parametro);

	}

	/**
	 * Utilizar este m�todo quando precisar rolar a p�gina para cima PAGE UP. <br>
	 * 
	 * @return String
	 */
	public void rolarParaCima(final String campo) {

		this.driver.findElement(By.id(campo)).sendKeys(Keys.PAGE_UP);

	}

	/**
	 * Utilizar este m�todo quando precisar rolar a p�gina para baixo PAGE DOWN. <br>
	 * 
	 * @return String
	 */
	public void rolarParaBaixo(final String campo) {

		this.driver.findElement(By.id(campo)).sendKeys(Keys.PAGE_DOWN);

	}

	/**
	 * Utilizar este m�todo quando precisar pressionar ENTER. <br>
	 * 
	 * @return String
	 */
	public void pressionarEnter(final String campo) {

		this.driver.findElement(By.id(campo)).sendKeys(Keys.ENTER);

	}

	/**
	 * Utilizar este m�todo quando precisar digitar algo no teclado. <br>
	 * 
	 * @return String
	 */
	public void pressionarTecla(final String campo, final Keys key) {

		this.driver.findElement(By.id(campo)).sendKeys(key);

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
		this.saveImagesFolder = "C:\\Users\\" + user + "\\Documents\\Mapfre - Projeto Arquitetura\\";
	}

	/**
	 * M�todo para editar uma propriedade de um campo via javascript
	 * @input id_campo, falg_desabilitar, valor
	 * @return void
	 */
	public void editarPropriedadeCampoJavaScript(final String idCampo, final String propriedade, final String propriedadeValor){
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("document.getElementById('" + idCampo + "')." + propriedade + "=" + propriedadeValor);
	}

	/**
	 * M�todo para esperar um elemento da p�gina ser carregado
	 * @input id
	 * @return void
	 */

	public void esperarElementoCarregado(final String id){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(200, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(id));
			}
		});
	}
	
	/**
	 * M�todo que preenche um campo de texto sem m�scara
	 * @input id, valor
	 * @return void
	 * @throws TestException 
	 */
	
	public void preencherCampoTextoSemMascara(String id, String valor) throws TestException{
		this.driver.findElement(By.id(id)).click();
		this.driver.findElement(By.id(id)).clear();
		this.driver.findElement(By.id(id)).sendKeys(getParam(valor));
	}
	
	/**
	 * M�todo que preenche um campo de texto com m�scara
	 * @input id, valor
	 * @return void
	 * @throws TestException 
	 */
	
	public void preencherCampoTextoComMascara(String id, String valor) throws TestException{
		this.driver.findElement(By.id(id)).clear();
		this.driver.findElement(By.id(id)).sendKeys(getParam(valor));
	}
	
	/**
	 * M�todo que altera uma chave no arquivo de cenarios.properties
	 * @input chave, valor
	 * @return void
	 * @throws TestException 
	 */
	public void escreverChaveProperties(String chave, String valor) throws TestException{
		try{
			File file = new File(".\\comum\\cenarios.properties");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linhaOriginal = "";
			String arquivoFinal = "";
			while((linhaOriginal = reader.readLine()) != null)
			{
				if(linhaOriginal.contains(chave)){
					arquivoFinal += chave + " = " + valor + "\n";
				}
				else if (linhaOriginal.equals("")){
					arquivoFinal += "\n";
				}
				else
				{
					arquivoFinal += linhaOriginal + "\n";
				}
			}
			reader.close();
			FileWriter writer = new FileWriter(".\\comum\\cenarios.properties");
			writer.write(arquivoFinal);
			writer.close();
		}
		catch(IOException e){
			throw new TestException("Erro com opera��o no arquivo de cenarios.properties");
		}
	}
}
