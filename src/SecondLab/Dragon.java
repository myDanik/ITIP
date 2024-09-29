package SecondLab;

public class Dragon extends Monster {
    private int firePower;

    public Dragon(String name, int health, int attackPower, int firePower) {
        super(name, health, attackPower);
        this.firePower = firePower;
    }

    public Dragon() {
        this("Dragon", 150, 20, 50);
    }
    @Override
    public void attack() {
        int totalDamage = getAttackPower() + firePower;
        System.out.println(getName() + " breathes fire causing " + totalDamage + " damage.");
    }
    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        System.out.println(getName() + " takes " + damage + " damage. Remaining health: " + getHealth());
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }
}


