/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.controle.linha_comando;

import br.com.sistemas_robustos.entity.Pessoa;
import br.com.sistemas_robustos.modelo.PessoaModeloDados;
import java.util.Scanner;

/**
 *
 * @author felix
 */
public class LinhaComando {

    private PessoaModeloDados model;

    private Scanner ler;

    public LinhaComando(PessoaModeloDados model) {
        this.model = model;
        this.ler = new Scanner(System.in);
    }

    public void iniciaLinhaComando() {
        System.out.println("Programa de linha de comando para cadastro de pessoas!!!");
        System.out.println("Use os comandos abaixos:");
        System.out.println("cad - Cadastro de Pessoas!!!");
        System.out.println("ler - Ver todos as pessoas Cadastradas!!!");
        
        while (true) {
            System.out.print("->");
            String comando = ler.nextLine();
            comando = comando.toUpperCase();

            switch (comando) {
                case "CAD":
                    cadastro();
                    break;
                case "LER":
                    listarPessoas();
                    break;
                case "SAIR":
                    System.exit(0);
                    return;
                    default:
                        System.out.println("Opção Invalida!!!");
            }
        }
    }
    
    protected void cadastro(){
        try {
            Pessoa pessoa = new Pessoa();
            System.out.print("Digite o Nome: ");
            pessoa.setNome(ler.nextLine());
            
            System.out.print("Digite a idade: ");
            pessoa.setIdade(ler.nextInt());
            ler.nextLine();
            
            System.out.print("Digite o Salario: ");
            pessoa.setSalario(ler.nextFloat());
            ler.nextLine();
            model.add(pessoa);
            
        } catch (Exception e) {
            
            System.out.println("Cadastro não realizado!!!");
            System.out.println("Erro: "+e.getMessage());
        }
    }
    
    protected void listarPessoas(){
        System.out.println("Pessoas: ");
        System.out.println("-----Inicio---");
        for(int i = 0; i < model.getRowCount(); i++){
            System.out.println(model.getValueAt(i, 0));
        }
        System.out.println("-----Fim-----");
    }
}
