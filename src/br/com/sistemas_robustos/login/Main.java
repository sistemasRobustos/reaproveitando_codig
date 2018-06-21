package br.com.sistemas_robustos.login;

import br.com.sistemas_robustos.login.controle.login.AdminLogin;
import br.com.sistemas_robustos.login.controle.login.FuncionarioLogin;
import br.com.sistemas_robustos.login.controle.login.Login;
import br.com.sistemas_robustos.login.controle.login.MonitoraLogin;
import br.com.sistemas_robustos.login.model.LogInModel;
import br.com.sistemas_robustos.login.model.PessoaLoginModel;

/**
 *
 * @author felix
 */
public class Main {
    public static void main(String[] args) {
        
        
        LogInModel logInModel = new PessoaLoginModel();
        
        logInModel.addEvent(new Login(logInModel));//para login
        
        logInModel.addEvent(new FuncionarioLogin(logInModel));//para funcionario
        logInModel.addEvent(new AdminLogin(logInModel));//para admin
        
        logInModel.addEvent(new MonitoraLogin(logInModel));//para monitorar
        
        
        
    }
}
