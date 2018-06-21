/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.controle.login;

import br.com.sistemas_robustos.cadastro.controle.atualiza_tela.OperacaoBemSucedida;
import br.com.sistemas_robustos.cadastro.controle.atualiza_tela.PermicaoCampos;
import br.com.sistemas_robustos.cadastro.controle.atualiza_tela.PreencheTela;
import br.com.sistemas_robustos.cadastro.controle.formulario.CancelarOperacao;
import br.com.sistemas_robustos.cadastro.controle.formulario.ConfirmarOperacaoLista;
import br.com.sistemas_robustos.cadastro.controle.list.DeletarObject;
import br.com.sistemas_robustos.cadastro.controle.list.EditarObject;
import br.com.sistemas_robustos.cadastro.controle.list.NovoEdicao;
import br.com.sistemas_robustos.cadastro.modelo.PessoaModeloDados;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.ObjectEditando;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.pessoa.PessoaObjectEditando;
import br.com.sistemas_robustos.cadastro.view.tela_lista.TelaListaPessoa;
import br.com.sistemas_robustos.entity.Pessoa;
import br.com.sistemas_robustos.entity.login.Funcionario;
import br.com.sistemas_robustos.login.model.LogInModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felix
 */
public class FuncionarioLogin implements LogInEvent, ActionListener {

    private LogInModel login;

    private TelaListaPessoa tela;

    public FuncionarioLogin(LogInModel login) {
        this.login = login;
    }

    @Override
    public void chagedLogIn() {
        if (login.isLogIn()) {
            Pessoa p = login.getPessoaLogada().getPessoa();
            if (p instanceof Funcionario) {
                if (tela == null) {
                    this.tela = createTela();
                }
                tela.setVisible(true);
            }
        } else {
            if (tela != null) {
                tela.dispose();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tela == null) {
            tela = createTela();
        }
        tela.setVisible(true);
    }

    private TelaListaPessoa createTela() {
        try {
            TelaListaPessoa te = new TelaListaPessoa();

//        usado para guardar o objeto que esta sendo editado pelo usuario.
            ObjectEditando pess = new PessoaObjectEditando();

//        modelo que guarda a lista de pessoas cadastradas
//            PessoaModeloDados model = new DefaultPessoaModeloDados();
            PessoaModeloDados model = login.getSession().getModel("pessoa_modelo_dados");

            pess.addEditandoListener(new PermicaoCampos(te, pess));
            pess.addEditandoListener(new PreencheTela(te, pess));

            model.addCRUDListener(new OperacaoBemSucedida(pess));

            te.getjBNovo().addActionListener(new NovoEdicao(pess));
            te.getjBDeletar().addActionListener(new DeletarObject(model, te.getjTAPessoa().getSelectionModel()));
            te.getjBEditar().addActionListener(new EditarObject(model, te.getjTAPessoa().getSelectionModel(), pess));

            te.getjBConfirmar().addActionListener(new ConfirmarOperacaoLista(te, pess, model));
            te.getjBCancelar().addActionListener(new CancelarOperacao(pess));

            te.getjTAPessoa().setModel(model);

            return te;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
