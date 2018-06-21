/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.cadastro.controle.list;

import br.com.sistemas_robustos.cadastro.modelo.PessoaModeloDados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author felix
 */
public class DeletarObject implements ActionListener{

    private PessoaModeloDados pessoaModel;

    private ListSelectionModel seleModel;

    public DeletarObject(PessoaModeloDados pessoaModel, ListSelectionModel seleModel) {
        this.pessoaModel = pessoaModel;
        this.seleModel = seleModel;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int sele = seleModel.getMaxSelectionIndex();

            if (sele == -1) {
                throw new Exception("Selecione uma Pessoa!!!");
            }
            
            pessoaModel.remove(pessoaModel.getPessoa(sele));
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
