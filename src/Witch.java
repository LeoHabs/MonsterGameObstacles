public class Witch extends Supernatural implements Strikeable {

    public Witch() {
        super("WITCH", 8, 3);
    }

    @Override
    public void sufferDamage(int damageDealt) {
        this.health=this.health-(damageDealt/2);
    }


}
