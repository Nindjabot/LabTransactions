/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunDAO;

import Model2.Bank;
import Model.Client;
import javax.ejb.Local;

/**
 *
 * @author Ceparator
 */
@Local
public interface ItsFridayInterface {

    void experiment1(Client client, Bank bank);

    void experiment2(Client client, Bank bank);

    void experiment3(Client client, Bank bank);

    void experiment4(Client client, Bank bank);

    void experiment5(Client client, Bank bank);
    
}
