/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.model.session;

import br.com.sistemas_robustos.cadastro.modelo.DefaultPessoaModeloDados;
import br.com.sistemas_robustos.cadastro.modelo.PessoaModeloDados;
import br.com.sistemas_robustos.login.model.AdminPessoaModeloDados;

/**
 *
 * @author felix
 */
public class AdminSession implements SessionModel {

    private PessoaModeloDados modeoPessoa;

    @Override
    public <T> T getModel(String key) throws Exception {
        switch (key) {
            case "pessoa_modelo_dados":
                if (modeoPessoa == null) {
                    modeoPessoa = new AdminPessoaModeloDados();
                }
                return (T) modeoPessoa;
                
                default:
                    throw new IllegalArgumentException("Voce não tem permição!!!");
        }

    }

    @Override
    public void close() {

    }

}
