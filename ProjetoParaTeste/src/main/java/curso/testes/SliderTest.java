package curso.testes;

import curso.core.DriverFactory;
import curso.pages.SlidePage;
import org.junit.*;
import org.junit.rules.TestName;

public class SliderTest extends SlidePage {


    @Rule
    public TestName test = new TestName();
    SlidePage page = new SlidePage();
    Boolean validation = false;

    @Before
    public void inicializa() {
        DriverFactory.getDriver().get("https://demo.automationtesting.in/Slider.html");
    }

    @After
    public void finaliza() {

        dsl.tirarScreenshot(validation, test.getMethodName());
        DriverFactory.closeDriver();
    }

    //Mover a barra de progresso ate a metade
    @Test
    public void slidePelaMetade() {
        page.setSlidePorcentagem(50);
        validation = page.porcentagemDaBarra().contains("50%");
        Assert.assertTrue(validation);

    }

}
