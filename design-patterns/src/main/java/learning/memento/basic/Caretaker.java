package learning.memento.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Caretaker {
//    //如果只是保存一个副本，就new一个对象就可以了
    private Memento memento = new Memento();
    //如果要保存多个副本，就用list
//    private List<Memento> mementos = new ArrayList<>();
    //如果要保存不同时间段的副本多个副本，就用map
//    private Map<String, List<Memento>> mementoMap = new HashMap<>();

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

//    public void add(Memento memento) {
//        this.mementos.add(memento);
//    }
//
//    public void get(int index) {
//        this.mementos.get(index);
//    }
}
