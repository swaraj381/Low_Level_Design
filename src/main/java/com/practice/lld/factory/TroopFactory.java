package com.practice.lld.factory;

public class TroopFactory {
    public static Troop createTroop(String troopName) {
        if(troopName.equalsIgnoreCase("Barbarian")){
            return new Barbarian();
        } else if(troopName.equalsIgnoreCase("Wizard")){
            return new Wizard();
        } else if(troopName.equalsIgnoreCase("Archer")){
            return new Archer();
        } else if(troopName.equalsIgnoreCase("HogRider")){
            return new HogRider();
        } else {
            throw new IllegalArgumentException("Unknown troop type: " + troopName);
        }
    }
}
