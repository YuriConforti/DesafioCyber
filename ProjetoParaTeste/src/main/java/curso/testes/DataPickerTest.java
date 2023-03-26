package curso.testes;

import curso.core.BasePage;
import curso.core.DriverFactory;
import curso.pages.DataPickerPage;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;

public class DataPickerTest extends BasePage {

    @Rule
    public TestName test = new TestName();
    DataPickerPage page = new DataPickerPage();
    Boolean validationDataPicker = false;


    @Before
    public void inicializa() {
        DriverFactory.getDriver().get("https://demo.automationtesting.in/Datepicker.html");
    }

    @After
    public void finaliza() {
        DriverFactory.closeDriver();
    }

    @Test
    public void escolherDataDeNascimentoDisabled() {

        //DatePicker Disabled
        page.setDataDisabled(2000, 7, 13, "13");
        validationDataPicker = page.assertData(By.id("datepicker1")).contains("07/13/2000");
        dsl.tirarScreenshot(validationDataPicker, test.getMethodName());
        Assert.assertTrue(validationDataPicker);
    }

    @Test
    public void escolherDataDeNascimentoEnabled() {
        //DatePicker Enabled
        page.setDataEnabled("07/13/2000");
        validationDataPicker = page.assertData(By.id("datepicker2")).contains("07/13/2000");
        Assert.assertTrue(validationDataPicker);
    }
}

