package org.darrenchance.familychoremanager;

import entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        List<Room> rooms = db.listAllItems(Room.class);
        for (Room rm : rooms) {
            System.out.println("Room: " + rm.getRoomName() + ", Room ID: " + rm.getRoomId());
        }

        List distinctRoomIds = Collections.singletonList(db.listAllItems(Chore.class, Chore.DISTINCT_ROOM)).get(0);
        ArrayList<Integer> roomIds = (ArrayList<Integer>) distinctRoomIds;
        for(Integer id: roomIds){
            // create a query to get all chores for 'i' which is roomId
            // This will grab every chore for every room
            System.out.println("--- Room ID: " + id + " ---");
            List<Chore> ch = db.getChoresByRoomId(id);
            for(Chore c: ch){
                System.out.println("Chore id: "+c.getChoreId()+ ", Chore NameID: "+
                        c.getChoreTypesByChoreTypeId().getChoreName());
            }

        }
        for(Chore ch: db.listAllItems(Chore.class)){
            System.out.println(ch.getChoreTypesByChoreTypeId());

        }
        Room newRoom = db.getRoomById(1);

        System.out.println(newRoom.getRoomName());

        // comments

    }
}
