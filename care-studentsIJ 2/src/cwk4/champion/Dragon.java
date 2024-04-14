package cwk4.champion;

import cwk4.challenge.Type;

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
    public boolean canChallenge(Type chType) {
        return chType == Type.FIGHT || (chType == Type.MYSTERY && talks);
    }
}
