/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;


import DAO2.BankDAOInterface;
import Model2.Bank;
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
@Named(value = "bankBean")
@RequestScoped
public class BankBean {

    @EJB
    private BankDAOInterface bankDAO;

    private RowStateMap stateMap;

    public RowStateMap getStateMap() {
        return stateMap;
    }

    public void setStateMap(RowStateMap stateMap) {
        this.stateMap = stateMap;
    }

    public void actionListener(ActionEvent event) throws Exception {
        List<Bank> selectedBankList = (List<Bank>) stateMap.getSelected();
        for (Bank bank1 : selectedBankList) {
            bankDAO.deleteBank(bank1.getIdBank());
        }
    }

    public List<Bank> getAllBanks() throws Exception {
        return bankDAO.listAllBanks();
    }
}
