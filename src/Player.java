import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Monster> myMonsters= new ArrayList<Monster>();

    public Player(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMonster(int choice){
        switch (choice) {
            case 1:
               Werewolf werewolf=new Werewolf();
               myMonsters.add(werewolf);
                break;
            case 2:
                Vampire vampire= new Vampire();
                myMonsters.add(vampire);
                break;
            case 3:
                Mummy mummy=new Mummy();
                myMonsters.add(mummy);
                break;
            default:
                System.out.println("That monster doesn't exist...or does he?");
                break;
        }
    }

    public void seeMonsters(){
        System.out.println(this.name+" SUPERNATURAL TEAM:");
        for (int i = 0; i <this.myMonsters.size(); i++) {
            System.out.println(this.myMonsters.get(i).getName()+" |❤️: "+this.myMonsters.get(i).getHealth()+"HP | 👊: "+this.myMonsters.get(i).getDamage()+" DMG");
        }
    }

    public int numberOfMonsters(){
        return this.myMonsters.size();
    }

    public ArrayList<Monster> getMyMonsters() {
        return myMonsters;
    }

    public void setMyMonsters(ArrayList<Monster> myMonsters) {
        this.myMonsters = myMonsters;
    }

    public void checkMonsters(){
        for (int i = 0; i <this.myMonsters.size(); i++) {
            if(this.myMonsters.get(i).getHealth()<0){
                System.out.println(this.name+"'s " +this.myMonsters.get(i).getName()+" succumbed in battle!");
                this.myMonsters.remove(i);
                i--;
            }
        }
    }

    public void win(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(this.name);
        System.out.println(" __    __  _____   __  __     \n" +
                "/\\ \\  /\\ \\/\\  __`\\/\\ \\/\\ \\    \n" +
                "\\ `\\`\\\\/'/\\ \\ \\/\\ \\ \\ \\ \\ \\   \n" +
                " `\\ `\\ /'  \\ \\ \\ \\ \\ \\ \\ \\ \\  \n" +
                "   `\\ \\ \\   \\ \\ \\_\\ \\ \\ \\_\\ \\ \n" +
                "     \\ \\_\\   \\ \\_____\\ \\_____\\\n" +
                "      \\/_/    \\/_____/\\/_____/\n" +
                "                              \n" +
                "                              ");
        System.out.println(" __      __  ______   __  __     \n" +
                "/\\ \\  __/\\ \\/\\__  _\\ /\\ \\/\\ \\    \n" +
                "\\ \\ \\/\\ \\ \\ \\/_/\\ \\/ \\ \\ `\\\\ \\   \n" +
                " \\ \\ \\ \\ \\ \\ \\ \\ \\ \\  \\ \\ , ` \\  \n" +
                "  \\ \\ \\_/ \\_\\ \\ \\_\\ \\__\\ \\ \\`\\ \\ \n" +
                "   \\ `\\___x___/ /\\_____\\\\ \\_\\ \\_\\\n" +
                "    '\\/__//__/  \\/_____/ \\/_/\\/_/\n" +
                "                                 \n" +
                "                                 ");
    }
}
