/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.cadastro.controle.atualiza_tela;

import br.com.sistemas_robustos.cadastro.modelo.list.CrudListener;
import br.com.sistemas_robustos.cadastro.modelo.objeto_editando.ObjectEditando;
import javax.swing.JOptionPane;

/**
 *
 * @author felix
 */
public class OperacaoBemSucedida implements CrudListener {

    private ObjectEditando obj;

    public OperacaoBemSucedida(ObjectEditando obj) {
        this.obj = obj;
    }

    @Override
    public void adicionadoComExito(Object ob) {
        if (obj.getObject() != null) {
            if (obj.getObject().equals(ob)) {
                JOptionPane.showMessageDialog(null, "Pessoa Adicionada Com Exito!!!");

                obj.cancelaEdicao();
            }
        }
    }

    @Override
    public void editadoComExito(Object ob) {
        if (obj.getObject() != null) {
            if (obj.getObject().equals(ob)) {
                JOptionPane.showMessageDialog(null, "Pessoa Editada Com Exito!!!");

                obj.cancelaEdicao();
            }
        }
    }

    @Override
    public void removidoComExito(Object ob) {
        JOptionPane.showMessageDialog(null, "Pessoa Deletada Com Exito!!!");

        obj.cancelaEdicao();
    }

}
