/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.controle.list;

import br.com.sistemas_robustos.modelo.PessoaModeloDados;
import br.com.sistemas_robustos.modelo.objeto_editando.ObjectEditando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author felix
 */
public class EditarObject implements ActionListener {

    private PessoaModeloDados pessoaModel;

    private ListSelectionModel seleModel;

    private ObjectEditando editandoModel;

    public EditarObject(PessoaModeloDados pessoaModel, ListSelectionModel seleModel, ObjectEditando editandoModel) {
        this.pessoaModel = pessoaModel;
        this.seleModel = seleModel;
        this.editandoModel = editandoModel;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int sele = seleModel.getMaxSelectionIndex();

            if (sele == -1) {
                throw new Exception("Selecione uma Pessoa!!!");
            }
            
            editandoModel.setObject(pessoaModel.getPessoa(sele));
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
