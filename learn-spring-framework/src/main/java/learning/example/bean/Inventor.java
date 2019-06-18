/**
 * 
 */
package learning.example.bean;

import java.util.Date;

/**
 * @author Xiong.Liu
 *
 */
public class Inventor {
	
	private String name;
	private Date birthday;
	private String nationality;
	/**
	 * @param name
	 * @param birthday
	 * @param nationality
	 */
	public Inventor(String name, Date birthday, String nationality) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.nationality = nationality;
	}
	/**
	 * Gets name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets name the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets birthday
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * Sets birthday the birthday
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * Gets nationality
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * Sets nationality the nationality
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
