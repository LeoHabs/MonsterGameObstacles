public class Mummy extends Monster{


    public Mummy() {
        super( "Mummy", 12, 1);
    }

    @Override
    public int attack() {
        int damage=0;
        int attacksChance=(int) Math.floor(Math.random()*3+1);
        System.out.println(this.getName()+" attacked!!");
        System.out.println(this.getDamage()*attacksChance+" DMG dealt!");
        for (int i = 1; i <attacksChance+1; i++) {
            damage+=1;
            if(i==3){
                this.setHealth(this.getHealth()-3);
                System.out.println("The Mummy unrolled and lost 3 HP ❤️ because of it");
                return damage;
            }

        }
        return damage ;
    }

    @Override
    public void sufferDamage(int damageDealt) {
        this.setHealth(this.getHealth()-damageDealt);
        System.out.println(this.getName()+" lost "+damageDealt+" HP ❤️!");
    }
}
