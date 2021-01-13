package lab4.objectmodel;


import org.springframework.beans.factory.annotation.Autowired;

public class Fire implements Bullets {
    private final int bulletsDamage = 40;
    private final SpaceCraft target;
    private final Location location;
    private boolean isActive = false;
    @Autowired
    private Weapon weapon;

    Fire(SpaceCraft target, Location location) {
        this.target = target;
        this.location = location;
        this.isActive = true;
        this.target.getUnderFire(this, this.location);
    }

    public void hit(int bullets) {
        if (bullets == 1) {
            System.out.println("Пуля ударила ракету.");
        } else if (bullets < 5) {
            System.out.println(bullets + " пули ударили ракету.");
        } else {
            System.out.println(bullets + " пуль ударило ракету.");
        }
        int bullets_failed = 0;
        while ((this.target.getDurability(this.location) >= 0) && (bullets - bullets_failed > 0)) {
            this.target.applyDamage(this.location, this.bulletsDamage);
            bullets_failed += 1;
        }

        if (this.target.getDurability(this.location) > 0) {
            System.out.println("Пуля не смогла пробить прочную оболочку из материала: " + this.target.getCorpusMaterial().toString() + ".");
        } else {
            System.out.println("Пуля пробила оболочку" + this.location.toString());
        }
        System.out.println("Послышался звонкий удар.");

        if (!this.target.isUnderGravity) {
            System.out.println("Воздействие пули особо ощутимо из-за невесомости.");
            this.target.flinch();
        }
    }

    public String toString() {
        return "обстрел";
    }


}
