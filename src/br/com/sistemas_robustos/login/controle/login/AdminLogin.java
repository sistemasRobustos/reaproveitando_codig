/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.controle.login;

import br.com.sistemas_robustos.cadastro.modelo.PessoaModeloDados;
import br.com.sistemas_robustos.entity.Pessoa;
import br.com.sistemas_robustos.entity.login.Admin;
import br.com.sistemas_robustos.login.model.LogInModel;
import br.com.sistemas_robustos.login.view.TelaAdmin;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author felix
 */
public class AdminLogin implements LogInEvent, TableModelListener {

    private LogInModel modelLogIn;

    private TelaAdmin tela;

    private PessoaModeloDados modelPessoas;

    public AdminLogin(LogInModel modelLogIn) {
        this.modelLogIn = modelLogIn;
    }

    @Override
    public void chagedLogIn() {
        if (modelLogIn.isLogIn()) {
            Pessoa p = modelLogIn.getPessoaLogada().getPessoa();

            if (p instanceof Admin) {
                if (tela == null) {
                    tela = createTela();
                }
                tela.setVisible(true);
            } else {
                if (tela != null) {
                    tela.dispose();
                }
            }
        }else{
            if(tela != null){
                tela.dispose();
            }
        }

    }

    protected TelaAdmin createTela() {
        try {
            TelaAdmin te = new TelaAdmin();
            te.getjBLista().addActionListener(new FuncionarioLogin(modelLogIn));

            this.modelPessoas = modelLogIn.getSession().getModel("pessoa_modelo_dados");

            this.modelPessoas.addTableModelListener(this);
            te.setLocationRelativeTo(null);
            return te;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (tela != null) {
            tela.getjTQtdPessoas().setText(modelPessoas.getRowCount() + "");
        }
    }

}
