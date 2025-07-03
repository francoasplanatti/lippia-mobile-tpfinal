package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.ProductSearchService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs extends PageSteps{


    @Given("que el usuario hace click en el boton 'Iniciar sesion'")
    public void clickIniciarSesion() {
        ProductSearchService.clickEleccionInicioSesion();
    }
    @And("que el usuario ingresa a su cuenta con su (.*) y su (.*)")
    public void ingresoUsuario(String user, String pass) {
        ProductSearchService.inicioSesion(user, pass);
    }
    @When("el usuario introduce un (.*) en el buscador")
    public void busquedaRubro(String tipo) {
        ProductSearchService.busquedaProd(tipo);
    }


    @Then("el sistema muestra una lista de productos del rubro seleccionado")
    public void verifyRubro() {
        ProductSearchService.verificaRubro();
    }


}
