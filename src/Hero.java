public class Hero {

    private int hitPoints;
    private String name;

    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        String status = "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
        return status;
    }

    public void attack(Hero opponent){
        double attackChance = Math.random();
        if(attackChance < 0.5) opponent.hitPoints -= 10;
        else hitPoints -= 10;
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while(hitPoints!=0 && opponent.getHitPoints()!=0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        String result = name + ": " + hitPoints + "   " + opponent.getName() + ": " + opponent.getHitPoints();
        return result;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int fights = 0;
        int[] results = {0,0};
        while(fights < n){
            fightUntilTheDeathHelper(opponent);
            if(hitPoints == 0){
                senzuBean();
                results[0]++;
                fights++;
            } else if(opponent.getHitPoints() == 0){
                opponent.senzuBean();
                results[1]++;
                fights++;
            }
        }
        return results;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int[] results = nFightsToTheDeathHelper(opponent, n);
        String output1 = name + ": " + results[0] + " wins.\n";
        String output2 = opponent + ": " + results[1] + " wins.\n";
        String output3 = null;
        if(results[0]>results[1]) output3 = name + " wins!\n";
        else if (results[0]<results[1]) output3 = opponent + " wins!\n";
        else output3 = "It's a draw!\n";
        String outputActual = output1 + output2 + output3;
        return outputActual;
    }

    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        while(opponent.getHitPoints()!=0 && hitPoints!=0){
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "    " + opponent.getName() + ": " + opponent.getHitPoints());
            Thread.sleep(1000);
        }
    }



}

