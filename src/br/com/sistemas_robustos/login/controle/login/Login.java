/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.controle.login;

import br.com.sistemas_robustos.login.controle.EntrarLogIn;
import br.com.sistemas_robustos.login.controle.SairSistema;
import br.com.sistemas_robustos.login.model.LogInModel;
import br.com.sistemas_robustos.login.view.TelaLogin;

/**
 *
 * @author felix
 */
public class Login implements LogInEvent {

    private TelaLogin tela;

    private LogInModel loginModel;

    public Login(LogInModel loginModel) {
        this.loginModel = loginModel;
        chagedLogIn();
    }

    @Override
    public void chagedLogIn() {
        if (!loginModel.isLogIn()) {
            if (tela == null) {
                this.tela = createTela();
            }
            tela.getjTLogin().setText("");
            tela.getjTPSenha().setText("");
            tela.setVisible(true);
        } else {
            tela.dispose();
        }

    }

    private TelaLogin createTela() {
        TelaLogin te = new TelaLogin();

        te.confEntrar(new EntrarLogIn(te, loginModel));
        te.confSair(new SairSistema());
        te.setLocationRelativeTo(null);
        return te;
    }

}
