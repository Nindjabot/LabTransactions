/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import FunDAO.ItsFridayInterface;
import Model2.Bank;
import Model.Client;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ceparator
 */
@Named(value = "megaBean")
@RequestScoped
public class MegaBean {

    @EJB
    private ItsFridayInterface funDAO;

    private Bank bank;
    private Client client;

    @PostConstruct
    private void initializeBean() {
        client = new Client();
        bank = new Bank();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String experiment_number_uno() {
        funDAO.experiment1(client, bank);
        return "/index.xhtml";
    }

    public String experiment_number_2() {
        funDAO.experiment2(client, bank);
        return "/index.xhtml";
    }

    public String experiment_number_3() {
        funDAO.experiment3(client, bank);
        return "/index.xhtml";
    }

    public String experiment_number_4() {
        funDAO.experiment4(client, bank);
        return "/index.xhtml";
    }

    public String experiment_number_5() {
        funDAO.experiment5(client, bank);
        return "/index.xhtml";
    }
}
