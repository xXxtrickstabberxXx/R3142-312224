package lab4.objectmodel;

public interface Controls {

    boolean stabilityCheck();

    void speedRise(int increase);

    void rotationMechanism(int angle);

    void descension(int lowerY);

    boolean fireCheck();

    void breakDown();

    void recovery();


}
