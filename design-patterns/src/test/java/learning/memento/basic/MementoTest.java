package learning.memento.basic;

import org.junit.Test;

public class MementoTest {
    @Test
    public void testMemento() {
        //第一关
        Level level = new Level(1, "地图1", "李白");
        System.out.println("第一关：" + level.toString());
        //闯关成功，备份
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(level.createMemento());

        //进入第二关
        level = new Level(2, "地图2", "百里守约");
        System.out.println("第二关：" + level.toString());
        //闯关失败，恢复第一关
        level.restoreFromMemento(caretaker.getMemento());
        System.out.println("恢复到第一关：" + level.toString());

    }
}
