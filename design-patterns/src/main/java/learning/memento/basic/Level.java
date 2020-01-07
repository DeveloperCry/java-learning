package learning.memento.basic;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Level {
    private int id;
    private String map;
    private String role;

    public Memento createMemento() {
        return new Memento(id, map, role);
    }

    public void restoreFromMemento(Memento memento) {
        this.id = memento.getId();
        this.map = memento.getMap();
        this.role = memento.getRole();
    }
}
