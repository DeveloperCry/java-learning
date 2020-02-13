package learning.thread.synccontainer;

import lombok.Getter;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class SyncContainer {

    // 线程安全
    private List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
    private Set<Long> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
    private Map<Long, Long> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    private Hashtable<Long, Long> hashTable = new Hashtable<>();
    private Vector<Integer> vector = new Vector<>();
    // 采用的是分段锁技术
    private ConcurrentHashMap<Long, Long> concurrentHashMap = new ConcurrentHashMap<>();

    private ConcurrentSkipListMap<Long, Long> concurrentSkipListMap = new ConcurrentSkipListMap<>();
    private ConcurrentSkipListSet<Long> concurrentSkipListSet = new ConcurrentSkipListSet<>();
    private CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();
    private CopyOnWriteArraySet<Long> copyOnWriteArraySet = new CopyOnWriteArraySet();

    // 线程不安全
    private List<Integer> commonList = new ArrayList<>();
    private Set<Long> commonSet = new HashSet<>();
    private Map<Long, Long> commonMap = new HashMap<>();

    private Long count = 0L;

    private ReentrantLock lock = new ReentrantLock();

    public void addCommonList(int i) {
        commonList.add(i);
    }

    public void addCommonSet() {
        commonSet.add(this.getCount());
    }

    public void addCommonMap() {
        commonMap.put(this.getCount(), this.getCount());
    }

    public void addHashTable() {
        hashTable.put(this.getCount(), this.getCount());
    }

    public void addVector(int i) {
        vector.add(i);
    }

    public void addConcurrentHashMap() {
        concurrentHashMap.put(this.getCount(), this.getCount());
    }

    public void addConcurrentSkipListMap() {
        concurrentSkipListMap.put(this.getCount(), this.getCount());
    }

    public void addConcurrentSkipListSet() {
        concurrentSkipListSet.add(this.getCount());
    }

    public void addCopyOnWriteArrayList(int num) {
        copyOnWriteArrayList.add(num);
    }

    public void addCopyOnWriteArraySet() {
        copyOnWriteArraySet.add(this.getCount());
    }

    public void addSynchronizedSet() {
        synchronizedSet.add(this.getCount());
    }

    public void addSynchronizedMap() {
        synchronizedMap.put(this.getCount(), this.getCount());
    }

    public void addSynchronizedList(int i) {
        synchronizedList.add(i);
    }

    private Long getCount() {
        try {
            lock.lock();
            return count ++;
        } finally {
            lock.unlock();
        }

    }
}
