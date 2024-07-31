package com.mycompany.pages.owners;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class OwnerPage extends PageObject {

    //Propietarios
    @FindBy(xpath = "//*[@id=\"main-navbar\"]/ul/li[2]/a")
    WebElementFacade ownerMenuLink;

    @FindBy(xpath = "//*[@id=\"search-owner-form\"]/div[2]/div/button")
    WebElementFacade ownerListButton;

    @FindBy(id = "owners")
    WebElementFacade ownersTitle;

    @Step("Click on the owner menu link")
    public void clickOnOwnerMenuLink() {
        ownerMenuLink.waitUntilClickable().click();
    }

    @Step("Click on the owner list button")
    public void clickOnOwnerListButton() {
        ownerListButton.waitUntilClickable().click();
    }

    @Step("Get Owners header text")
    public String getOwnersHeaderText() {
        return ownersTitle.waitUntilVisible().getText();
    }

    //Veterinarians  ListarVeterinarians
    @FindBy(xpath = "//*[@id=\"main-navbar\"]/ul/li[3]/a")
    WebElementFacade VeterinariansMenuLink;

    @FindBy(id = "veterinarians")
    WebElementFacade veterinariansTitle;

   @Step("Click on the veterinarians menu link")
    public void clickOnVeterinariansMenuLink() {
       VeterinariansMenuLink.waitUntilClickable().click();
   }

   @Step("Get veterinarians header text")
    public String getVeterinariansHeaderText() {
       return veterinariansTitle.waitUntilVisible().getText();
   }
    // Veterinarians VerJsonDeListaVeterinarians
    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/a[contains(text(), 'View as JSON')]")
    private WebElementFacade viewAsJsonLink;

    @Step("Verificar que el enlace 'View as JSON' está presente")
    public boolean isViewAsJsonLinkPresent() {
        return viewAsJsonLink.isPresent();
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/a")
    WebElementFacade verJsonMenuLink;

    @Step("Click on Json veterinarians link")
    public void clickOnJsonVeterinariansLink() {
        verJsonMenuLink.waitUntilClickable().click();
    }

    @Step("Verificar que el contenido del elemento está lleno")
    public String verificarJsonLlenoVeterinarians() {
        WebElementFacade element = find(By.xpath("/html/body/pre"));
        return element.getText();
    }

}
