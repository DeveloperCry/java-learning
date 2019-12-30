package learning.decorator;

public class Meat extends Cook {
    @Override
    public String flavor() {
        return "肉香";
    }

    @Override
    public String description() {
        return "猪肉";
    }
}
