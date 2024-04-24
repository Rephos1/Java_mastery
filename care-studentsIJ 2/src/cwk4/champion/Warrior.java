package cwk4.champion;

import cwk4.ChallengeType;

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
    public boolean canChallenge(ChallengeType chType) {
        return chType == ChallengeType.FIGHT;
    }
    @Override
    public String toString() {
        String parentString = super.toString();
        return "\nCharacter: Warrior -> " + parentString + "\nWeapon is: " + this.weapon;
    }
}
