package org.darrenchance.familychoremanager;

import entity.Chore;
import entity.ChoreType;

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
        String namedQueryStr = "";
        //String orderBy = "";
        try {
            // Ensures that only entity classes will return anything
            if (!typeClass.getPackageName().equals("entity")) {
                return null;
            }
            // Default ordering for query results based on entity
            if (typeClass.getName().equals("entity.ChoreType")) {
                namedQueryStr = "ChoreType.orderByName";
            }
            if (typeClass.getName().equals("entity.Room")) {
                namedQueryStr = "Room.orderByName";
            }
            if (typeClass.getName().equals("entity.User")) {
                namedQueryStr = "User.orderByName";
            }
            transaction.begin(); //Start
            // Run query
            Query query = entityManager.createNamedQuery(namedQueryStr);
            @SuppressWarnings("unchecked") List<T> resultList = query.getResultList();
            transaction.commit(); //End
            return resultList;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void joinTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {

            transaction.begin(); //Start

            //String jpql = "SELECT c FROM Chore c LEFT JOIN FETCH c.choreTypesByChoreTypeId";

            //Query query = entityManager.createQuery("from ");
            //TypedQuery<Chore> q = entityManager.createQuery(jpql, Chore.class);

//            q.getResultList().forEach(o -> System.out.println(((Chore) o[0]).getIsActive() +
//                    "Chore: " + ((ChoreType) o[1]).getChoreName()));
            //String jpql = "SELECT c,ct FROM Chore c LEFT JOIN ChoreType ct ON c.choreTypeId = ct.choreTypeId";
            String jpql = "SELECT c, ct FROM Chore c left join fetch ChoreType ct ON c.choreTypeId = ct.choreTypeId";
            TypedQuery<Object[]> q = entityManager.createQuery(jpql, Object[].class);

            //q.getResultList().forEach(o -> System.out.println(((Chore)  o[0] ).getChoreTypesByChoreTypeId().getChoreTypeDescription()));

            q.getResultList().forEach(o -> System.out.println(((Chore) o[0]).getChoreId()
                    + " Username: " + ((ChoreType) o[1]).getChoresByChoreTypeId()));


            //q.getResultList().forEach(o -> System.out.println( o.getUsersByUserId().getUsername()));
            transaction.commit(); //End
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
            System.out.println("The class name being persisted is: " + entity.getClass().getName());
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
