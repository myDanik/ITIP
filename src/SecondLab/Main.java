package SecondLab;

public class Main {
    public static void main(String[] args) {
        Goblin goblin = new Goblin();
        Mermaid mermaid = new Mermaid();
        Dragon dragon = new Dragon();
        TwoHeadDragon dragon1 = new TwoHeadDragon("Jakiro", 150, 30, 20, 11);
        Goblin other_goblin = new Goblin("Goblin", 80, 15, "Sword");
        Mermaid other_mermaid = new Mermaid("Mermaid", 90, 12, false);
        Dragon other_dragon = new Dragon("Dragon", 150, 30, 20);

        goblin.printInfo();
        mermaid.printInfo();
        dragon.printInfo();
        dragon1.printInfo();

        goblin.attack();
        mermaid.attack();
        dragon.attack();
        dragon1.attack();

        goblin.takeDamage(10);
        mermaid.takeDamage(15);
        dragon.takeDamage(20);
        dragon1.takeDamage(25);


        System.out.println("Total monsters created: " + Monster.getMonsterCount());
    }
}

