package lab4.objectmodel;

public interface Physics {
    void fall();

    void hit(PhysicalObject target);

    void flinch();
}
