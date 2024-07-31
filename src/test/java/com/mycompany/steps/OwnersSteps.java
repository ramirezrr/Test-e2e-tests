package com.mycompany.steps;

import com.mycompany.pages.owners.OwnerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OwnersSteps {

    @Steps
    OwnerPage ownerPage;

    @Given("el cliente navega a la página de propietarios")
    public void elClienteNavegaALaPaginaDePropietarios() {
        ownerPage.open();
    }

    @When("el cliente realiza una acción para listar propietarios")
    public void elClienteRealizaUnaAccionParaListarPropietarios() {
        ownerPage.clickOnOwnerMenuLink();
    }

    @Then("la página debe mostrar una lista de propietarios válida")
    public void laPaginaDebeMostrarUnaListaDePropietariosValida() {
        ownerPage.clickOnOwnerListButton();
        String headerText = ownerPage.getOwnersHeaderText();
        assertEquals(headerText, "Owners");
    }

    //Veterinarians  ListarVeterinarians
    @Given("el cliente navega a la pagina de Veterinarians")
    public void elClienteNavegaALaPaginaDeVeterinarians() {
        ownerPage.open();
    }

    @When("el cliente realiza una acción para listar Veterinarians")
    public void elClienteRealizaUnaAccionParaListarVeterinarians() {
        ownerPage.clickOnVeterinariansMenuLink();
    }

    @Then("la página debe mostrar una lista de Veterinarians válidos")
    public void laPaginaDebeMostrarUnaListaDeVeterinariansValidos() {
        String headerText = ownerPage.getVeterinariansHeaderText();
        assertEquals(headerText, "Veterinarians");
    }

    // Veterinarians VerJsonDeListaVeterinarians
    @Then("la página debe mostrar un enlace para abrir el JSON")
    public void laPaginaDebeMostrarUnEnlaceParaAbrirElJSON() {
        assertTrue(ownerPage.isViewAsJsonLinkPresent());        
    }

    @When("el cliente hace clic en el enlace JSON")
    public void elClienteHaceClicEnElEnlaceJSON() {
        ownerPage.clickOnJsonVeterinariansLink();
    }

    @Then("el cliente debe ver el JSON con la lista de Veterinarians")
    public void elClienteDebeVerElJSONLlenoConLaListaDeVeterinarians() {
        String contenido = ownerPage.verificarJsonLlenoVeterinarians();
        assertFalse("El contenido del elemento está vacío", contenido.isEmpty());
    }

}
