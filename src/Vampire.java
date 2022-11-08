public class Vampire extends Monster{

    public Vampire() {
        super("Vampire", 9, 2);
    }

    @Override
    public int attack() {
        System.out.println(this.getName()+" attacked!!");
        System.out.println(this.getDamage()+" DMG dealt!");
        int chance=(int) Math.floor(Math.random()*4);
        if(chance==3){
            System.out.println("The vampire sucked some blood earning +2HP❤️");
            this.setHealth(this.getHealth()+2);
        }
        return this.getDamage();
    }

    @Override
    public void sufferDamage(int damageDealt) {
        this.setHealth(this.getHealth()-damageDealt);
        System.out.println(this.getName()+" lost "+damageDealt+" HP ❤️!");
    }
}
