package SecondLab;

public class Mermaid extends Monster {
    private boolean canSing;

    public Mermaid(String name, int health, int attackPower, boolean canSing) {
        super(name, health, attackPower);
        this.canSing = canSing;
    }

    public Mermaid() {
        this("Mermaid", 70, 8, true);
    }

    public void attack() {
        int damage = getAttackPower();

        // Увеличиваем урон, если русалка умеет петь
        if (canSing) {
            damage += 15;
            System.out.println(getName() + " uses her voice to mesmerize and attacks causing " + damage + " damage.");
        } else {
            System.out.println(getName() + " attacks causing " + damage + " damage.");
        }
    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        System.out.println(getName() + " takes " + damage + " damage. Remaining health: " + getHealth());
    }


    public boolean getCanSing() {
        return canSing;
    }

    public void setCanSing(boolean canSing) {
        this.canSing = canSing;
    }
}

