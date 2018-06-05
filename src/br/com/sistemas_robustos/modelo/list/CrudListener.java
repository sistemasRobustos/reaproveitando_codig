/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.modelo.list;

/**
 *
 * @author felix
 */
public interface CrudListener {
    /**
     * Chamado quando ocorrer com sucesso a adição em base de dados do ob
     * @param ob 
     */
    public void adicionadoComExito(Object ob);
    
    public void editadoComExito(Object ob);
    
    public void removidoComExito(Object ob);
    
    
}
