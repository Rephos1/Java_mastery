package cwk4.challenge;

public class Challenge {
    private int challengeNo;
    private Type type;
    private String enemyName;
    private int skillRequired;
    private int reward;


    public Challenge(String enemyName, Type type, int challengeNo, int skillRequired, int reward) {
        this.enemyName = enemyName;
        this.type = type;
        this.challengeNo = challengeNo;
        this.skillRequired = skillRequired;
        this.reward = reward;
    }

    public int getChallengeNo() {
        return challengeNo;
    }

    public Type getType() {
        return type;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getSkillRequired() {
        return skillRequired;
    }

    public int getReward() {
        return reward;
    }
}
