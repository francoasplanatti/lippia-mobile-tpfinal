package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.PaymentService;
import io.cucumber.java.en.*;

public class PaymentSteps extends PageSteps {

    @Given("Inicio la app de Mercado Libre")
    public void inicioLaApp() {
        // La inicialización del driver se maneja en Hooks
    }

    @When("Busco el producto {string}")
    public void buscoProducto(String producto) {
        PaymentService.searchProduct(producto);
    }

    @And("Selecciono el primer resultado")
    public void seleccionoPrimerResultado() {
        PaymentService.selectFirstResult();
    }

    @And("Agrego el producto al carrito")
    public void agregoAlCarrito() {
        PaymentService.addToCart();
    }

    @And("Procedo al checkout como invitado")
    public void checkoutComoInvitado() {
        PaymentService.checkoutAsGuest();
    }

    @And("Completo dirección de envío")
    public void completoDireccion() {
        PaymentService.completeShippingAddress();
    }

    @And("Selecciono pago con tarjeta de crédito")
    public void seleccionoPagoTarjeta() {
        PaymentService.selectCreditCardPayment();
    }

    @And("Ingreso datos de tarjeta inválida con estado {string}")
    public void ingresoDatosTarjetaInvalida(String estado) {
        PaymentService.enterInvalidCard(estado);
    }

    @Then("Debo ver el mensaje de error {string}")
    public void verificoMensajeError(String mensajeEsperado) {
        String mensajeActual = PaymentService.getErrorMessage();
        // Assert con tolerancia a variaciones de texto
        assert mensajeActual.contains(mensajeEsperado) :
                "Se esperaba: '" + mensajeEsperado + "' pero se encontró: '" + mensajeActual + "'";
    }
}