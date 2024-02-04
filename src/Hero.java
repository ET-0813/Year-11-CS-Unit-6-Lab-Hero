public class Hero {

    public String name;
    public int hitPoints;

    public Hero(String name){
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
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent){
        double atk = Math.random();
        if(atk < 0.5){
            opponent.hitPoints -= 10;
        }
        hitPoints -= 10;
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while(hitPoints > 0 && opponent.hitPoints > 0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "  " + opponent.name + ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){

        int[] a = new int[2];
        int x = 0;
        int y = 0;
        int z = 0;

        while(z < n){
            fightUntilTheDeathHelper(opponent);
            if(hitPoints <= 0){
                senzuBean();
                x++;
                a[1] = x;
            }
            else if (opponent.hitPoints <= 0){
                opponent.senzuBean();
                y++;
                a[0] = y;
            }
            z++;
        }
        return a;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int[] array = nFightsToTheDeathHelper(opponent, n);
        String str = name + ": " + array[0] + " wins\n" + opponent.name + ": " + array[1] + " wins";
        if(array[0] == array[1]){
            str += "\nOMG! It was actually a draw!";
        }
        else if (array[0] > array[1]){
            str += "\n" + name + " wins!";
        }
        else {
            str += "\n" + opponent.name + " wins!";
        }

        return str;
    }

    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        senzuBean();
        fightUntilTheDeathHelper(opponent);

        while(hitPoints > 0 && opponent.hitPoints > 0){

            System.out.println(name + ": " + hitPoints + "  " + opponent.name + ": " + opponent.hitPoints);
            Thread.sleep(1000);


        }

        if(hitPoints <= 0){

            System.out.println(opponent.name + " wins!");

        } else if(opponent.hitPoints <= 0){

            System.out.println(name + " wins!");

        }

    }

}
