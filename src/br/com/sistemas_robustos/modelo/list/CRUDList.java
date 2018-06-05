/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.modelo.list;

/**
 * Usado de interface da UI com a estrutura de dados para fazer operações 
 * simples de crud.
 * Deve ser usado em conjunto com uma estrutura de dados para garantir a atualização dos dados na UI.
 * @author drfelix
 * @param <T>
 */
public interface CRUDList<T> {
    /**
     * add value na base de dados e atualiza na tela.
     * @param value 
     * @throws java.lang.Exception 
     */
    public void add(T value)throws Exception;
    /**
     * remove value
     * @param value 
     * @throws java.lang.Exception 
     */
    public void remove(T value)throws Exception;
    
    /**
     * 
     * @param value 
     * @throws java.lang.Exception 
     */
    public void edit(T value)throws Exception;
    
    public void addCRUDListener(CrudListener listener);
    
    public void removeCRUDListener(CrudListener listener);
    
}
