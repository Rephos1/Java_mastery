package cwk4.champion;

public class Warrior extends Champion {
    private Weapons weapon;

    public Warrior(String name, int skillLevel, int entryFee, Weapons weapon) {
        super(name, skillLevel, entryFee);
        this.weapon = weapon;
    }

    public Weapons getWeapon() {
        return this.weapon;
    }
}
