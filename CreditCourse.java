/**
 * @author Marjan Ahmed
 */

public class CreditCourse extends Course 
{
	// add a constructor method with appropriate parameters
	// should call the super class constructor
	// this is like a record
	// Student, CreditCourse
	private String semester;
	public double grade;
	public boolean active;

	public CreditCourse(String name, String code, String description, String format, String semester, double grade) 
	{
		// add code
		super(name, code, description, format);
		this.semester = semester;
		this.grade = grade;
	}

	/**
	 * @return whether this course is active
	 */
	public boolean getActive() 
	{
		return active;
	}

	/**
	 * Make this course active.
	 */
	public void setActive() 
	{
		active = true;
	}

	/**
	 * Make this course inactive.
	 */
	public void setInactive() 
	{
		active = false;
	}

	/**
	 * @return the grade of the student in this course
	 */
	public double getGrade() 
	{
		return grade;
	}

	/**
	 * @return the info about this course plus which semester and the grade achieved
	 */
	public String displayGrade() 
	{
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		return super.getInfo() + " " + semester + " Grade: " + convertNumericGrade(grade);
	}
}