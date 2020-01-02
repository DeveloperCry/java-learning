package learning.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
    private List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        this.observers.add(observer);
    }

    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(final String name, final String newProduct) {
//        this.observers.parallelStream().forEach(observer -> observer.update(name, newProduct));
        this.observers.stream().forEach(observer -> observer.update(name, newProduct));
    }
}
