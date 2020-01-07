package learning.memento.clone;

public class Caretaker {
//    //如果只是保存一个副本，就new一个对象就可以了
    private Level memento = new Level();
    //如果要保存多个副本，就用list
//    private List<Level> mementos = new ArrayList<>();
    //如果要保存不同时间段的副本多个副本，就用map
//    private Map<String, List<Level>> mementoMap = new HashMap<>();

    public Level getMemento() {
        return memento;
    }

    public void setMemento(Level memento) {
        this.memento = memento;
    }

//    public void add(Level memento) {
//        this.mementos.add(memento);
//    }
//
//    public void get(int index) {
//        this.mementos.get(index);
//    }
}
