/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.controle;

import br.com.sistemas_robustos.login.controle.login.LogInEvent;
import br.com.sistemas_robustos.login.model.LogInModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author felix
 */
public class LogOff implements ActionListener{
    
    private LogInModel modelLogin;

    public LogOff(LogInModel modelLogin) {
        this.modelLogin = modelLogin;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            modelLogin.logOff();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
