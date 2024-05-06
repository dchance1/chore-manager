package org.darrenchance.familychoremanager;

import entity.Chore;
import entity.ChoreType;
import entity.Room;

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
            if (typeClass.getName().equals("entity.Chore")){
                namedQueryStr = "Chore.default";
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
    public <T> List<T> listAllItems(Class<T> typeClass,int namedQuery) {
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
                if (namedQuery == Room.ROOM_BY_ID){
                    namedQueryStr = "Room.roomById";
                }else {
                    namedQueryStr = "Room.orderByName";
                }
            }
            if(typeClass.getName().equals("entity.Chore")){
                if(namedQuery == Chore.DISTINCT_ROOM){
                    namedQueryStr = "Chore.distinctRoom";
                    System.out.println("Working method");
                }
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
     * Get all chore by room id.
     * @param id the room id
     * @return a list of chores associated with the room id.
     */
    public List<Chore> getChoresByRoomId(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); //Start
            // Query to get all chores that have the specific room id.
            Query query = entityManager.createQuery("select c from  Chore c where c.roomId = "+ id);
            // Saving results to a list of chores.
            List<Chore> choreList = query.getResultList();
            transaction.commit(); //End
            return choreList;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    /**
     * Method queries choresdb database and returns the room with the parameter id
     *
     * @param id the room id
     * @return a {@code Room} associated with the associated id.
     */
    public Room getRoomById(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); //Start
            // Query to get a specific room with room id.
            Query query = entityManager.createQuery("select rm from Room rm where rm.roomId = "+ id);
            // Saving results to a Room object
            Room roomList = (Room) query.getResultList().get(0);
            transaction.commit(); //End
            return roomList;
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
            // Returning Object array with with Objects at the following indexes;
            // * index; 0 = Chore.java, 1 = ChoreType.java, 2 = User.java, 3 = Room.java
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

    /**
     * A method to persist/add/insert an abject to the choresdb as long as it is included in the 'entity' package using
     * Hibernate framework and JPA
     *
     * @param entity an object/model in the entity package that can be persisted to the choredb
     */
    public void add(Object entity) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();// Start
            Object obj = entity;
            // Adding object to database
            entityManager.persist(obj);
            transaction.commit();// End
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    /**
     * Deletes entity from choresdb by passing in the associated object entity and then using its primary key, which
     * could be an 'id' for example. It will return the amount of rows affected. Pass in an arbitrary object containing
     * the primary key, or pass in the actual object.
     *
     * @param entity an object from the choresdb.
     * @return Returns the rows affected. If no rows affected or delete unsuccessful will return 0
     */
    public int remove(Object entity) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();// Start
            Object obj = entity;// placeholder for object being passed into method
            // Delete object based on primary key and entity class.
            int rowsAffected = 0;// Reflects if item actually get's deleted or not
            if (obj.getClass().getName().equalsIgnoreCase("entity.Room")) {
                System.out.println(obj.getClass().getName());
                Room room = (Room) obj;
                // Getting primary key.
                int id = room.getRoomId();
                // Running query to delete using primary key.
                rowsAffected = entityManager.createQuery("delete from Room where id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
            }
            if (obj.getClass().getName().equalsIgnoreCase("entity.ChoreType")) {
                System.out.println(obj.getClass().getName());
                ChoreType choreType = (ChoreType) obj;
                // Getting primary key.
                int id = choreType.getChoreTypeId();
                // Running query to delete using primary key.
                rowsAffected = entityManager.createQuery("delete from ChoreType where id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
            }
            transaction.commit();// End
            // Return rowsAffected, will be zero if delete unsuccessful.
            return rowsAffected;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
