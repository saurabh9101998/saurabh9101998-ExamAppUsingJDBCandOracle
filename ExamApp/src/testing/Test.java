package testing;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Exam;
import entity.User;
import operations.ExamOperations;

public class Test {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		String choice;

		User user = new User();
		Exam exam = new Exam();
		ExamOperations examOperations= new ExamOperations();
		examOperations.acceptUserDetails(user);
		examOperations.saveUserDetails(user);
		examOperations.printQuestion();
		examOperations.saveResult(exam, user.getUid());
		System.out.println("Would you like to see your report\nPress 1 for yes, 2 for no!");
		int ch=scanner.nextInt();
		switch(ch) {
		case 1:System.out.println("Displaying result");
			   examOperations.displayResult(user.getUid());
			break;
		case 2:System.out.println("Thank you");
			break;
		}
		
		
				
	}

}
