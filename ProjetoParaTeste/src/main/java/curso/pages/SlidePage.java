package curso.pages;

import curso.core.BasePage;
import org.openqa.selenium.By;

import static curso.core.DriverFactory.getDriver;

public class SlidePage extends BasePage {

    public void setSlidePorcentagem(int porcentagem) {

        dsl.barraDeProgresso(By.xpath("//*[@id='slider']/a"), porcentagem);
    }

    public String porcentagemDaBarra() {
        String barra = getDriver().findElement(By.xpath("//*[@id='slider']/a")).getAttribute("style");
        System.out.println("A porcentagem é : " + barra);
        return barra;
    }
}
