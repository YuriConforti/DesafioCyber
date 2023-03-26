package curso.testes;

import curso.core.DriverFactory;
import curso.pages.FramesPage;
import org.junit.*;
import org.junit.rules.TestName;

public class IframeTest extends FramesPage {
    @Rule
    public TestName test = new TestName();
    Boolean validationFrame = false;

    FramesPage page = new FramesPage();


    @Before
    public void inicializa() {
        DriverFactory.getDriver().get("https://demo.automationtesting.in/Frames.html");
    }

    @After
    public void finaliza() {
        dsl.tirarScreenshot(validationFrame, test.getMethodName());
        DriverFactory.closeDriver();
    }

    @Test
    public void escreverNoPrimeiroFrame() {
        page.setEscritaNoFrame1("Ola, Mundo!");
        validationFrame = page.assertEscritaNoFrame().contains("Ola, Mundo!");
        Assert.assertTrue(validationFrame);
    }

    @Test
    public void escreverNoSegundoFrame() throws InterruptedException {
        page.clicaIframeWithinAnIframe();
        page.setEscritaNoFrame2("Ola, Mundo!");
        validationFrame = page.assertEscritaNoFrame().contains("Ola, Mundo!");
        Assert.assertTrue(validationFrame);
    }
}

