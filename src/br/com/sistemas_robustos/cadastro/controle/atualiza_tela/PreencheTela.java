/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.cadastro.controle.atualiza_tela;

import br.com.sistemas_robustos.entity.Pessoa;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.EditandoListener;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.ObjectEditando;
import br.com.sistemas_robustos.cadastro.view.tela_lista.TelaListaPessoa;

/**
 *
 * @author felix
 */
public class PreencheTela implements EditandoListener{

    private TelaListaPessoa tela;
    
    private ObjectEditando editanModel;

    public PreencheTela(TelaListaPessoa tela, ObjectEditando editanModel) {
        this.tela = tela;
        this.editanModel = editanModel;
    }
    
    
    
    @Override
    public void mudouEstado() {
        if(editanModel.getEstado() == ObjectEditando.Estado.EDITANDO){
            preencheCampos((Pessoa) editanModel.getObject());
        }else{
            limpaCampos();
        }
    }
    
    protected void limpaCampos(){
        tela.getjTIdade().setText("");
        tela.getjTNome().setText("");
        tela.getjTSalario().setText("");
    }
    protected void preencheCampos(Pessoa p){
        tela.getjTIdade().setText(p.getIdade()+"");
        tela.getjTNome().setText(p.getNome());
        tela.getjTSalario().setText(p.getSalario()+"");
    }
    
}
