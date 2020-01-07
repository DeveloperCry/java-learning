package learning.memento.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样以后就可将该对象恢复到原先保存的状态
 *
 * 这是一个最原始的备忘录模式：
 *     Level是需要被备份的原始类；记得里面一定会有创建和恢复备份的方法
 *     Memento是用来备份的类，需要哪些属性就备份哪些属性
 *     Caretaker是执行者，用于协调备份，根据不同的需求用不同的数据结构来备份
 *
 * 核心：被备份类中的创建和恢复备份的方法，Caretaker类备忘录管理员
 *
 * 缺点：如果频繁地备份，会使得内存消耗特别的快
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Memento {
    private int id;
    private String map;
    private String role;
}
