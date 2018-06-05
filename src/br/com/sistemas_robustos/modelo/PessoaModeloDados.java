/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.modelo;

import br.com.sistemas_robustos.modelo.list.CRUDList;
import br.com.sistemas_robustos.entity.Pessoa;
import javax.swing.table.TableModel;

/**
 *
 * @author felix
 */
public interface PessoaModeloDados extends CRUDList<Pessoa>, TableModel{
    public Pessoa getPessoa(int index);
        
}
