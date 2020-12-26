import java.util.ArrayList;
import java.util.Objects;
/**
 * @author Marjan Ahmed
 */

  //Make class Student implement the Comparable interface
  //Two student objects should be compared by their name
 
public class Student 
{
	private String name;
	private String id;
	public ArrayList<CreditCourse> courses;


	public Student(String name, String id) 
	{
		this.name = name;
		this.id = id;
		courses = new ArrayList<CreditCourse>();
	}

	public String getId() 
	{
		return id;
	}

	public String getName() 
	{
		return name;
	}

	 // New method created 
	 // @param courseCode
	 // @return the course with the code if this student is or was enrolled in it;
	 
	 
	public CreditCourse getCreditCourse(String courseCode) 
	{
		for (CreditCourse credc: courses) 
		{
			if (credc.getCode().equalsIgnoreCase(courseCode)) 
				return credc;
		}
		return null;
	}

	// add a credit course to list of courses for this student
	public void addCourse(String courseName, String courseCode, String description, String format,String semester, double grade) 
	{
		// create a CreditCourse object
		CreditCourse addc = new CreditCourse(courseName, courseCode, description, format, semester, grade);

		// set course active
		addc.setActive();

		// add to courses array list
		courses.add(addc);
	}


	// Prints a student transcript
	// Prints all completed (i.e. non active) courses for this student (course code, course name,
	// semester, letter grade
	// see class CreditCourse for useful methods
	public void printTranscript() 
	{
		for (CreditCourse credc: courses) 
		{
			if (!credc.getActive()) 
			{
				System.out.println(credc.displayGrade());
			}
				
		}
	}

	// Prints all active courses this student is enrolled in
	// see variable active in class CreditCourse
	public void printActiveCourses() 
	{
		for (CreditCourse credc: courses) 
		{
			System.out.println(credc.getDescription());
			System.out.println();
		}
	}

	// Drop a course (given by courseCode)
	// Find the credit course in courses arraylist above and remove it
	// only remove it if it is an active course
	public void removeActiveCourse(String code) 
	{
		courses.removeIf(creditCourse -> creditCourse.getCode().equalsIgnoreCase(code) && !creditCourse.getActive());
	}

	public String toString() 
	{
		return "Student ID: " + id + " Name: " + name;
	}

	// override equals method inherited from superclass Object
	// if student names are equal *and* student ids are equal (of "this" student
	// and "other" student) then return true
	// otherwise return false
	// Hint: you will need to cast other parameter to a local Student reference variable
	public boolean equals(Object other) 
	{
		Student student = (Student) other;
		if (this == other)
		{
			return true;
		}
		if (other == null || getClass() != other.getClass())
		{
			return false;
		}
		return name.equals(student.name) && id.equals(student.id);
	}

	// Additional method which sets the final grade 
	// @param code
	// @param grade
	 
	public void setFinalGrade(String code, double grade) 
	{
		for (CreditCourse credc: courses) 
		{
			if (credc.getCode().equalsIgnoreCase(code)) 
			{
				credc.grade = grade;
				credc.setInactive();
			}
		}
	}
}
