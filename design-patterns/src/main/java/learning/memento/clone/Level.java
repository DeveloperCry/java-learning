package learning.memento.clone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 这个是一个与原型模式结合的备忘录模式
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Level implements Cloneable{
    private int id;
    private String map;
    private String role;

    public Level createMemento() {
        return (Level) this.clone();
    }

    public void restoreFromMemento(Level memento) {
        this.id = memento.getId();
        this.map = memento.getMap();
        this.role = memento.getRole();
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
        }
        return null;
    }
}
