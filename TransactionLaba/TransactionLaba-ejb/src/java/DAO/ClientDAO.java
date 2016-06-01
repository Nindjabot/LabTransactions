/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Client;
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
public class ClientDAO implements ClientDAOInterface {

    @PersistenceContext(unitName = "TransactionLaba-ejbPU1")
    private EntityManager em;
    
    @Resource
    private SessionContext cx;

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public List<Client> listAllClients() {
        Query query = em.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    @Override
    public void addClient(Client client) {
        em.persist(client);
    }

    @Override
    public void deleteClient(int idClient) {
        Client client = em.getReference(Client.class, idClient);
        em.remove(client);
    }

    @Override
    public void addClientRollback(Client client) {
        em.persist(client);
        //em.getTransaction().setRollbackOnly();
        cx.setRollbackOnly();
    }

    @Override
    public void addClientThrow(Client client) {
        em.persist(client);
        throw new EJBException("Not so fun exception");
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void addClientNoTrans(Client client) {
        em.persist(client);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addClientNewTrans(Client client) {
        em.persist(client);
    }

}
