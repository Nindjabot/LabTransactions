/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.ClientDAOInterface;
import Model.Client;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import org.icefaces.ace.model.table.RowStateMap;

/**
 *
 * @author Ceparator
 */
@Named(value = "clientBean")
@RequestScoped
public class ClientBean {

    @EJB
    private ClientDAOInterface clientDAO;

    private RowStateMap stateMap;

    public RowStateMap getStateMap() {
        return stateMap;
    }

    public void setStateMap(RowStateMap stateMap) {
        this.stateMap = stateMap;
    }

    public void actionListener(ActionEvent event) throws Exception {
        List<Client> selectedClientList = (List<Client>) stateMap.getSelected();
        for (Client client1 : selectedClientList) {
             clientDAO.deleteClient(client1.getIdClient());
        }
    }

    public List<Client> getAllClients() throws Exception {
        return clientDAO.listAllClients();
    }
}
