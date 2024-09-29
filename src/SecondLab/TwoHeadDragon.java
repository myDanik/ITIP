package SecondLab;

public class TwoHeadDragon extends Dragon {
    private int coldDamage;

    public TwoHeadDragon(String name, int health, int attackPower, int fireDamage, int coldDamage) {
        super(name, health, attackPower, fireDamage);
        this.coldDamage = coldDamage;
    }

    public TwoHeadDragon() {
        super();
        this.coldDamage = 15;
    }

    @Override
    public void attack() {
        int totalDamage = getAttackPower() + getFirePower() + coldDamage;
        System.out.println(getName() + " breathes fire causing " + getFirePower() +
                " breathes fire causing " + coldDamage + ". Total damge: " + totalDamage);
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        System.out.println(getName() + " takes " + damage + " damage. Remaining health: " + getHealth());
    }

    public int getColdPower() {
        return coldDamage;
    }

    public void setColdPower(int coldPower) {
        this.coldDamage = coldPower;
    }
}
