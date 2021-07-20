package javawithdbms;


import java.util.*;
import java.sql.*;
import java.lang.*;


public class java_data {
Scanner sc= new Scanner(System.in);
public void  insert(String name, String roll,String number,String course)
    {
        String Name=name;
        String Roll=roll;
                 //to load the driver Class.forName("com.mysql.jdbc.Driver");
                  try{ 
                System.out.println("Driver Loaded..............................................");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ student","root","Gaurav@123") ;
                System.out.println("connection Established..............................................");
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("insert into student_info"+" values('"+Name+"','"+Roll+"','"+number+"','"+course+"');");
                System.out.println("Inserted..............................................");
                  }
              catch(SQLException e){
              System.out.println(e.getMessage());}
                
    }
public void show(){
      try{ 
                System.out.println("Driver Loaded..............................................");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ student","root","Gaurav@123") ;
                System.out.println("connection Established..............................................");
                Statement stmt = conn.createStatement();
               ResultSet rs= stmt.executeQuery("Select * from student_info;");
                 while (rs.next()) {
                              // Retrieve by column name
                           System.out.print(" Name|" + rs.getString("name")+" | " +" Roll Number |"+rs.getString("roll")+" | " +" Mobile_Number  | "+rs.getString("Mobile_Number")+" | " +"Couse |"+rs.getString("Branch")); 
                           System.out.println(); 
                  } 
          }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
    }
public  void delete(){
    try{ 
                System.out.println("Enter the roll number to be delete");
                String roll=sc.next();
                System.out.println("Driver Loaded..............................................");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ student","root","Gaurav@123") ;
                System.out.println("connection Established..............................................");
                Statement stmt = conn.createStatement();
                stmt.execute("delete from student_info where roll='"+(roll)+"' ");
                System.out.println("Record deleted");
       }
    catch(SQLException e){
          System.out.println(e.getMessage());
      }
}

public void update(){
    try{ 
                System.out.println("Enter the roll number to be update");
                String roll=sc.next();
                System.out.println("Enter the new roll number to be update");
                String n_roll=sc.next();
                System.out.println("Enter the new Name to be update");
                String name=sc.next();
                System.out.println("Enter the new mobile number to be update");
                String mobile=sc.next();
                System.out.println("Enter the new branch to be update");
                String branch=sc.next();
                System.out.println("Driver Loaded..............................................");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ student","root","Gaurav@123") ;
                System.out.println("connection Established..............................................");
                PreparedStatement stmt = conn.prepareStatement("update student_info set name=?,roll=?,mobile_number=?,branch=? where roll=?");
                stmt.setString(1,name);
                stmt.setString(2,n_roll);
                stmt.setString(3,mobile);
                stmt.setString(4,branch);
                stmt.setString(5,roll);
                stmt.executeUpdate();
                System.out.println("Updated..........");
    }
    catch(SQLException e){
          System.out.println(e.getMessage());
      }
}
public static void main(String[] args){
    java_data jd = new java_data();
    while(true){   
        Scanner sc= new Scanner(System.in);
        System.out.println();
        System.out.println("Enter Any Key From 1 to 5");
        System.out.println("1: Insert");
        System.out.println("2: Show");
        System.out.println("3: Delete");
        System.out.println("4: Update");
        System.out.println("5: Exit");
        int choice = sc.nextInt();
       
        switch(choice)
        { 
            case 1:
                 System.out.println("Enter the name to be inserted");
                 String name = sc.next();
                 System.out.println("Enter the roll number to be inserted");
                 String roll=sc.next();
                 System.out.println("Enter the mobile number to be inserted");
                 String number=sc.next();
                 System.out.println("Enter the course name to be inserted");
                 String course=sc.next();
                 jd.insert(name,roll,number,course);
                 break;
            case 2:
                jd.show();
                break;
            case 3:
                 jd.delete();
                break;
            case 4:
                jd.update();
                break;
            case 5:
                break;
            default:
            System.out.print("Invalid Key");
        }
    }
    }
}
