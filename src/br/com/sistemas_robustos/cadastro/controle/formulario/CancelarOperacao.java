/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.cadastro.controle.formulario;

import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.ObjectEditando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felix
 */
public class CancelarOperacao implements ActionListener{

    private ObjectEditando objModel;

    public CancelarOperacao(ObjectEditando objModel) {
        this.objModel = objModel;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        objModel.cancelaEdicao();
    }
    
}
