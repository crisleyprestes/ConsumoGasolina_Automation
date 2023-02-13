package com.linhares.crisley.tests;

import com.linhares.crisley.BaseTest;
import com.linhares.crisley.pages.HomePage;
import com.linhares.crisley.pages.UsuariosPage;
import org.junit.Assert;
import org.junit.Test;

public class UsuariosTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private UsuariosPage usuariosPage = new UsuariosPage();

    private String username = usuariosPage.generateUsername();
    private String menuPath = "Início › Autenticação e Autorização › Usuários › " + ""+username+"";
    private String successMessage = "O usuário " + "“"+username+"”" + " foi adicionado com sucesso. " +
            "Você pode editá-lo novamente abaixo.";

    @Test
    public void createNewUser(){
        homePage.clickUsuarios();
        usuariosPage.clickAddButton();
        usuariosPage.createUser(username, "rC6v7Z@5", "rC6v7Z@5");
        Assert.assertEquals(successMessage, usuariosPage.getSuccessMessage());
        Assert.assertEquals(menuPath, usuariosPage.getMenuPath());
    }

    @Test
    public void searchUser(){
        homePage.clickUsuarios();
        usuariosPage.searchUser("admin");
        Assert.assertTrue(usuariosPage.isSearch("admin"));
    }
}
