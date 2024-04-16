package org.darrenchance.familychoremanager;

import entity.Chore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    /**
     * Testing if a non entity class is passed as param it will return null
     */
    @Test
    void listAllItemsNonEntityTest() {

        Database db = new Database();

        // Adding non entity classes to list
        List<Class> classes = new ArrayList();
        classes.add(Integer.class);
        classes.add(String.class);
        classes.add(Database.class);
        classes.add(Double.class);

        // Testing that all non classes return null as expected
        for (Class cl : classes) {
            assertEquals(null, db.listAllItems(cl));
        }
    }
}