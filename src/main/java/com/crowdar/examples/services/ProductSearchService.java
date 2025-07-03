package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.constants.ProductSearchConstants;
import junit.framework.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ProductSearchService {

    public static void clickEleccionInicioSesion(){
        MobileActionManager.click(ProductSearchConstants.LOGIN_BUTTON_SELECT_XPATH);
    }

    public static void inicioSesion(String user, String pass){
        MobileActionManager.waitClickable(ProductSearchConstants.EMAIL_INPUT_LOCATOR_XPATH);
        MobileActionManager.setInput(ProductSearchConstants.EMAIL_INPUT_LOCATOR_XPATH, user);
        MobileActionManager.click(ProductSearchConstants.BUTTON_CONTINUE_EMAIL_LOCATOR);
        MobileActionManager.setInput(ProductSearchConstants.PASSWORD_INPUT_LOCATOR, pass);
        MobileActionManager.click(ProductSearchConstants.BUTTON_INICIAR_SESION_LOCATOR);

    }

    public static void busquedaProd(String producto){
        MobileActionManager.waitClickable(ProductSearchConstants.SEARCH_LOCATOR);
        MobileActionManager.click(ProductSearchConstants.SEARCH_LOCATOR);
        MobileActionManager.setInput(ProductSearchConstants.SEARCH_INPUT_LOCATOR, producto);
        WebElement elemento = MobileActionManager.getElement(ProductSearchConstants.SEARCH_INPUT_LOCATOR);
        elemento.sendKeys(Keys.ENTER);

    }

    public static void verificaRubro(){
        MobileActionManager.waitVisibility(ProductSearchConstants.UBICACION_FILTER);
        Assert.assertTrue(MobileActionManager.isVisible(ProductSearchConstants.UBICACION_FILTER));
    }
}
