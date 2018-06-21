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
public class Admin extends Pessoa{
    private String telefone;

    public Admin() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
}
