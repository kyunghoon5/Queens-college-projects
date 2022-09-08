package lab8;
/**
 * <p>Title: Writing the student Class</p>
 *
 * <p>Description:practice loop and the array,</p>
 *
 * @author Kyunghoon Oh
 */
public class Student
{
	private String studentId;
	private String firstName;
	private String lastName;
	private double[] grades;
	// instance variables
	
	

	
	/** 
	 * default constructor
	 * the id, first and last names are initialized to "none"
	 * the array is instantiated to store 4 elements - each element is
	 * initialized to -1.0
	 */
	public Student()
	{
		studentId = "none";
		firstName = "none";
		lastName = "none";
		grades = new double[4];
		for(int i = 0; i < grades.length; i++)
			grades[i] = -1.0;	
		
	}
	
	

	
	/** 
	 * parameterized constructor
	 * stores the parameters into the appropriate instance variables
	 * @param sId the value to be stored in the instance variable studentId
	 * @param sFirstName the value to be stored in the instance variable firstName
	 * @param sLastName the value to be stored in the instance variable lastName
	 * @param sExams the address of the array whose values will be copied into the 
	 * instance variable grades
	 */
	public Student(String sId, String sFirstName, String sLastName, double[] sExams)
	{
		studentId = sId;
		firstName = sFirstName;
		lastName = sLastName;
		grades = new double[4];
		for(int i = 0; i < sExams.length; i++)
			grades[i] = sExams[i];
		
	}

	
	/**
	 * setStudentId - mutator method for studentId
	 * stores the parameter into the instance variable
	 * @param sId the value to be stored in the instance variable studentId
	 */
	public void setStudentId(String sId)
	{
		this.studentId = sId;
	}
	

	
	/**
	 * setGrades - mutator method for grades
	 * stores the parameter into the instance variable
	 * @param sExams the address of the array whose values will be copied into the 
	 * instance variable grades
	 */
	public void setGrades(double[] sExams)
	{
		for(int i = 0; i < grades.length; i++)
			grades[i] = sExams[i];		
	}

	
	/**
	 * getStudentId - accessor method for id
	 * @return a reference to the instance variable id
	 */
	public String getStudentId()
	{
		return studentId;
	}
	 
 
 
 	/**
	 * getFirstName - accessor method for firstName
	 * @return a reference to the instance variable firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}


	/**
	 * getLastName - accessor method for lastName
	 * @return a reference to the instance variable lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	
	/**
	 * getGrades - accessor method for grades
	 * @return a reference to a copy of the instance variable grades
	 */
	public double[] getGrades()
	{
		double[] gradesCopy = new double[grades.length];
		for(int i = 0; i < grades.length; i++)
			gradesCopy[i] = grades[i];
		return gradesCopy;
	}

	
	/**
	 * findLowestExam - find the lowest exam score in the array and returns its location 
	 * in the array
	 * @return lowest grade
	 */
	public int findLowestExam()
	{		
		double lowestExam = grades[0];
		//lowest starts at first number in array
		int min = 0;		
		//min starts at - as if first number
		//in Array happens to be the lowest, its index will be one
		
		for (int i = 1; i < grades.length; i++)			
			//u can also start with i = 1
			//since u initialize lowestexam
			//with the first element
			if (grades[i] < lowestExam)				
			{							
				lowestExam = grades[i];
				min = i;				
			}			
		return min;			
	}

	
	/**
	 * calcExamAverage - calculates the average of the exams in one of two ways 
	 * if the parameter is true, the lowest exam score is dropped in 
	 * calculating the average
	 * if the parameter is false, no exams are dropped in the calculating
	 * the average
	 * @param drop - a boolean variable to specify whether or not to drop the lowest score
	 * @return the average of the exams
	 */
	public double calcExamAverage(boolean drop)
	{
		if(drop != true)
		{
			double sum = 0;
			for (int i = 0; i < grades.length; i++)
            {
				sum += grades[i];
            }
			return sum / grades.length;
		}
		else
		{
			double exam = grades[0];
			double sum = 0;
			for (int i = 0; i < grades.length; i++)
			{
				sum += grades[i];
			}
			for (int i = 0; i < grades.length; i++)
				if (grades[i] < exam)
				{
					exam = grades[i];
				}
			return (sum - exam) / 3;
		}
	}
	
		
		
			
		
		
		
			
			
		
	
	

	
	/**
	 * toString - create and return a String with the instance variable values
	 * @return a reference to a String containing the id, first and last names
	 * and the exam grades
	 */
	public String toString()
	{
		String str = "";
		for (int i = 0; i < grades.length; i++)
			str += grades[i] + " "; 
		return "Id: " + studentId + "\n" + "Name: " + lastName + ", " + firstName + "\n" + "Grades: " + str;
	}
	
}
