package HashMapLabAct11092023;
import java.util.*;

abstract class Abstraction {
	public abstract void addStudent();
	public abstract void searchStudent();
	public abstract void deleteStudent();
	public abstract void displayStudent();
}

 class StudentDirectoryList extends Abstraction {
	
	Scanner scanner = new Scanner(System.in);
	HashMap<String,String> Students = new HashMap<>();
	String studentName = "";
	String studentID = "";
	String studentMajor = "";
	
	public void addStudent() {
	    System.out.println("Enter the student's name: (Last Name, First Name, Middle Initial)");
	    studentName = scanner.nextLine().toUpperCase();
	    System.out.println("Enter the student's ID: (2022-123456)");
	    studentID = scanner.nextLine().toUpperCase();
	    System.out.println("Enter the student's major or course: (ex: BSIT - MWA)");
	    studentMajor = scanner.nextLine().toUpperCase();

	    Students.put(studentID, studentName + "|" + studentMajor);

	    System.out.println("Added Successfully!");
	    System.out.println("+---------------------------------------------------------------+");
	    System.out.println("|  STUDENT ID    |        STUDENT NAME        |  STUDENT MAJOR  |");
	    System.out.println("+---------------------------------------------------------------+");
	    System.out.printf("|%-15s|%-30s|%-16s|%n", studentID, studentName, studentMajor);
	    System.out.println("+---------------------------------------------------------------+");
	}

	public void searchStudent() {
	    System.out.println("Enter the student's ID to search: ");
	    studentID = scanner.nextLine();
	    if (Students.containsKey(studentID)) {
	        String value = Students.get(studentID);
	        String[] infoArray = value.split("\\|");
	        
	        System.out.println("Student found!");
	        System.out.println("+-----------------+-----------------------------+-----------------+");
	        System.out.printf("|  STUDENT ID     |  STUDENT NAME               |  STUDENT MAJOR   |%n");
	        System.out.println("+-----------------+-----------------------------+-----------------+");
	        System.out.printf("| %-15s | %-27s | %-15s |%n", studentID, infoArray[0], infoArray[1]);
	        System.out.println("+-----------------+-----------------------------+-----------------+");
	    } else {
	        System.out.println("Student not found!");
	    }
	}

	public void deleteStudent() {
	    System.out.println("Enter the student's ID to delete: ");
	    studentID = scanner.nextLine();
	    if (Students.containsKey(studentID)) {
	        String value = Students.get(studentID);
	        String[] infoArray = value.split("\\|");
	        Students.remove(studentID);
	        
	        System.out.println("Student deleted successfully:");
	        System.out.println("+-----------------+-----------------------------+-----------------+");
	        System.out.printf("|  STUDENT ID     |  STUDENT NAME               |  STUDENT MAJOR   |%n");
	        System.out.println("+-----------------+-----------------------------+-----------------+");
	        System.out.printf("| %-15s | %-27s | %-15s |%n", studentID, infoArray[0], infoArray[1]);
	        System.out.println("+-----------------+-----------------------------+-----------------+");
	        
	        displayStudent();
	    } else {
	        System.out.println("Student not found!");
	    }
	}

	
	public void displayStudent() {
	    System.out.println("List of Students: ");
	    System.out.println("+-----------------+-----------------------------+-----------------+");
	    System.out.println("|  STUDENT ID     |  STUDENT NAME               |  STUDENT MAJOR   |");
	    System.out.println("+-----------------+-----------------------------+-----------------+");

	    if (Students.isEmpty()) {
	        System.out.println("|        No students found. The list is empty.                 |");
	        System.out.println("+-----------------------------------------------------------------+");
	    } else {
	        for (HashMap.Entry<String, String> entry : Students.entrySet()) {
	            String studentInfo = entry.getValue();
	            String[] infoArray = studentInfo.split("\\|");

	            System.out.printf("| %-15s | %-27s | %-15s |%n", entry.getKey(), infoArray[0], infoArray[1]);
	            System.out.println("+-----------------+-----------------------------+-------------------+");
	        }
	    }
	    System.out.println("");
	}

}
 
public class StudentDirectory {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		StudentDirectoryList SDL = new StudentDirectoryList();
		
		boolean repeat;
		try {
		while (repeat = true) {
			System.out.println("+--------------------------------+");
			System.out.println("|         Hello Student!         |");
			System.out.println("+--------------------------------+");
			System.out.println("|     Select from the choices:   |");
			System.out.println("+--------------------------------+");
			System.out.println("|           1: Insert.           |");
			System.out.println("|           2: Search.           |");
			System.out.println("|           3: Delete.           |");
			System.out.println("|           4: Display.          |");
			System.out.println("|           5: Exit.             |");
			System.out.println("+--------------------------------+");
			
			int select = scanner.nextInt();
			
			switch(select) {
			case 1:
				SDL.addStudent();
				break;
			case 2:
				SDL.searchStudent();
				break;
			case 3:
				SDL.deleteStudent();
				break;
			case 4:
				SDL.displayStudent();
				break;
			case 5:
				System.out.println("Thank you for using the system!");
				System.exit(0);
				break;
			default:
				System.out.println("Out of bounds. Numbers 1-5 only. Try again!");
				break;
			}
		}
	}
	catch(InputMismatchException e) {
		System.out.println("Invalid input. You must input from the choices. Numbers 1-5 only. Try again!");
		main(args);
	}
  }

}
