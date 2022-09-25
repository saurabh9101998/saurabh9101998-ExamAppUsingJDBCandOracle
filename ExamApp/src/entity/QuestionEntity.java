package entity;

public class QuestionEntity {
	private int question_id;
	private String question;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private String user_ans;
	
	
	public QuestionEntity() {
		this.question_id = 0;
		this.question = "";
		this.op1 = "";
		this.op2 = "";
		this.op3 = "";
		this.op4 = "";
		this.user_ans ="";
	}


	public int getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getOp1() {
		return op1;
	}


	public void setOp1(String op1) {
		this.op1 = op1;
	}


	public String getOp2() {
		return op2;
	}


	public void setOp2(String op2) {
		this.op2 = op2;
	}


	public String getOp3() {
		return op3;
	}


	public void setOp3(String op3) {
		this.op3 = op3;
	}


	public String getOp4() {
		return op4;
	}


	public void setOp4(String op4) {
		this.op4 = op4;
	}


	public String getUser_ans() {
		return user_ans;
	}


	public void setUser_ans(String user_ans) {
		this.user_ans = user_ans;
	}

}
