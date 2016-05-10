/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique.dao;

import herique.entity.Testes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hdias
 */
public class TestesDao {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private static TestesDao instance;

    public TestesDao() {

    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public static TestesDao getInstance() {
        if (instance == null) {
            instance = new TestesDao();
        }
        if (instance.getFactory() == null) {
            instance.setFactory(Persistence.createEntityManagerFactory("pu"));
        }
        if (instance.getManager() == null || !instance.getManager().isOpen()) {
            instance.setManager(instance.getFactory().createEntityManager());
        }

        return instance;
    }

    public static void setInstance(TestesDao instance) {
        TestesDao.instance = instance;
    }

    public List getAll() {
        List lst;
        manager.getTransaction().begin();
        lst = manager.createQuery("SELECT t FROM Testes t").getResultList();
        manager.close();

        return lst;
    }

    public Testes getByUserPass(String user, String pass) {
        Testes t = null;
        manager.getTransaction().begin();

        Query q = manager.createQuery("SELECT t FROM Testes t WHERE t.name = :name AND t.email = :email");
        q.setParameter("name", user);
        q.setParameter("email", pass);
        
        if(!q.getResultList().isEmpty()){
            t = (Testes) q.getSingleResult();
        }
        manager.close();
        return t;
    }
}
