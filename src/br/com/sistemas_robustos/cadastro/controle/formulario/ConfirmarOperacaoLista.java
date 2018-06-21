/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.cadastro.controle.formulario;

import br.com.sistemas_robustos.entity.Pessoa;
import br.com.sistemas_robustos.cadastro.modelo.PessoaModeloDados;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.ObjectEditando;
import br.com.sistemas_robustos.cadastro.view.tela_lista.TelaListaPessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author felix
 */
public class ConfirmarOperacaoLista implements ActionListener{

    private TelaListaPessoa tela;
    
    private ObjectEditando objModel;
    
    private PessoaModeloDados pessoaModel;

    public ConfirmarOperacaoLista(TelaListaPessoa tela, ObjectEditando objModel, PessoaModeloDados pessoaModel) {
        this.tela = tela;
        this.objModel = objModel;
        this.pessoaModel = pessoaModel;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            
            if(objModel.getEstado() == ObjectEditando.Estado.DESABILITADO){
                throw new Exception("Uma Operação não selecionada!!!");
            }
            
            Pessoa p = (Pessoa) objModel.getObject();
            
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
            
            
            
            switch(objModel.getEstado()){
                case EDITANDO:
                    pessoaModel.edit(p);
                    break;
                case SALVANDO:
                    pessoaModel.add(p);
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tela, ex.getMessage());
        }
        
    }
    
}
