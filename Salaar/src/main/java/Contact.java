import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.Statement;



public class Contact { 

		String dbUrl="jdbc:mysql://localhost:3306/contactdb";

	    String dbUname="root";

	    String dbPassword="";

	    String dbDriver="com.mysql.cj.jdbc.Driver";

	    String name,no_of_persons,date,email;

	  Contact(String name,String no_of_persons,String date,String email){

		  this.name=name;    

		  this.no_of_persons=no_of_persons;

		  this.date=date;

		  this.email=email;

	  }

      void store(){

    	  Connection con = null;

	   		try {

				Class.forName(dbDriver);  //class not found exception

				con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception

				String sql = "insert into contact(name,no_of_persons,date,email)"

						+ "values('"+name+"','"+no_of_persons+"','"+date+"','"+email+"')";

				Statement s = con.createStatement();

				s.execute(sql);

			   	con.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

      }

}