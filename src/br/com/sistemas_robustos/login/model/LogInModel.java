/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.model;

import br.com.sistemas_robustos.login.model.session.SessionModel;
import br.com.sistemas_robustos.entity.login.PessoaLogin;
import br.com.sistemas_robustos.login.controle.login.LogInEvent;


/**
 * O que vou mostrar nesse video?
 * 
 * como usar uma tela de login para acessar mais de uma tela a seguir.
 * e como utilizar um session diferente para cada tipo de usuario.
 * 
 * 
 * @author drfelix
 */
public interface LogInModel {
    /**
     * Efetua o login no sistema.
     * @param login
     * @param senha 
     * @throws java.lang.Exception 
     */
    public void logIn(String login, String senha)throws Exception;
    
    
    /**
     * Efetua o logOff no sistema.
     * 
     * Esse method deve desligar todos os auxiliares de conexão. e zerar todos as
     * variaveis que dão apoio a conexão.
     * @throws java.lang.Exception
     */
    public void logOff()throws Exception;
    
    /**
     * @return a pessoa logada.
     */
    public PessoaLogin getPessoaLogada();
    

    /**
     * 
     * @return o modelo que vai cuidar de retornar os modelos com 
     * configurações especificas para cada usuario
     */
    public SessionModel getSession();
    
    /**
     * verifica se tem uma pessoa logada
     * @return 
     */
    public boolean isLogIn();

    
    /**
     * @param event que sera avizado quando algo no login ocorrer.
     */
    public void addEvent(LogInEvent event);
    public void removeEvent(LogInEvent event);
    
}
