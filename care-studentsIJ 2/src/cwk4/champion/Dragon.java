package cwk4.champion;

public class Dragon extends Champion {
    private boolean talks;

    public Dragon(String name, int skillLevel, int entryFee, boolean talks) {
        super(name, skillLevel, entryFee);
        this.talks = talks;
    }
    public boolean isTalks() {
        return this.talks;
    }
}
