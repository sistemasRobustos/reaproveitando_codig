/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.modelo;

import br.com.sistemas_robustos.modelo.list.CrudListener;
import br.com.sistemas_robustos.entity.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author felix
 */
public class DefaultPessoaModeloDados extends AbstractTableModel implements PessoaModeloDados {

    private List<CrudListener> ouvintes;

    private List<Pessoa> pessoas;

    public DefaultPessoaModeloDados() {
        ouvintes = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    @Override
    public Pessoa getPessoa(int index) {
        return pessoas.get(index);
    }

    /**
     * nome não null idade >= 18 1000 < salario < 3000
     */
    @Override
    public void add(Pessoa value) throws Exception {
        verificaNome(value.getNome());
        verificarIdade(value.getIdade());
        verificaSalario(value.getSalario());

        pessoas.add(value);

//        avisar adicionado e mudado na lista
        fireTableRowsInserted(pessoas.size() - 1, pessoas.size() - 1);
        fireAddComExito(value);
    }

    @Override
    public void remove(Pessoa value) throws Exception {
        int in = pessoas.indexOf(value);

        pessoas.remove(in);

//         avisar aqui
        fireTableRowsDeleted(in, in);
        fireRemovidoComExito(value);

    }

    @Override
    public void edit(Pessoa pessoa) throws Exception {
        verificaNome(pessoa.getNome());
        verificarIdade(pessoa.getIdade());
        verificaSalario(pessoa.getSalario());

//        tenho um erro que quando mudar o nome não sera achado
        int index = pessoas.indexOf(pessoa);

        pessoas.set(index, pessoa);

//        avisar que editou e mudou alterou a lista.
        fireTableRowsUpdated(index, index);
        fireEditadoComExito(pessoa);
    }

    protected void verificaNome(String nome) {
        if (nome == null || nome.length() <= 0) {
            throw new IllegalArgumentException("Preencha o nome Por favor!!!");
        }
    }

    protected void verificarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Não é permitido pessoas com menos de 18 anos!");
        }
    }

    protected void verificaSalario(float salario) {
        if(salario < 600){
            throw new IllegalArgumentException("O salario não pode ser menor que 600!!!");
        }
    }

    @Override
    public void addCRUDListener(CrudListener listener) {
        this.ouvintes.add(listener);
    }

    @Override
    public void removeCRUDListener(CrudListener listener) {
        this.ouvintes.remove(listener);
    }

    public void fireAddComExito(Object ob) {
        for (CrudListener ouvinte : ouvintes) {
            ouvinte.adicionadoComExito(ob);
        }
    }

    public void fireEditadoComExito(Object ob) {
        for (CrudListener ouvinte : ouvintes) {
            ouvinte.editadoComExito(ob);
        }
    }

    public void fireRemovidoComExito(Object ob) {
        for (CrudListener ouvinte : ouvintes) {
            ouvinte.removidoComExito(ob);
        }
    }

    
    
    
    @Override
    public int getRowCount() {
        return pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nome";
            case 1:
                return "Idade";
            case 2:
                return "Salario";
            default:
                return "Erro Coluna";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa p = pessoas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getNome();
            case 1:
                return p.getIdade();
            case 2:
                return p.getSalario();
            default:
                return "Erro linha";
        }
    }

}
