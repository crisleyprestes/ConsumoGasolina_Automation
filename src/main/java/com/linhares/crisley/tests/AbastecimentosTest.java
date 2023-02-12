package com.linhares.crisley.tests;

import com.linhares.crisley.BaseTest;
import com.linhares.crisley.pages.AbastecimentosPage;
import com.linhares.crisley.pages.HomePage;
import com.linhares.crisley.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class AbastecimentosTest extends BaseTest {

    private AbastecimentosPage abastecimentosPage = new AbastecimentosPage();
    private HomePage homePage = new HomePage();

    @Test
    public void createNewAbastecimento(){
        homePage.clickAbastecimentos();
        abastecimentosPage.clickAddAbastecimentos();
        abastecimentosPage.inputKmSupply("40");
        abastecimentosPage.inputQuantifyLiters("40");
        abastecimentosPage.inputValue("5.59");
        abastecimentosPage.setDateSupply("12", "Fevereiro", "2018");
        abastecimentosPage.setTimeSupplyNow("12", "40");
        abastecimentosPage.clickSave();
        Assert.assertTrue(abastecimentosPage.isSuccessMessage("O Abastecimento",
                "foi adicionado com sucesso."));
        Assert.assertTrue(abastecimentosPage.isAbastecimentoAdded("40", "40", "5,59"));
    }

    @Test
    public void searchAbastecimento(){
        homePage.clickAbastecimentos();
        abastecimentosPage.search("10");
        Assert.assertTrue(abastecimentosPage.isAbastecimentoExist());
    }
}
