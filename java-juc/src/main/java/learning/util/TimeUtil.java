package learning.util;

import java.util.concurrent.TimeUnit;

public class TimeUtil {
    public static void timeSleep(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
