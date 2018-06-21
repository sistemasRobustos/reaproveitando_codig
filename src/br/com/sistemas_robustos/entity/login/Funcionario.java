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
public class Funcionario extends Pessoa{
    private String lojaTrabalha;

    public Funcionario() {
    }

    public String getLojaTrabalha() {
        return lojaTrabalha;
    }

    public void setLojaTrabalha(String lojaTrabalha) {
        this.lojaTrabalha = lojaTrabalha;
    }
    
    
}
