/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ceparator
 */
@Local
public interface ClientDAOInterface {

    void addClient(Client client);

    void addClientRollback(Client client);

    void addClientThrow(Client client);

    void addClientNoTrans(Client client);
    
    void addClientNewTrans(Client client);

    void deleteClient(int idClient);

    List<Client> listAllClients();

    public void flush();

}
