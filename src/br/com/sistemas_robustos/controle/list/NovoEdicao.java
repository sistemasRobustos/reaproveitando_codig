/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.controle.list;

import br.com.sistemas_robustos.modelo.objeto_editando.ObjectEditando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felix
 */
public class NovoEdicao implements ActionListener{
//  IC
    private ObjectEditando model;

    public NovoEdicao(ObjectEditando model) {
        this.model = model;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        model.setObject(null);
    }
    
}
