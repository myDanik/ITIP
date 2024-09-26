package SecondLab;

public abstract class Monster {
    private String name;
    private int health;
    private int attackPower;
    private static int monsterCount = 0;

    public Monster(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        monsterCount++;
    }

    public Monster() {
        this("Unnamed Monster", 100, 10);
    }

    public abstract void attack();
    public abstract void takeDamage(int damage);

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

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public static int getMonsterCount() {
        return monsterCount;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Health: " + health + ", Attack Power: " + attackPower);
    }
}
