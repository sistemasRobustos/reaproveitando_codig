/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.controle;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author felix
 */
public class SairSistema extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(100);
    }
    
}
