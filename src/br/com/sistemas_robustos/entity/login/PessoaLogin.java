/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.entity.login;

import br.com.sistemas_robustos.entity.Pessoa;

/**
 *
 * @author felix
 */
public class PessoaLogin {
    
    private Pessoa pessoa;
    
    private String login;
    
    private String senha;

    public PessoaLogin(Pessoa pessoa, String login, String senha) {
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
