package cwk4.champion;

import cwk4.challenge.Type;

import java.io.Serializable;

public class Warrior extends Champion implements Serializable {
    private Weapons weapon;

    public Warrior(String name, int skillLevel, int entryFee, Weapons weapon) {
        super(name, skillLevel, entryFee);
        this.weapon = weapon;
    }

    public Weapons getWeapon() {
        return this.weapon;
    }

    @Override
    public boolean canChallenge(Type chType) {
        return chType == Type.FIGHT;
    }
}
