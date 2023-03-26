package curso.pages;

import curso.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static curso.core.DriverFactory.getDriver;

public class FramesPage extends BasePage {

    public void setEscritaNoFrame1(String texto) {
        dsl.entrarFrame("singleframe");
        dsl.escrever(By.xpath("//*[@type='text']"), texto);
    }

    public void sairFrame() {
        getDriver().switchTo().defaultContent();
    }

    public String assertEscritaNoFrame() {
        String txt = getDriver().findElement(By.xpath("//*[@type='text']")).getAttribute("value");
        System.out.println("O texto inserido é : " + txt);
        return txt;
    }


    public void clicaIframeWithinAnIframe() throws InterruptedException {
        dsl.clicarBotaoBy(By.xpath("//*[@href='#Multiple']"));
        Thread.sleep(2000);
    }

    public void setEscritaNoFrame2(String texto) {
        WebElement iframe2 = getDriver().findElement(By.xpath("//*[@src='MultipleFrames.html']"));
        getDriver().switchTo().frame(iframe2);
        WebElement iframe = getDriver().findElement(By.xpath("//*[@src='SingleFrame.html']"));
        getDriver().switchTo().frame(iframe);
        dsl.escrever(By.xpath("//*[@type='text']"), texto);
    }
}
