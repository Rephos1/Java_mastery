package cwk4.champion;

import cwk4.challenge.Type;

import java.io.Serializable;

public class Wizard extends Champion implements Serializable {
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

    @Override
    public boolean canChallenge(Type chType) {
        return true;
    }
}
