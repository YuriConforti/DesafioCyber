package curso.core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static curso.core.DriverFactory.getDriver;

public class Dsl {
    /**************** Evidencias ***************/
    public void tirarScreenshot(Boolean validation, String testName) {
        //Definir variaveis de horarios e datas
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatterFolder = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        DateTimeFormatter formatterScreenShot = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm");
        String folderDate = date.format(formatterFolder);
        String screenshotDate = date.format(formatterScreenShot);
        //Checar e criar as pastas necessarias
        //Criacao da pasta de evidencias
        File evidencePath = new File("C:\\Users\\confo\\IdeaProjects\\ProjetoParaTeste\\target\\Evidencias");
        if (!evidencePath.exists()) {
            evidencePath.mkdir();
        }
        //Criacao da pasta de com o dia e hora do teste
        File dateFolder = new File(evidencePath + File.separator + folderDate);
        if (!dateFolder.exists()) {
            dateFolder.mkdir();
        }
        //Criacao da pasta de sucesso
        File successFolder = new File(dateFolder + File.separator + "TestSuccess");
        if (!successFolder.exists()) {
            successFolder.mkdir();
        }
        //Criacao da pasta de Falha
        File failFolder = new File(dateFolder + File.separator + "TestFail");
        if (!failFolder.exists()) {
            failFolder.mkdir();
        }
        //Metodo de evidencia
        // Caso o teste falhe a evidencia e encaminhada a pasta de falha, caso seja sucesso a evidencia e enviada a pasta de sucesso
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {

            if (validation) {
                FileUtils.copyFile(screenshot, new File(successFolder + File.separator + screenshotDate + testName + ".png"));
            } else {
                FileUtils.copyFile(screenshot, new File(failFolder + File.separator + screenshotDate + testName + ".png"));
            }
        } catch (Exception e) {
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta: " + e.getMessage());
        }

    }

    /**************** Entrar no site ***************/
    public void url(String texto) {
        getDriver().get(texto);
    }

    /**************** Selecionar data ***************/
    public int quantidadeDeCliquesNecessaria(Period period) {

        int cliques = period.getYears() * 12 + period.getMonths();
        return cliques;
    }

    public Period calculaPeriodo(int ano, int mes, int dia) {

        LocalDate hoje = LocalDate.now(); //Dia de hoje
        LocalDate nascimento = LocalDate.of(ano, mes, dia);  //Dia de nascimento
        Period period = Period.between(nascimento, hoje);
        return period;
    }

    public void clicarData(String dia) {
        getDriver().findElement(By.linkText(dia)).click();
    }

    /**************** Mover Slide Bar ***************/
    public void barraDeProgresso(By by, int porcentagem) {
        WebElement slider = getDriver().findElement(by);

        for (int i = 1; i <= porcentagem; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    /**************** TextField e Text Area ***************/
    public void escrever(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    /**************** Combo ***************/
    public void selecionarcomCombo(By by, String opcaoDesejada) {

        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        combo.selectByVisibleText(opcaoDesejada);
    }

    /**************** Botao ***************/
    public void clicarBotaoBy(By by) {
        getDriver().findElement(by).click();
    }

    /**************** Frames e Janelas ***************/
    public void entrarFrame(String id) {
        getDriver().switchTo().frame(id);
    }

}
