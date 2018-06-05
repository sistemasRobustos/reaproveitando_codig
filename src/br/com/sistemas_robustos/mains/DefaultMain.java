/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.mains;

import br.com.sistemas_robustos.controle.atualiza_tela.OperacaoBemSucedida;
import br.com.sistemas_robustos.controle.atualiza_tela.PermicaoCampos;
import br.com.sistemas_robustos.controle.atualiza_tela.PreencheTela;
import br.com.sistemas_robustos.controle.formulario.CancelarOperacao;
import br.com.sistemas_robustos.controle.formulario.ConfirmarOperacaoLista;
import br.com.sistemas_robustos.controle.linha_comando.LinhaComando;
import br.com.sistemas_robustos.controle.list.DeletarObject;
import br.com.sistemas_robustos.controle.list.EditarObject;
import br.com.sistemas_robustos.controle.list.NovoEdicao;
import br.com.sistemas_robustos.modelo.DefaultPessoaModeloDados;
import br.com.sistemas_robustos.modelo.objeto_editando.ObjectEditando;
import br.com.sistemas_robustos.modelo.objeto_editando.pessoa.PessoaObjectEditando;
import br.com.sistemas_robustos.view.tela_lista.TelaListaPessoa;

/**
 *
 * @author felix
 */
public class DefaultMain {
    public static void main(String[] args) {
//        crio a tela que exibe os dados e edita os dados de pessoas.
        TelaListaPessoa tela = new TelaListaPessoa();
        
//        usado para guardar o objeto que esta sendo editado pelo usuario.
        ObjectEditando pess = new PessoaObjectEditando();
        
//        modelo que guarda a lista de pessoas cadastradas
        DefaultPessoaModeloDados model = new DefaultPessoaModeloDados();
        
        pess.addEditandoListener(new PermicaoCampos(tela, pess));
        pess.addEditandoListener(new PreencheTela(tela, pess));
       
        model.addCRUDListener(new OperacaoBemSucedida(pess));
        
        tela.getjBNovo().addActionListener(new NovoEdicao(pess));
        tela.getjBDeletar().addActionListener(new DeletarObject(model, tela.getjTAPessoa().getSelectionModel()));
        tela.getjBEditar().addActionListener(new EditarObject(model, tela.getjTAPessoa().getSelectionModel(), pess));
   
        tela.getjBConfirmar().addActionListener(new ConfirmarOperacaoLista(tela, pess, model));
        tela.getjBCancelar().addActionListener(new CancelarOperacao(pess));
        
        tela.getjTAPessoa().setModel(model);
        
        tela.setVisible(true);
        
        
        LinhaComando linha = new LinhaComando(model);
        
        linha.iniciaLinhaComando();
    
    }
}
