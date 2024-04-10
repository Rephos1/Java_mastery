package cwk4.champion;

public class Wizard extends Champion {
    private boolean necromancer;
    private SpellSpecialities spellSpeciality;

    public Wizard(String name, int skillLevel, int entryFee, boolean necromancer,SpellSpecialities spellSpeciality) {
        super(name, skillLevel, entryFee);
        this.necromancer = necromancer;
        this.spellSpeciality = spellSpeciality;
    }

    public boolean isNecromancer() {
        return this.necromancer;
    }

    public SpellSpecialities getSpellSpeciality() {
        return this.spellSpeciality;
    }
}
