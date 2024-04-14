package cwk4.champion;

import cwk4.ChampionState;
import cwk4.challenge.Type;

import java.io.Serializable;

public class Champion implements Serializable {
    protected String name;
    protected int skillLevel;
    protected int entryFee;
    protected ChampionState state;

    public Champion(String name, int skillLevel,int entryFee) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.entryFee = entryFee;
        this.state = ChampionState.WAITING;
    }

    public String getName() {
        return this.name;
    }

    public int getSkillLevel() {
        if(this instanceof Dragon) {
            return 7;
        } else if(this instanceof Warrior) {
            return getEntryFee()/100;
        }
        return this.skillLevel;
    }

    public int getEntryFee() {
        if(this instanceof Wizard wizard) {
            if(wizard.isNecromancer()) {
                return 400;
            }
            return 300;
        } else if(this instanceof Dragon dragon) {
            return 500;
        }
        return this.entryFee;
    }

    public ChampionState getState() {
        return this.state;
    }

    public void setState(ChampionState state) {
        this.state = state;
    }

    public boolean canChallenge(Type chType) {
        // the base champion cannot fight
        return false;
    }

    @Override
    public String toString() {
        return name + " (skill: " + skillLevel + ", entryFee: " + entryFee + ", state: " + state + ")";
    }
}
