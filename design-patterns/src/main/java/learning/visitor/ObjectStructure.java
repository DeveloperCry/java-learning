package learning.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<AbstractHouse> houses = new ArrayList<>();

    public void attach(AbstractHouse house) {
        houses.add(house);
    }

    public void detach(AbstractHouse house) {
        houses.remove(house);
    }

    public void display(final AbstractVisitor visitor) {
        this.houses.forEach(house -> house.accept(visitor));
    }
}
