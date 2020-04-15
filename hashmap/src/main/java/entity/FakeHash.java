package entity;

public class FakeHash {

    private int value;

    public FakeHash(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return this.value & 7;
    }

    public int getValue() {
        return value;
    }
}
