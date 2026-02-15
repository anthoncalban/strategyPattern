// Attack Strategy Interface
interface AttackStrategy {
    void attack();
}

interface DefenseStrategy {
    void defend();
}

class SwingSword implements AttackStrategy {
    public void attack() {
        System.out.println("Knight attacks with a sword!");
    }
}

class CastSpell implements AttackStrategy {
    public void attack() {
        System.out.println("Wizard casts a spell!");
    }
}

class ShootArrow implements AttackStrategy {
    public void attack() {
        System.out.println("Archer shoots an arrow!");
    }
}

class Shield implements DefenseStrategy {
    public void defend() {
        System.out.println("Using a shield to defend!");
    }
}

class Dodge implements DefenseStrategy {
    public void defend() {
        System.out.println("Dodging to avoid attack!");
    }
}

class CreateMagic implements DefenseStrategy {
    public void defend() {
        System.out.println("Creating a magic barrier for defense!");
    }
}

abstract class Character {
    protected AttackStrategy attackStrategy;
    protected DefenseStrategy defenseStrategy;

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void setDefenseStrategy(DefenseStrategy defenseStrategy) {
        this.defenseStrategy = defenseStrategy;
    }

    public void attack() {
        attackStrategy.attack();
    }

    public void defend() {
        defenseStrategy.defend();
    }
}

class Knight extends Character {
    public Knight() {
        this.attackStrategy = new SwingSword();
    }

    @Override
    public void defend() {
        new Shield().defend();
        new Dodge().defend();
        new CreateMagic().defend();
    }
}

class Wizard extends Character {
    public Wizard() {
        this.attackStrategy = new CastSpell();
        this.defenseStrategy = new CreateMagic();
    }
}

class Archer extends Character {
    public Archer() {
        this.attackStrategy = new ShootArrow();
        this.defenseStrategy = new Dodge();
    }
}

public class GameApp {
    public static void main(String[] args) {
        Character knight = new Knight();
        knight.attack();
        knight.defend();

        Character wizard = new Wizard();
        wizard.attack();
        wizard.defend();

        Character archer = new Archer();
        archer.attack();
        archer.defend();
    }
}
