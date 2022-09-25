package entity;

public class Exam {
	
	private int exam_id;
	private int use_id;
	//private String exam_date;
	private int score;
	
	public int getExam_id() {
		return exam_id;
	}

	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}

//	public String getExam_date() {
//		return exam_date;
//	}
//
//	public void setExam_date(String exam_date) {
//		this.exam_date = exam_date;
//	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Exam() {
		this.exam_id =0;
		this.use_id = 0;
		//this.exam_date = "";
		this.score = 0;
	}
	
	

}
