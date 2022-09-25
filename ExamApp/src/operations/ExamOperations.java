package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import entity.User;
import entity.QuestionEntity;
import entity.Exam;

public class ExamOperations implements IExamOperations {
	private static int idIncrement = 1;
	private static int eidIncrement=1;
	Scanner scanner = new Scanner(System.in);
	int score;
	String name;
	
	public void acceptUserDetails(User user) {
		user.setUid(idIncrement);
		idIncrement=idIncrement+1;
		System.out.println("Enter your name");
		user.setName(scanner.next());
		System.out.println("Enter your mobile number");
		user.setMobile(scanner.nextInt()) ;
		System.out.println("Enter your city");
		user.setCity(scanner.next()); 

	}

	public void saveUserDetails(User user) throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1st step
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
			String str = "insert into user_details values" + "(" + user.getUid() + "," + "'" + user.getName() + "'" + ","
					+ user.getMobile() + "," + "'" + user.getCity() + "'" + ")";
			Statement st = con.createStatement();
			st.executeUpdate(str);
			System.out.println("User Registered\nYour user id is "+user.getUid()+"\nTest begins");
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void printQuestion() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //1st step
			// driver name
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			//1521:orcl  the command select name from v$database
			//type of driver
			//1521 port number,xe : express edition,hr:user,hr:password
			//
			
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from question_bank");
			
			while(rs.next()) {
				System.out.print(rs.getInt(1)+". ");
				System.out.print(rs.getString(2)+"\n");
				System.out.println("Q1 "+rs.getString(3));
				System.out.println("Q2 "+rs.getString(4));
				System.out.println("Q3 "+rs.getString(5));
				System.out.println("Q4 "+rs.getString(6));
				System.out.println("Enter your choice");
				int temp=scanner.nextInt();
				temp=temp+2;
				enterAnswer(rs.getString(temp), rs.getInt(1));
			}
			
			//System.out.println("Values entered");
			st.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void enterAnswer(String user_ans,int question_id) throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //1st step
			// driver name
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			
			String str="update question_bank set user_ans='"+user_ans+"'"+" where question_id="+question_id;
			Statement st=con.createStatement();
			st.executeUpdate(str);
			System.out.println("Answer submitted");
			st.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void saveResult(Exam exam,int user_id) throws SQLException {
		exam.setExam_id(eidIncrement);
		eidIncrement++;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //1st step
			// driver name
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");			
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from question_bank where correct_ans=user_ans");
			
			
			while(rs.next()) {
			score=rs.getInt(1);
			}
			
				
			String str = "insert into exam values" + "(" + exam.getExam_id() + "," + user_id  + ",("+
					"select sysdate from dual"+"),"+ score + ")";
			//String str = "insert into exam(exam_id,user_id,score) values" + "(" + exam.getExam_id() + "," + user_id  + ","
			//+ score + ")";
			
			st.executeUpdate(str);
			
			//System.out.println("Values entered");
			st.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void displayResult(int uid) throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //1st step
			// driver name
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from exam where user_id="+uid);
			int eid=0;
			int score;
			
			
			while(rs.next()) {
				eid=rs.getInt(1);
				String date= rs.getString(3);
				score=rs.getInt(4);
				System.out.println("Exam id= "+eid+" User id = "+uid+" Score = "+score+" exam date= "+date);
			}
			
			
			//System.out.println("Values entered");
			st.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void acceptUserDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUserDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterAnswer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveResult() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayResult() {
		// TODO Auto-generated method stub
		
	}
	}
	


		



