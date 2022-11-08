public abstract class Supernatural {
    protected String name;
    protected int health;
    protected int damage;

    public Supernatural(){}

    public Supernatural(int damage,String name){
        this.damage=damage;
        this.name=name;
    }

    public Supernatural(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public int  attack(){
        System.out.println(this.getName()+" attacked!!");
        System.out.println(this.getDamage()+" DMG dealt 👊!");
        return this.getDamage();
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
