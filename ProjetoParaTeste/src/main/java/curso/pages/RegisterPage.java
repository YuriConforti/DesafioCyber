package curso.pages;

import curso.core.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static curso.core.DriverFactory.getDriver;

public class RegisterPage extends BasePage {
    //Escolher Nome
    public void setNome(String nome) {
        dsl.escrever(By.xpath("//*[@placeholder = 'First Name']"), nome);
    }

    //Escolher Sobrenome
    public void setSobrenome(String sobrenome) {
        dsl.escrever(By.xpath("//*[@placeholder = 'Last Name']"), sobrenome);
    }

    //    Escolher Endereco
    public void setEndereco(String endereco) {
        dsl.escrever(By.xpath("//*[@ng-model = 'Adress']"), endereco);
    }

    //    Email Aleatorio
    public void emailAleatorio() {
        WebElement email = getDriver().findElement(By.xpath("//*[@type = 'email']"));
        email.click();
        Random numeroAleatorioParaEmail = new Random();
        int randomInt = numeroAleatorioParaEmail.nextInt(1000);
        email.sendKeys("username" + randomInt + "@gmail.com");
    }

    //    Telefone Aleatorio
    public void numerodeTelefoneAleatorio() {
        WebElement telefone = getDriver().findElement(By.xpath("//*[@type = 'tel']"));
        String celularaleatorio = RandomStringUtils.randomNumeric(9);
        String numeroCelular = 9 + celularaleatorio;
        telefone.sendKeys(numeroCelular);
    }

    //Escolher sexo
    public void setSexoMasculino() {
        dsl.clicarBotaoBy(By.xpath("//*[@value='Male']"));
    }

    public void setSexoFeminino() {
        dsl.clicarBotaoBy(By.xpath("//*[@value='FeMale']"));
    }


    //    Escolher Hobbies
    public void setHobbieCricket() {
        dsl.clicarBotaoBy(By.xpath("//*[@value='Cricket']"));
    }

    public void setHobbieMovies() {
        dsl.clicarBotaoBy(By.xpath("//*[@value='Movies']"));
    }

    public void setHobbieHockey() {
        dsl.clicarBotaoBy(By.xpath("//*[@value='Hockey']"));
    }

    //    Escolher Idioma
    public void setIdioma(String idioma) throws InterruptedException {
        dsl.clicarBotaoBy(By.id("msdd"));
        Thread.sleep(1500);
        dsl.clicarBotaoBy(By.linkText(idioma));
    }

    //    Escolher Skills
    public void setSkill(String opcao) {
        dsl.selecionarcomCombo(By.xpath("//*[@id='Skills']"), opcao);
    }

    //    Escolher Pais
    public void setPais(String pais) {
        dsl.clicarBotaoBy(By.xpath("//*[@class='select2-selection__arrow']"));
        dsl.escrever(By.xpath("//*[@class='select2-search__field']"), pais + Keys.ENTER);
    }

    //    Escolher Data de Nascimento
    public void setDataDeNascimento(String year, String month, String day) {
        dsl.selecionarcomCombo(By.id("yearbox"), year);
        dsl.selecionarcomCombo(By.xpath("//*[@placeholder='Month']"), month);
        dsl.selecionarcomCombo(By.xpath("//*[@id='daybox']"), day);
    }

    //    Escolher senha e confirmar
    public void setSenha(String senha, String confirmeAsenha) {
        dsl.escrever(By.xpath("//*[@id='firstpassword']"), senha);
        dsl.escrever(By.xpath("//*[@id='secondpassword']"), confirmeAsenha);
    }

    //    Dar Submit nas informacoes
    public void setSubmit() {
        dsl.clicarBotaoBy(By.xpath("//*[@id='submitbtn']"));
    }

}

/****Validacao de sucesso do Cadastro(Nao foi possivel testar)

 public void assertRegistro (By by, String mensagemEsperada) {
 String textoDeValidacao = getDriver().findElement(by).getAttribute("value");
 System.out.println(textoDeValidacao);
 Assert.assertEquals(textoDeValidacao, mensagemEsperada);
 ***/
