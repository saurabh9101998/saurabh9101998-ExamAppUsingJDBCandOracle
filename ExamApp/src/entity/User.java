package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User {
	private int uid;
	private String name;
	private int mobile;
	private String city;
	

	Scanner scanner = new Scanner(System.in);

	public User() {

		name = "";
		mobile = 0;
		city = "";

	}


	public void setUid(int uid) {
		this.uid = uid;
	}




	public int getUid() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
