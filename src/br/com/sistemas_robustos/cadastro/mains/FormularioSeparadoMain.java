/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.cadastro.mains;

import br.com.sistemas_robustos.cadastro.controle.atualiza_tela.OperacaoBemSucedida;
import br.com.sistemas_robustos.cadastro.controle.atualiza_tela.formulario.AbreTelaFormularioPessoa;
import br.com.sistemas_robustos.cadastro.controle.list.DeletarObject;
import br.com.sistemas_robustos.cadastro.controle.list.EditarObject;
import br.com.sistemas_robustos.cadastro.controle.list.NovoEdicao;
import br.com.sistemas_robustos.cadastro.modelo.DefaultPessoaModeloDados;
import br.com.sistemas_robustos.cadastro.modelo.PessoaModeloDados;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.ObjectEditando;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.pessoa.PessoaObjectEditando;
import br.com.sistemas_robustos.cadastro.view.lista_formulario.TelaPessoas;

/**
 *
 * @author felix
 */
public class FormularioSeparadoMain {
    public static void main(String[] args) {
//        tela lista
        TelaPessoas tela = new TelaPessoas();
        
        
//        //modelos
//        modelo lista de pessoas
        PessoaModeloDados model = new DefaultPessoaModeloDados();
//        modelo que e responsavel por guardar o objeto que esta sendo editado.
        ObjectEditando pess = new PessoaObjectEditando();
        
        
//        evento que abre a tela para editar o objeto
        pess.addEditandoListener(new AbreTelaFormularioPessoa(pess, model));
        
//        mostra as mensagens de concluido pro usuario
        model.addCRUDListener(new OperacaoBemSucedida(pess));
        
//        eventos da tela
//        do botão de novo
        tela.getjBNovo().addActionListener(new NovoEdicao(pess));
//        do botão de editar
        tela.getjBEditar().addActionListener(new EditarObject(model, tela.getjTable1().getSelectionModel(), pess));
//        do botão de deletar
        tela.getjBDeletar().addActionListener(new DeletarObject(model, tela.getjTable1().getSelectionModel()));
        
        
        tela.getjTable1().setModel(model);
        
        tela.setLocationRelativeTo(null);
        
        tela.setVisible(true);
    }
}
