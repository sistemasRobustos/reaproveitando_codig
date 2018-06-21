/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.controle.login;

import br.com.sistemas_robustos.entity.login.PessoaLogin;
import br.com.sistemas_robustos.login.controle.LogOff;
import br.com.sistemas_robustos.login.model.LogInModel;
import br.com.sistemas_robustos.login.view.TelaMonitoraLogin;

/**
 *
 * @author felix
 */
public class MonitoraLogin implements LogInEvent{

    private LogInModel modelLogin;
    
    private TelaMonitoraLogin tela;

    public MonitoraLogin(LogInModel modelLogin) {
        this.modelLogin = modelLogin;
        chagedLogIn();
    }
    
    
    
    
    
    @Override
    public void chagedLogIn() {
        if(tela == null){
            tela = new TelaMonitoraLogin();
            tela.getjBLogOff().addActionListener(new LogOff(modelLogin));
            tela.setVisible(true);
        }
        
        
        if(modelLogin.isLogIn()){
            PessoaLogin pe = modelLogin.getPessoaLogada();
            
            tela.getjTEstatus().setText("Online");
            tela.getjTLogin().setText(pe.getLogin());
            tela.getjTNome().setText(pe.getPessoa().getNome());
            tela.getjTIdade().setText(pe.getPessoa().getIdade()+"");
            
            tela.getjBLogOff().setEnabled(true);
            
        }else{
            tela.getjTEstatus().setText("Off");
            tela.getjTLogin().setText("");
            tela.getjTNome().setText("");
            tela.getjTIdade().setText("");
            
            tela.getjBLogOff().setEnabled(false);
        }
        
    }
    
}
