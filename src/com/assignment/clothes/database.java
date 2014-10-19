package com.assignment.clothes;


//The code is for illustration only. It is not intended to be reproduced exactly.
// Indenting, naming conventions, MVC, not included.

// Comments to be added!!


//make sure this is in class path (Right click project and see Java Build Path)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class database 
{
	
	public ArrayList<String> Trousers,jackets,t_shirt,Shoes,Sweaters;
	public ArrayList<Float> Tprice, SWprice, SHprice, TSprice, Jprice;
	public ArrayList<String> Tname, SWname, SHname, TSname, Jname;
	
	
	public database() throws Exception{
		 try 
		    {
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      System.out.println("driver loaded");
		    } 
		    catch (ClassNotFoundException e) 
		    {
			    System.out.println ("Could not load the driver");
		    }

			
		    // Edit these credential as needed for your database URL	 
		    String servername = "localhost";
		    String portnumber = "1521";
		    String sid = "xe";
		    String url = "jdbc:oracle:thin:@" + servername + ":" + portnumber + ":" + sid;
		    String user, pass;
			user = "CD_PCreates";
			pass = "***********";//Enter Password
		    System.out.println(url);


		    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println ("before connection");

		    Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println ("after connection");

		    Statement stmt = conn.createStatement ();
		  
		    Trousers = new ArrayList<String>();
		    Tprice = new ArrayList<Float>();
		    Tname = new ArrayList<String>();
		    
		///////Getting Trousers from database and storing them in an arraylist
		    for(int i = 0; i<7 ; i++){
				   
		    	ResultSet rset = stmt.executeQuery("select * from CLOTHES where CLOTHES_ID ="+i+ " AND cat = 'Trousers'");

				   while (rset.next()) {
					   Trousers.add(rset.getString(2).toString());
					   Tprice.add( rset.getFloat(4));
					   Tname.add(rset.getString(1));
				   }
				   
		    }
		    
		    ///////Getting Sweaters from database and storing them in an arraylist
		    Sweaters = new ArrayList<String>();
		    SWprice = new ArrayList<Float>();
		    SWname = new ArrayList<String>();
		    for(int i = 0; i<7 ; i++){
				   
		    	ResultSet rset2 = stmt.executeQuery("select * from CLOTHES where CLOTHES_ID ="+i+ " AND cat = 'sweaters'");

				   while (rset2.next()) {
					   Sweaters.add(rset2.getString(2).toString());  
					   SWprice.add( rset2.getFloat(4));
					   SWname.add(rset2.getString(1));
				   }
				   
		    }
		    
		    
		    ///////Getting Shoes from database and storing them in an arraylist
		    Shoes = new ArrayList<String>();
		    SHprice = new ArrayList<Float>();
		    SHname = new ArrayList<String>();
		    for(int i = 0; i<7 ; i++){
				   
		    	ResultSet rset3 = stmt.executeQuery("select * from CLOTHES where CLOTHES_ID ="+i+ " AND cat = 'shoes'");

				   while (rset3.next()) {
					   Shoes.add(rset3.getString(2).toString());
					   SHprice.add( rset3.getFloat(4));
					   SHname.add(rset3.getString(1));
				   }
				   
		    }
		    
		///////Getting T_Shirts from database and storing them in an arraylist
		     t_shirt = new ArrayList<String>();
		     TSprice = new ArrayList<Float>();
		     TSname = new ArrayList<String>();

		    for(int i = 0; i<7 ; i++){
				   
		    	 ResultSet rset4 = stmt.executeQuery("select * from CLOTHES where CLOTHES_ID ="+i+ " AND cat = 't-shirts'");

				   while (rset4.next()) {
					   t_shirt.add(rset4.getString(2).toString());
					   TSprice.add( rset4.getFloat(4));
					   TSname.add(rset4.getString(1));
				   }
				   
		    }

		///////Getting Jeckets from database and storing them in an arraylist
		    jackets = new ArrayList<String>();
		    Jprice = new ArrayList<Float>();
		    Jname = new ArrayList<String>();
		    for(int i = 0; i<7 ; i++){
				   
		    	 ResultSet rset5 = stmt.executeQuery("select * from CLOTHES where CLOTHES_ID ="+i+ " AND cat = 'jackets' ");

				   while (rset5.next()) {
					   jackets.add(rset5.getString(2).toString());
					   Jprice.add( rset5.getFloat(4));
					   Jname.add(rset5.getString(1));
				   }
				   
		    }
		 
		  
		  stmt.close();
		  conn.close();
	}

    //readEntry function -- to read input string from keyboard
/*
   static String readEntry(String prompt) 
   {
      try 
      {
 	 StringBuffer buffer = new StringBuffer();
	 System.out.print(prompt);
	 System.out.flush();
	 int c = System.in.read();
	 while (c != '\n' && c != -1) 
	 { 
            buffer.append((char)c);
   	    c = System.in.read();
          }
 
         return buffer.toString().trim();
   
       }   
       catch (IOException e) 
       {
   	 return "";
       } 
  }*/
   
} 