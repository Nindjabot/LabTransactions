/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO2;

import Model2.Bank;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ceparator
 */
@Stateless
public class BankDAO implements BankDAOInterface {

    @PersistenceContext(unitName = "TransactionLaba-ejb2PU")
    private EntityManager em;
    
    @Resource
    private SessionContext cx;

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public List<Bank> listAllBanks() {
        Query query = em.createQuery("SELECT b FROM Bank b", Bank.class);
        return query.getResultList();
    }

    @Override
    public void addBank(Bank bank) {
        em.persist(bank);
    }

    @Override
    public void addBankRollback(Bank bank) {
        em.persist(bank);
        //em.getTransaction().setRollbackOnly();
        cx.setRollbackOnly();
    }

    @Override
    public void deleteBank(int idBank) {
        Bank bank = em.getReference(Bank.class, idBank);
        em.remove(bank);
    }

    @Override
    public void addBankThrow(Bank bank) {
        em.persist(bank);
        throw new EJBException("Not so fun exception");
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void addBankNoTrans(Bank bank) {
        em.persist(bank);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addBankNewTrans(Bank bank) {
        em.persist(bank);
    }

}
