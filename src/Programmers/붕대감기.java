package Programmers;

public class 붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks){
        int t = bandage[0]; // 연속 성공 시간
        int x = bandage[1];
        int y = bandage[2];

        int maxHealth = health;
        int success = 0;

        int attackIndex = 0;
        int lastTime = attacks[attacks.length-1][0];

        for(int time = 1; time <= lastTime; time++){
            // 공격 시간
            if(attackIndex < attacks.length && time == attacks[attackIndex][0]){
                health -= attacks[attackIndex][1];
                success = 0;
                attackIndex++;

                if(health <= 0){
                    return -1;
                }
            } else {
                success++;
                health += x;

                if(success == t){
                    health += y;
                    success = 0;
                }

                if(health > maxHealth){
                    health = maxHealth;
                }
            }
        }

        return health;
    }
}
