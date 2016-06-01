/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO2;

import Model2.Bank;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ceparator
 */
@Local
public interface BankDAOInterface {

    void addBank(Bank bank);

    void addBankRollback(Bank bank);

    void addBankThrow(Bank bank);

    void addBankNoTrans(Bank bank);

    void addBankNewTrans(Bank bank);

    void deleteBank(int idBank);

    List<Bank> listAllBanks();

    public void flush();
}
