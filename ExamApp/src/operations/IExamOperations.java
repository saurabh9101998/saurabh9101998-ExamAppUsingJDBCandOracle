package operations;

import java.sql.SQLException;

public interface IExamOperations {
	void acceptUserDetails();
	void saveUserDetails();
	void printQuestion() throws SQLException;
	void enterAnswer();
	void saveResult();
	void displayResult();

}
