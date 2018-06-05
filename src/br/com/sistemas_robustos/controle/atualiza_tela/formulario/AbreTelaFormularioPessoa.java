/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.controle.atualiza_tela.formulario;

import br.com.sistemas_robustos.controle.formulario.CancelarOperacao;
import br.com.sistemas_robustos.controle.formulario.ConfirmaOperacaoFormulario;
import br.com.sistemas_robustos.entity.Pessoa;
import br.com.sistemas_robustos.modelo.list.CRUDList;
import br.com.sistemas_robustos.modelo.objeto_editando.EditandoListener;
import br.com.sistemas_robustos.modelo.objeto_editando.ObjectEditando;
import br.com.sistemas_robustos.view.lista_formulario.TelaFormularioPessoa;

/**
 *
 * @author felix
 */
public class AbreTelaFormularioPessoa implements EditandoListener {

    private ObjectEditando objEdi;

    private CRUDList crud;

    private TelaFormularioPessoa tela;

    public AbreTelaFormularioPessoa(ObjectEditando objEdi, CRUDList crud) {
        this.objEdi = objEdi;
        this.crud = crud;
    }
    
    

    @Override
    public void mudouEstado() {
        switch (objEdi.getEstado()) {
            case DESABILITADO:
                if (tela != null) {
                    tela.dispose();
                }
                break;
                case EDITANDO:
                    iniciaTela();
                    preencheFormulario();
                    tela.getjBConfirmar().setText("Editar");
                    
                    break;
                case SALVANDO:
                    iniciaTela();
                    limpaFormulario();
                    tela.getjBConfirmar().setText("Salvar");
                    
                    break;
        }
    }
    
    public void limpaFormulario(){
        if(tela != null){
            tela.getjTIdade().setText("");
            tela.getjTNome().setText("");
            tela.getjTSalario().setText("");
        }
            
    }
    public void preencheFormulario(){
        Pessoa p = (Pessoa) objEdi.getObject();
        if(tela != null){
            tela.getjTIdade().setText(p.getIdade()+"");
            tela.getjTNome().setText(p.getNome());
            tela.getjTSalario().setText(p.getSalario()+"");
        }
            
    }
    
    
    
    protected void iniciaTela(){
        if(tela == null){
            tela = createTela();
        }
        tela.setVisible(true);
    }
    protected TelaFormularioPessoa createTela(){
        TelaFormularioPessoa te = new TelaFormularioPessoa();
        te.getjBCancelar().addActionListener(new CancelarOperacao(objEdi));
        te.getjBConfirmar().addActionListener(new ConfirmaOperacaoFormulario(te, objEdi, crud));
        
        te.setLocationRelativeTo(null);
        
        return te;
    }
}
