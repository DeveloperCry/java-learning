/**
 * 
 */
package learning;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Xiong.Liu
 *
 */
public class APITest {
	public static void main(String[] args) {
		//get the fist day and start time of current month
		LocalDateTime firstOfMonth = LocalDate
				.now()
				.atStartOfDay()
				.with(TemporalAdjusters.firstDayOfMonth());
		
		System.out.println(firstOfMonth);
	}
}
