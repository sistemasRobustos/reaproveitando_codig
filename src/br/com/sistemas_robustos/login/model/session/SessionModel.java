/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemas_robustos.login.model.session;

/**
 * Essa class vai ser responsavel por retornar os modelos usado no sistema para
 * efetuar e validar as operações NO BANDO DE DADOS.
 *
 * 
 * Na implementação desse deve ser iniciado todos os modelos que serão usados no sistema.
 * Ao tempo de cada um, e permanecer o tempo que for necessario pro sistema ficar de pé.
 * 
 * 
 * @author felix
 */
public interface SessionModel {

    public final String PRODUTO_LIST_CRUD = "0";
    
    public final String BUSQUE_SERVICO = "1";
    
    public final String CLIENTE_MODEL = "2";//ClienteModel
    
    public final String CARRO_MODEL = "3";//CarroListModel
    
    public final String SERVICO_TABLE = "4";//ServicoTableModelSelecion
    
    public final String ORDEM_FUNCOES_BASICA = "5";//FuncoesBasicaCadastro
    
    public final String CAIXA_MODEL = "6";//caixaModel
    
    public final String LOG_ACESSO = "7";//LogAcesso
    
    public final String SELECION_TROCO = "8";//LogAcesso
    
    public final String SELECION_SANGRIA = "9";//LogAcesso
    
    
    
    /**
     * 
     * @param <T>
     * @param key
     * @return o modelo correspondente a chave informada.
     */
    public <T>T getModel(String key) throws Exception;
    
    /**
     * informa que deve ser resetado se 
     * possivel tudo desse modelo para fazer logOF
     */
    public void close();
}
