package lab4.objectmodel;

public abstract class SpaceCraft extends PhysicalObject {

    protected int posY = 0;
    protected int posX = 0;
    protected int deviationAngle = 0;
    private Material corpusMaterial = Material.STEEL;
    private Corpus corpus;

    SpaceCraft() {
        super(false);
        this.corpus = new Corpus(this.corpusMaterial);
    }

    public void applyDamage(Location location, int damage) {
        this.corpus.durability[location.getIndex()] -= damage;
    }

    public int getDurability(Location location) {
        return this.corpus.durability[location.getIndex()];
    }

    public abstract void flinch();

    public abstract void getUnderFire(Fire fire, Location location);

    public Material getCorpusMaterial() {
        return this.corpusMaterial;
    }

    public class Corpus {
        private int[] durability = new int[5];

        Corpus(Material corpusMaterial) {
            for (int i = 0; i < 5; i++) {
                durability[i] = corpusMaterial.getDurability();
            }
        }

        public int getDurability(Location location) {
            return this.durability[location.getIndex()];
        }
    }
}
