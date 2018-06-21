/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.model;

import br.com.sistemas_robustos.cadastro.modelo.DefaultPessoaModeloDados;
import br.com.sistemas_robustos.entity.Pessoa;

/**
 *
 * @author felix
 */
public class AdminPessoaModeloDados extends DefaultPessoaModeloDados{

    @Override
    protected void verificaSalario(float salario) {
        
    }

    @Override
    protected void verificarIdade(int idade) {
        
    }

    @Override
    public void add(Pessoa value) throws Exception {
        super.add(value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Pessoa value) throws Exception {
        super.remove(value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Pessoa pessoa) throws Exception {
        super.edit(pessoa); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
