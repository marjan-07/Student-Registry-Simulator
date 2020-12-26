/**
 * @author Marjan Ahmed
 */
public class Course 
{
	private String name;
	private String code;
	private String description;
	private String format;

	public Course() 
	{
		this.name = "";
		this.code = "";
		this.description = "";
		this.format = "";
	}

	public Course(String name, String code, String description, String format) 
	{
		this.name = name;
		this.code = code;
		this.description = description;
		this.format = format;
	}

	public String getCode() 
	{
		return code;
	}

	public String getName() 
	{
		return name;
	}

	public String getFormat() 
	{
		return format;
	}

	/**
	 * @return the full course info
	 */
	public String getDescription() 
	{
		return code + " - " + name + "\n" + description + "\n" + format;
	}

	/**
	 * @return the course description
	 */
	public String getDescr() 
	{
		return description;
	}

	/**
	 * @return the course code and name
	 */
	public String getInfo() 
	{
		return code + " - " + name;
	}

	// static method to convert numeric score to letter grade string
	// e.g. 91 --> "A+"
	public static String convertNumericGrade(double score) 
	{
		String Grade=null;
		if (score>=90)
		{
			return "A+";
		}
		else if (score>=85 && score<=89)
		{
			return "A";
		}
		else if (score>=80 && score<=84)
		{
			return "A-";
		}
		else if (score>=77 && score<=79)
		{
			return "B+";
		}
		else if (score>=73 && score<=76)
		{
			return "B";
		}
		else if (score>=70 && score<=72)
		{
			return "B-";
		}
		else if (score>=67 && score<=69)
		{
			return "C+";
		}
		else if (score>=63 && score<=66)
		{
			return "C";
		}
		else if (score>=60 && score<=62)
		{
			return "C-";
		}
		else if (score>=57 && score<=59)
		{
			return "D+";
		}
		else if (score>=53 && score<=56)
		{
			return "D";
		}
		else if (score>=50 && score<=52)
		{
			return "D-";
		}
		else if (score>=0 && score<=49)
		{
			return "F";
		}
		else
		{
			Grade="Error";
		}
		return Grade;
	}
}
/**
 * @author Marjan Ahmed, 500944059
 */
public class Course 
{
	private String name;
	private String code;
	private String description;
	private String format;

	public Course() 
	{
		this.name = "";
		this.code = "";
		this.description = "";
		this.format = "";
	}

	public Course(String name, String code, String description, String format) 
	{
		this.name = name;
		this.code = code;
		this.description = description;
		this.format = format;
	}

	public String getCode() 
	{
		return code;
	}

	public String getName() 
	{
		return name;
	}

	public String getFormat() 
	{
		return format;
	}

	/**
	 * @return the full course info
	 */
	public String getDescription() 
	{
		return code + " - " + name + "\n" + description + "\n" + format;
	}

	/**
	 * @return the course description
	 */
	public String getDescr() 
	{
		return description;
	}

	/**
	 * @return the course code and name
	 */
	public String getInfo() 
	{
		return code + " - " + name;
	}

	// static method to convert numeric score to letter grade string
	// e.g. 91 --> "A+"
	public static String convertNumericGrade(double score) 
	{
		String Grade=null;
		if (score>=90)
		{
			return "A+";
		}
		else if (score>=85 && score<=89)
		{
			return "A";
		}
		else if (score>=80 && score<=84)
		{
			return "A-";
		}
		else if (score>=77 && score<=79)
		{
			return "B+";
		}
		else if (score>=73 && score<=76)
		{
			return "B";
		}
		else if (score>=70 && score<=72)
		{
			return "B-";
		}
		else if (score>=67 && score<=69)
		{
			return "C+";
		}
		else if (score>=63 && score<=66)
		{
			return "C";
		}
		else if (score>=60 && score<=62)
		{
			return "C-";
		}
		else if (score>=57 && score<=59)
		{
			return "D+";
		}
		else if (score>=53 && score<=56)
		{
			return "D";
		}
		else if (score>=50 && score<=52)
		{
			return "D-";
		}
		else if (score>=0 && score<=49)
		{
			return "F";
		}
		else
		{
			Grade="Error";
		}
		return Grade;
	}
}
