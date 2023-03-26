package curso.testes;

import curso.core.BasePage;
import curso.core.DriverFactory;
import curso.pages.RegisterPage;
import org.junit.*;
import org.junit.rules.TestName;

public class RegisterTest extends BasePage {

    @Rule
    public TestName test = new TestName();
    Boolean validation = false;
    RegisterPage page = new RegisterPage();

    @Before
    public void inicializa() {
        dsl.url("https://demo.automationtesting.in/Register.html");
    }

    @After
    public void finaliza() {
        dsl.tirarScreenshot(validation, test.getMethodName());
        DriverFactory.closeDriver();

    }

    @Test
    public void Preencherinformacoes() throws InterruptedException {

        //Dados Pessoais
        page.setNome("Yuri");
        page.setSobrenome("Conforti");
        page.setEndereco("Rua da Rua");
        page.emailAleatorio();
        page.numerodeTelefoneAleatorio();

        //Sexo
        page.setSexoMasculino();

        //Hobbies
        page.setHobbieCricket();
        page.setHobbieMovies();
        page.setHobbieHockey();

        //Idioma (Botao bugado)
        page.setIdioma("Portuguese");
        page.setIdioma("English");

        //Skills
        page.setSkill("Java");

        //Pais
        page.setPais("Japan");

        //Data de Nascimento
        page.setDataDeNascimento("2000", "July", "13");

        //Senha
        page.setSenha("senha123", "senha123");

        //Submit
        page.setSubmit();
        //Assert do Teste
        Assert.assertTrue(validation);
    }
}

