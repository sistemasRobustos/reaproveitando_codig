/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.controle;

import br.com.sistemas_robustos.login.model.LogInModel;
import br.com.sistemas_robustos.login.view.TelaLogin;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author felix
 */
public class EntrarLogIn extends AbstractAction{
    
    
//    ////IC
    private TelaLogin tela;
    
    private LogInModel model;
    
//    ////IL
    public EntrarLogIn(TelaLogin tela, LogInModel model) {
        this.tela = tela;
        this.model = model;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
//            pego valores na tela
            String logIn = tela.getjTLogin().getText();
            String senha = tela.getjTPSenha().getText();
//            mando o model validar e efetuar login
            model.logIn(logIn, senha);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
