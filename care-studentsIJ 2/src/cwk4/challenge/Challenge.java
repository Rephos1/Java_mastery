package cwk4.challenge;

import cwk4.ChallengeType;

import java.io.Serializable;

public class Challenge implements Serializable {
    private int challengeNo;
    private ChallengeType type;
    private String enemyName;
    private int skillRequired;
    private int reward;


    public Challenge(String enemyName, ChallengeType type, int challengeNo, int skillRequired, int reward) {
        this.enemyName = enemyName;
        this.type = type;
        this.challengeNo = challengeNo;
        this.skillRequired = skillRequired;
        this.reward = reward;
    }

    public int getChallengeNo() {
        return challengeNo;
    }

    public ChallengeType getType() {
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

    @Override
    public String toString(){
        return getChallengeNo() + " " + getType() + " " + getEnemyName() + " " + getSkillRequired() + " " + getReward();
    }
}
