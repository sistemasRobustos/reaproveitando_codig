/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.cadastro.controle.atualiza_tela;

import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.EditandoListener;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.ObjectEditando;
import br.com.sistemas_robustos.cadastro.view.tela_lista.TelaListaPessoa;

/**
 *
 * @author felix
 */
public class PermicaoCampos implements EditandoListener{

    private TelaListaPessoa tela;
    
    private ObjectEditando editanModel;

    public PermicaoCampos(TelaListaPessoa tela, ObjectEditando editanModel) {
        this.tela = tela;
        this.editanModel = editanModel;
        mudouEstado();
    }
    
    
    
    @Override
    public void mudouEstado() {
        switch(editanModel.getEstado()){
            case SALVANDO:
                confSalvando();
                break;
            case EDITANDO:
                confEditando();
                break;
            case DESABILITADO:
                confDesabilitado();
                break;
        }
    }
    
    public void confEditando(){
        tela.getjTIdade().setEditable(true);
        tela.getjTNome().setEditable(true);
        tela.getjTSalario().setEditable(true);
        
        tela.getjBConfirmar().setEnabled(true);
        tela.getjBConfirmar().setText("Editar");
    }
    public void confSalvando(){
        tela.getjTIdade().setEditable(true);
        tela.getjTNome().setEditable(true);
        tela.getjTSalario().setEditable(true);
        
        tela.getjBConfirmar().setEnabled(true);
        tela.getjBConfirmar().setText("Salvar");
    }
    
    public void confDesabilitado(){
        tela.getjTIdade().setEditable(false);
        tela.getjTNome().setEditable(false);
        tela.getjTSalario().setEditable(false);
        
        tela.getjBConfirmar().setEnabled(false);
    }
    
}
