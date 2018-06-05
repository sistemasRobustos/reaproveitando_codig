/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.controle.formulario;

import br.com.sistemas_robustos.entity.Pessoa;
import br.com.sistemas_robustos.modelo.list.CRUDList;
import br.com.sistemas_robustos.modelo.objeto_editando.ObjectEditando;
import br.com.sistemas_robustos.view.lista_formulario.TelaFormularioPessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author felix
 */
public class ConfirmaOperacaoFormulario implements ActionListener{

    private TelaFormularioPessoa tela;
    
    private ObjectEditando objEdi;
    
    private CRUDList model;

    public ConfirmaOperacaoFormulario(TelaFormularioPessoa tela, ObjectEditando objEdi, CRUDList crud) {
        this.tela = tela;
        this.objEdi = objEdi;
        this.model = crud;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            if(objEdi.getEstado() == ObjectEditando.Estado.DESABILITADO){
                throw new Exception("Uma Operação não selecionada!!!");
            }
            
            Pessoa p = (Pessoa) objEdi.getObject();
            
            p.setNome(tela.getjTNome().getText());
            
            try {
                p.setIdade(Integer.parseInt(tela.getjTIdade().getText()));
            } catch (NumberFormatException ei) {
                throw new Exception("Campo Idade Formato Incorreto!!!");
            }
            
            try {
                p.setSalario(Float.parseFloat(tela.getjTSalario().getText()));
            } catch (NumberFormatException es) {
                throw new Exception("Campo Salario Formato Incorreto!!!");
            }
            
            switch(objEdi.getEstado()){
                case EDITANDO:
                    model.edit(p);
                    break;
                case SALVANDO:
                    model.add(p);
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tela, ex.getMessage());
            
        }
    }
    
}
