/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunDAO;

import DAO.ClientDAOInterface;
import DAO2.BankDAOInterface;
import Model.Client;
import Model2.Bank;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ceparator
 */
@Stateless
public class ItsFriday implements ItsFridayInterface {

    @EJB
    private ClientDAOInterface clientDAO;

    @EJB
    private BankDAOInterface bankDAO;

    @Override
    public void experiment1(Client client, Bank bank) {
        clientDAO.addClient(client);
        bank.setClientName(client.getName());
        bankDAO.addBank(bank);
    }

    @Override
    public void experiment2(Client client, Bank bank) {
        clientDAO.addClient(client);
        bank.setClientName(client.getName());
        bankDAO.addBankRollback(bank);
    }

    @Override
    public void experiment3(Client client, Bank bank) {
        clientDAO.addClientThrow(client);
        bank.setClientName(client.getName());
        bankDAO.addBank(bank);
    }

    @Override
    public void experiment4(Client client, Bank bank) {
        clientDAO.addClientNoTrans(client);
        bank.setClientName(client.getName());
        bankDAO.addBankRollback(bank);
    }

    @Override
    public void experiment5(Client client, Bank bank) {
        clientDAO.addClientNewTrans(client);
        bank.setClientName(client.getName());
        bankDAO.addBankThrow(bank);
    }
}
