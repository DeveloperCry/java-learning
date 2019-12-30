package learning.decorator;

public class Chili extends Cook {

    @Override
    public String flavor() {
        return "辣";
    }

    @Override
    public String description() {
        return "青椒";
    }
}
