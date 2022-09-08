package lab8;
/**
 * <p>Title: Lab8App</p>
 *
 * <p>Description:</p>
 *
 * @author Kyunghoon Oh
 */

public class Lab8App {
	/**
	 * <p> Name: main method </p>
	 * 
	 * @param args values to be sent to the method
	 */
	public static void main(String[] args)
	{
		Student student;		
		student = new Student();
		Student student1 = new Student("123456789", "Jane", "Doe", new double[] {98.5, 76.5, 79.0, 84.0});
		
		
		
		System.out.println("Testing default constructor: " + "\n" + student.toString() + "\n");
		
		
		System.out.println("Testing parameterized constructor: " + "\n" + student1.toString() + "\n");
		student1.setStudentId("987654321");
		System.out.println("Setting Jane Doe's id: " + "\n" + student1.toString() + "\n");
		student1.setGrades(new double[] {98.5, 95.0, 79.0, 84.0});
		System.out.println("Setting Jane Doe's second exam: " + "\n" + student1.toString() + "\n");
		System.out.println("Getting the student id for Jane Doe:" + "\n" + "Id is " + student1.getStudentId() + "\n");
		System.out.println("Getting the first name for Jane Doe: " + "\n" + "First name "
				+ "is " + student1.getFirstName() + "\n");
		System.out.println("Getting the last name for Jane Doe: " + "\n" + "Last name "
				+ "is " + student1.getLastName() + "\n");
		String str = "";
		double[] grades = student1.getGrades();	
		for (int i = 0; i < grades.length; i++)
			str += grades[i] + " ";
		System.out.println("Getting Jane Doe's grades: " + "\n" + str + "\n");
		System.out.println("Getting the array position of the lowest exam:"
				+ "\n" + "Lowest exam is at position " + student1.findLowestExam() + "\n"); 
		
		System.out.println("Calculating the average without dropping the lowest exam:" +
		    "\n" + student1.calcExamAverage(false) + "\n");
		System.out.println("Calculating the average after dropping the lowest exam:" + 
		    "\n" + student1.calcExamAverage(true));
			
		
		
	  

	
			
		
		
				
		
	
		
		
		
		
		
		
	}
	

}
