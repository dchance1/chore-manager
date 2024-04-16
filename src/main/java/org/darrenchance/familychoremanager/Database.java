package org.darrenchance.familychoremanager;

import javax.persistence.*;
import java.util.List;

public class Database {

    /**
     * A method to outputs all items or entities using the specified {@code Object} class name.
     *
     * @param typeClass the class of the entity you would like to list
     * @return List of {@code Object} class name
     */

    public <T> List<T> listAllItems(Class<T> typeClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            if(!typeClass.getPackageName().equals("entity")){
                return null;
            }
            transaction.begin(); //Start
            Query query = entityManager.createQuery("from " + typeClass.getName());
            @SuppressWarnings("unchecked") List<T> resultList = query.getResultList();
            transaction.commit();
            return resultList;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void add(Object entity) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Object obj = entity;
            System.out.println("The class name being persisted is: "+entity.getClass().getName());
            entityManager.persist(obj);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}
