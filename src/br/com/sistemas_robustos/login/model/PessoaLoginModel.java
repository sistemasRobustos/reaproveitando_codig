/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.model;

import br.com.sistemas_robustos.login.model.session.SessionModel;
import br.com.sistemas_robustos.entity.login.Admin;
import br.com.sistemas_robustos.entity.login.Funcionario;
import br.com.sistemas_robustos.entity.login.PessoaLogin;
import br.com.sistemas_robustos.login.controle.login.LogInEvent;
import br.com.sistemas_robustos.login.model.session.AdminSession;
import br.com.sistemas_robustos.login.model.session.FuncionarioSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felix
 */
public class PessoaLoginModel implements LogInModel{

    private PessoaLogin pessoaLogada;
    
    private SessionModel session;
    
    private List<LogInEvent> eventos;
    
    
    
    private List<PessoaLogin> pessoas;

    public PessoaLoginModel() {
        eventos = new ArrayList<>();
        pessoas = criaPessoas();
            
    }
    
    
    private List<PessoaLogin> criaPessoas(){
        
        List<PessoaLogin> pessoasLogin = new ArrayList<>();
        
        Admin p = new Admin();
        p.setIdade(20);
        p.setNome("João");
        p.setSalario(900);
        p.setTelefone("0001258");
        
        pessoasLogin.add(new PessoaLogin(p, "admin", "admin"));
        
        Admin p1 = new Admin();
        p1.setIdade(24);
        p1.setNome("Maria");
        p1.setSalario(900);
        p1.setTelefone("907892103");
        
        pessoasLogin.add(new PessoaLogin(p1, "maria", "abc"));

        
        Funcionario fu = new Funcionario();
        fu.setIdade(18);
        fu.setNome("Ademir");
        fu.setSalario(1000);
        fu.setLojaTrabalha("Matriz");
        
        pessoasLogin.add(new PessoaLogin(fu, "ademir","a12"));
        
        Funcionario fu1 = new Funcionario();
        fu1.setIdade(19);
        fu1.setNome("Joana");
        fu1.setSalario(1500);
        fu1.setLojaTrabalha("Matriz");
        
        pessoasLogin.add(new PessoaLogin(fu1, "joana","joana"));
        
        return pessoasLogin;
    }
    
    
    
    @Override
    public void logIn(String login, String senha) throws Exception {
        PessoaLogin p = findPessoaLogada(login);
        
        if(p == null){
            throw new IllegalArgumentException("O login não existe!");
        }
        
        if(!p.getSenha().equals(senha)){
            throw new IllegalArgumentException("A senha esta incorreta!");
        }

        this.pessoaLogada = p;
        
//        iniciar a session.
        if(p.getPessoa() instanceof Admin){
            this.session = new AdminSession();
        }else if(p.getPessoa() instanceof Funcionario){
            this.session = new FuncionarioSession();
        }
        
        fireChagedLogin();
        
    }
    
    private PessoaLogin findPessoaLogada(String login){
        for(PessoaLogin pessoa : pessoas){
            if(pessoa.getLogin().equals(login)){
                return pessoa;
            }
        }
        return null;
    }
            
    

    @Override
    public void logOff() throws Exception {
         this.pessoaLogada = null;
         this.session = null;
         
         fireChagedLogin();
    }

    @Override
    public PessoaLogin getPessoaLogada() {
        if(!isLogIn()){
            throw new IllegalArgumentException("Não esta logado!");
        }
        return pessoaLogada;
    }

    @Override
    public SessionModel getSession() {
        return session;
    }

    @Override
    public void addEvent(LogInEvent event) {
        this.eventos.add(event);
    }

    @Override
    public void removeEvent(LogInEvent event) {
        this.eventos.remove(event);
    }

    @Override
    public boolean isLogIn() {
        return (pessoaLogada!=null);
    }
    
    protected void fireChagedLogin(){
        for (LogInEvent evento : eventos) {
            evento.chagedLogIn();
        }
    }
    
}
