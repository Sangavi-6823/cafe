import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

public class LoginDoa {

String dbUrl="jdbc:mysql://localhost:3306/ngpdb";

String dbUname="root";

String dbPassword="";

String dbDriver="com.mysql.cj.jdbc.Driver";

String email,pass;

    LoginDoa(String email,String password){

    this.email=email;

    this.pass=password;

    }

    boolean signin() {

    	Connection con = null;

	    try {

	    	System.out.println("email="+email);

	    	Class.forName(dbDriver);  //class not found exception

			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword); 

			String sql="select * from student_table where email = ? ";

			PreparedStatement s = con.prepareStatement(sql);

			s.setString(1,email);

			ResultSet rs =s.executeQuery();

			if(rs.next()) {

				return true;

			}

			else {

				return false;

			}

	    }

	    catch(Exception e){

	    	e.printStackTrace();

	    	System.out.println("exception");

	    	return false;

	    }

    }

}