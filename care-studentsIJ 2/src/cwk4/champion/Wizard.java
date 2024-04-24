package cwk4.champion;

import cwk4.ChallengeType;

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
    public boolean canChallenge(ChallengeType chType) {
        return true;
    }
    @Override
    public String toString() {
        String parentString = super.toString();
        return "\nCharacter: Wizard -> " + parentString + "\nSpell Speciality : " + this.spellSpeciality + "\nIs Necromancer: " + this.necromancer ;
    }
}
