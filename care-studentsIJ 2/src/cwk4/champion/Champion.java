package cwk4.champion;

import cwk4.ChampionState;

public class Champion {
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
        return this.skillLevel;
    }

    public int getEntryFee() {
        return this.entryFee;
    }

    public ChampionState getState() {
        return this.state;
    }

    public void setState(ChampionState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return name + " (skill: " + skillLevel + ", entryFee: " + entryFee + ", state: " + state + ")";
    }
}
