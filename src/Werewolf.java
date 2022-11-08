public class Werewolf extends Monster{
    public Werewolf() {
        super("Werewolf", 10, 4);
    }

    @Override
    public void sufferDamage(int damageDealt) {
        this.setHealth(this.getHealth()-damageDealt);
        System.out.println(this.getName()+" lost "+damageDealt+" HP ❤️!");
    }
}
