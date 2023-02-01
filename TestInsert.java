import java.beans.Statement;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;


public class TestInsert {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String urloracle="jdbc:oracle:thin:@localhost:1521:orcl";
       String username="hr";
       String password="hr";
       try{
       Connection conSQL=DriverManager.getConnection(urloracle,username,password);
    //    Connection conSQL2=DriverManager.getConnection
       System.out.println("connection successfull");
       
        boolean f=true;
            while(f==true){
                    for(int i=0;i<5;i++)
                    {
                        System.out.println("Enter the name,age,address,course of the student");
                        System.out.println();
                        String name=br.readLine();
                        int age=Integer.parseInt(br.readLine());
                        String address=br.readLine();
                        int course=Integer.parseInt(br.readLine());
                        String query="insert into student(name,age,address,course) values(" + "\'"+name+"\'"+","+age+","+"\'"+address+"\'"+","+course+")";

                        java.sql.Statement stmt=conSQL.createStatement();
                        int rs=stmt.executeUpdate(query);
                        System.out.println(rs+" record inserted");
                        System.out.println("Do you want to continue ? if yes then type y else n");


                        String ch=(br.readLine()).toLowerCase();
                        if(ch.equals("n"))
                            System.exit(1);
                    }
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
