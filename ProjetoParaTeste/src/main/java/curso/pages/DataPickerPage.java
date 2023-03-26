package curso.pages;

import curso.core.BasePage;
import org.openqa.selenium.By;

import static curso.core.DriverFactory.getDriver;

public class DataPickerPage extends BasePage {

    public void setDataDisabled(int year, int monthNumber, int day, String confirmDay) {
        //Clicar para deixar o calendario visivel

        dsl.clicarBotaoBy(By.xpath("//*[@id='datepicker1']"));

        int cliques = dsl.quantidadeDeCliquesNecessaria(dsl.calculaPeriodo(year, monthNumber, day));

        for (int i = 0; i < cliques; i++) {
            dsl.clicarBotaoBy(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span"));
        }
        dsl.clicarData(confirmDay);
    }


    //DatePicker Enabled
    public void setDataEnabled(String dataMesDiaAno) {
        dsl.escrever(By.xpath("//*[@id='datepicker2']"), dataMesDiaAno);
    }

    //  Confirmar a data selecionada
    public String assertData(By by) {
        String data = getDriver().findElement(by).getAttribute("value");
        System.out.println("a data selecionada é: " + data);
        return data;
    }
}

