/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.modelo.objeto_editando.pessoa;

import br.com.sistemas_robustos.entity.Pessoa;
import br.com.sistemas_robustos.modelo.objeto_editando.EditandoListener;
import br.com.sistemas_robustos.modelo.objeto_editando.ObjectEditando;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felix
 */
public class PessoaObjectEditando implements ObjectEditando<Pessoa>{

    
    
//    os ouvintes que serão avisado quando ouver mudanças
    private List<EditandoListener> list;
//    mostra o estado do objeto
    private Estado estadoObjeto;
//    objeto em si
    private Pessoa object;

    public PessoaObjectEditando() {
        this.list = new ArrayList<>();
        this.estadoObjeto = Estado.DESABILITADO;
    }
    
    
    
    
    @Override
    public void setObject(Pessoa obj) {
        if(obj == null){
            obj = new Pessoa();
            estadoObjeto = Estado.SALVANDO;
        }else{
            estadoObjeto = Estado.EDITANDO;
        }
        this.object = obj;
        
        mudouEstado();
            
    }

    @Override
    public void cancelaEdicao() {
        this.object = null;
        this.estadoObjeto = Estado.DESABILITADO;
        mudouEstado();
    }

    @Override
    public Pessoa getObject() {
        return object;
    }

    @Override
    public Estado getEstado() {
        return estadoObjeto;
    }

    @Override
    public void addEditandoListener(EditandoListener list) {
        this.list.add(list);
    }

    @Override
    public void removeEditandoListener(EditandoListener list) {
        this.list.remove(list);
    }
    
    protected void mudouEstado(){
        for (EditandoListener editandoListener : list) {
            editandoListener.mudouEstado();
        }
    }
    
}
