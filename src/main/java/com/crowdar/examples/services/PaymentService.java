package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.PaymentConstants;
import java.util.Map;

public class PaymentService extends MobileActionManager {

    private static final Map<String, String> TEST_CARDS = Map.of(
            "OTHE", "4000000000000004", // Rechazado por error general
            "FUND", "4000000000000028", // Rechazado por importe insuficiente
            "SECU", "4000000000000101"  // Rechazado por código de seguridad inválido
    );

    public static void searchProduct(String product) {
        click(PaymentConstants.SEARCH_BOX);
        setInput(PaymentConstants.SEARCH_BOX, product);
        pressEnterKey();
    }

    public static void pressEnterKey() {
        try {
            Runtime.getRuntime().exec("adb shell input keyevent 66");
            Thread.sleep(1000); // Pequeña pausa
        } catch (Exception e) {
            throw new RuntimeException("Error al presionar Enter", e);
        }
    }

    public static void selectFirstResult() {
        click(PaymentConstants.FIRST_RESULT);
    }

    public static void addToCart() {
        click(PaymentConstants.ADD_TO_CART_BUTTON);
    }

    public static void checkoutAsGuest() {
        click(PaymentConstants.GUEST_CHECKOUT_BUTTON);
    }

    public static void completeShippingAddress() {
        click(PaymentConstants.ADDRESS_CONFIRM_BUTTON);
    }

    public static void selectCreditCardPayment() {
        click(PaymentConstants.CREDIT_CARD_OPTION);
    }

    public static void enterInvalidCard(String status) {
        String cardNumber = TEST_CARDS.get(status);
        setInput(PaymentConstants.CARD_NUMBER_INPUT, cardNumber);
        setInput(PaymentConstants.CARD_HOLDER_INPUT, status); // Estado como nombre
        setInput(PaymentConstants.EXPIRY_DATE_INPUT, "1125"); // Nov 2025
        setInput(PaymentConstants.CVV_INPUT, "123");
        click(PaymentConstants.CONTINUE_BUTTON);
    }

    public static String getErrorMessage() {
        return getText(PaymentConstants.ERROR_MESSAGE);
    }
}