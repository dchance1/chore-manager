package org.darrenchance.familychoremanager;

import javax.persistence.*;
import java.util.List;

public class Database {

    /**
     * A method that outputs all items or entities using the specified {@code Object} class name.
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

    /**
     * Returns chores from a table joined from entities Chore, ChoreType, Room, User.
     *
     * @return Returns an {@code Object[]} with Objects at the following indexes;
     * index; 0 = Chore.java, 1 = ChoreType.java, 2 = User.java, 3 = Room.java at
     */
    public List<Object[]> getAllChores() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); //Start
            // Query joining tables and running query returniing Object[]
            String jpql = "SELECT c, ct, u,r FROM Chore c left join ChoreType ct ON c.choreTypeId = ct.choreTypeId " +
                    "left join User u ON c.userId = u.id left join Room r ON c.roomId = r.roomId order by r.roomName ASC, u.username ";
            TypedQuery<Object[]> q = entityManager.createQuery(jpql, Object[].class);
            transaction.commit(); //End
            return q.getResultList();
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
