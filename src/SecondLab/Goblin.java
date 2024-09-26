package SecondLab;

public class Goblin extends Monster {
    private String weapon;

    public Goblin(String name, int health, int attackPower, String weapon) {
        super(name, health, attackPower);
        this.weapon = weapon;
    }

    public Goblin() {
        this("Goblin", 50, 5, "Club");
    }

    public void attack() {
        int totalDamage = getAttackPower();
        totalDamage += weapon.length();
        System.out.println(getName() + " attacks with " + weapon + " causing " + totalDamage + " damage.");
    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        System.out.println(getName() + " takes " + damage + " damage. Remaining health: " + getHealth());
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}

