package org.darrenchance.familychoremanager;

import entity.Chore;
import entity.Reward;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        List<Reward> rewardList = db.listAllItems(Reward.class);
        List<Chore> choreList = db.listAllItems(Chore.class);
        System.out.println("-".repeat(26));

        System.out.println("Rewards Table");
        System.out.println("-".repeat(26));
        for (Reward reward : rewardList) {
            System.out.printf("{title: " + reward.getTitle() + "},");
            System.out.printf("{title: " + reward.getItemDescription() + "}");
            System.out.println(reward);
        }
        System.out.println("-".repeat(26));


        System.out.println("Chores Table");
        System.out.println("-".repeat(26));
        for(Chore chore: choreList){
            System.out.printf("{title: " + chore.getTitle() + "},");
            System.out.printf("{chore: " + chore.getDescription() + "}");
            System.out.println(chore);
        }
        System.out.println("-".repeat(26));

        Reward reward = new Reward();
        reward.setTitle("1 hr extra screen time");
        reward.setItemDescription("You get 1 hour of extra screen time to use for the day.");

        db.add(reward);

        db.add(new Chore());
    }






}
