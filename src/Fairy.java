public class Fairy extends Supernatural{
    private String name;
    private int damage;

    public Fairy() {
        super(4, "Fairy");
    }

    public int  attack(){
        System.out.println(this.name+" attacked!!");
        System.out.println(this.damage+" DMG dealt 👊!");
        return this.damage;

    };

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
