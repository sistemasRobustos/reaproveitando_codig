/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.cadastro.modelo.objeto_editando;


/**
 * Faz a comunicação dos das telas que estão editando o objeto T
 * 
 * tenho o metodo principal que é o setObject e um que alterado caso o primeiro for setado:
 * o getEstado e o getObject
 * 
 *
 * @author felix
 * @param <T>
 */
public interface ObjectEditando<T> {
    /**
     * Muda o objeto que vai ser editado.
     * 
     * @param obj se for null vai ser para criar um novo object e se não for null vai ser para editar
     */
    public void setObject(T obj);
    
    public void cancelaEdicao();
    
    
    /**
     * 
     * @return o object que esta sendo editado na view
     */
    public T getObject();
    
    /**
     * 
     * @return o estado do objeto que esta sendo editado na tela.
     */
    public Estado getEstado();
    
    public void addEditandoListener(EditandoListener list);
    
    public void removeEditandoListener(EditandoListener list);
    
    public static enum Estado{
        EDITANDO,// quando estiver editando o object
        SALVANDO,// quando estiver criando um novo objeto
        DESABILITADO// quando não estiver fazendo nada com o object
    }
    
}
