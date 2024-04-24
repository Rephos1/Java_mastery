package cwk4.champion;

import cwk4.ChallengeType;

import java.io.Serializable;

public class Dragon extends Champion implements Serializable {
    private boolean talks;

    public Dragon(String name, int skillLevel, int entryFee, boolean talks) {
        super(name, skillLevel, entryFee);
        this.talks = talks;
    }
    public boolean isTalks() {
        return this.talks;
    }

    @Override
    public boolean canChallenge(ChallengeType chType) {
        return chType == ChallengeType.FIGHT || (chType == ChallengeType.MYSTERY && talks);
    }

    @Override
    public String toString() {
        String parentString = super.toString();
        return "\nCharacter: Dragon -> " + parentString + "\nIt can talk: " + this.talks;
    }
}
