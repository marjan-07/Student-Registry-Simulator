import java.util.Scanner;

/**
 * @author Marjan Ahmed
 */
public class StudentRegistrySimulator 
{
	public static void main(String[] args) 
	{
		Registry registry = new Registry();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		while (scanner.hasNextLine()) 
		{
			String inputLine = scanner.nextLine();
			if (inputLine != null) 
			{
				Scanner commandLine = new Scanner(inputLine);
				if (commandLine.hasNext()) 
				{
					String command = commandLine.next();

					if (!(command == null || command.equals(""))) 
					{
						if (command.equalsIgnoreCase("L")
							|| command.equalsIgnoreCase("LIST")) 
						{
							registry.printAllStudents();
						} 
						else if (command.equalsIgnoreCase("Q")|| command.equalsIgnoreCase("QUIT"))
						{
							return;
						}
						else if (command.equalsIgnoreCase("REG")) 
						{
							// register a new student in registry
							// get name and student id string
							// e.g. reg JohnBoy 74345
							String name = commandLine.next();
							if (commandLine.hasNext()) 
							{
								String id = commandLine.next();

								// Checks:
								//  ensure name is all alphabetic characters
								//  ensure id string is all numeric characters
								if (isStringOnlyAlphabet(name) && isValidId(id)) 
								{
									registry.addNewStudent(name, id);
								} 
								else if (!isStringOnlyAlphabet(name))
								{
									System.out.println("Invalid characters in Name");
								}
								else
								{
									System.out.println("Invalid ID");
								}
							}
							
						} 
						else if (command.equalsIgnoreCase("DEL")) 
						{
							// delete a student from registry
							// get student id
							String id = commandLine.next();
							// ensure numeric
							if (isValidId(id)) 
							{
								// remove student from registry
								registry.removeStudent(id);
							} 
							else 
							{
								System.out.println("Invalid ID");
							}
						} 
						else if (command.equalsIgnoreCase("ADDC")) 
						{
							// add a student to an active course
							// get student id and course code strings
							String id = commandLine.next();
							if (isValidId(id)) 
							{
								if (commandLine.hasNext()) 
								{
									String code = commandLine.next();
									// add student to course (see class Registry)
									registry.addCourse(id, code);
								}
							} 
								else 
								{
									System.out.println("Invalid ID");
								}
						} 
						else if (command.equalsIgnoreCase("DROPC")) 
						{
							// get student id and course code strings
							String id = commandLine.next();

							if (isValidId(id)) 
							{
								if (commandLine.hasNext()) 
								{
									String code = commandLine.next();
									// drop student from course (see class Registry)
									registry.dropCourse(id, code);
								}
							} 
							else 
							{
								System.out.println("Invalid ID");
							}
						} 
						else if (command.equalsIgnoreCase("PAC")) 
						{
							// print all active courses
							registry.printActiveCourses();
						} 
						else if (command.equalsIgnoreCase("PCL")) 
						{
							// get course code string
							String courseCode = commandLine.next();

							// print class list (i.e. students) for this course
							registry.printClassList(courseCode);
						} 
						else if (command.equalsIgnoreCase("PGR"))
						{
							// get course code string
							String courseCode = commandLine.next();

							// print name, id and grade of all students in active course
							registry.printGrades(courseCode);
						} 
						else if (command.equalsIgnoreCase("PSC")) 
						{
							// get student id string
							String id = commandLine.next();

							if (isValidId(id)) 
							{
								// print all credit courses of student
								registry.printStudentCourses(id);
							} 
							else 
							{
								System.out.println("Invalid ID");
							}
						} 
						else if (command.equalsIgnoreCase("PST")) 
						{
							// get student id string
							String id = commandLine.next();

							if (isValidId(id)) 
							{
								// print student transcript
								registry.printStudentTranscript(id);
							} 
							else 
							{
								System.out.println("Invalid ID");
							}
						} 
						else if (command.equalsIgnoreCase("SFG")) 
						{
							// set final grade of student
							// get course code, student id, numeric grade
							String courseCode = commandLine.next();

							if (commandLine.hasNext()) 
							{
								String id = commandLine.next();

								if (isValidId(id)) 
								{
									if (commandLine.hasNextDouble()) 
									{
										double grade = commandLine.nextDouble();
										// use registry to set final grade of this student (see class Registry)
										registry.setFinalGrade(courseCode, id, grade);
									}
								} 
								else 
								{
									System.out.println("Invalid ID");
								}
							}
						} 
						else if (command.equalsIgnoreCase("SCN")) 
						{
							// get course code
							String courseCode = commandLine.next();
							// sort list of students in course by name (i.e. alphabetically)
							registry.sortCourseByName(courseCode);
							// see class Registry							
						} 
						else if (command.equalsIgnoreCase("SCI")) 
						{
							// get course code
							String courseCode = commandLine.next();
							// sort list of students in course by student id
							registry.sortCourseById(courseCode);
							// see class Registry
						} 
						else 
						{
							System.out.println("Command is invalid");
						}
					}
				}
			}

			System.out.print("\n>");
		}
	}

	
	 // @param str
	 // @return whether string contains only alphabetic characters
	 
	private static boolean isStringOnlyAlphabet(String str) 
	{
		// write method to check if string str contains only alphabetic characters
		return str.chars().allMatch(Character::isLetter);
	}

	
	 // @param str
	 // @return if string contains only digits
	 
	public static boolean isNumeric(String str) 
	{
		// write method to check if string str contains only numeric characters
		return str.chars().allMatch(Character::isDigit);
	}

	 // Another method that checks whether string id is valid, meaning all numberic and length=5
	 // @param id
	 // @return if string is a valid student id
	
	private static boolean isValidId(String id) 
	{
		return isNumeric(id) && id.length() == 5;
	}
}