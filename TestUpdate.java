import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
public class TestUpdate {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String urloracle="jdbc:oracle:thin:@localhost:1521:orcl";
        String username="hr";
        String password="hr";
        try{
        Connection conSQL=DriverManager.getConnection(urloracle,username,password);
        System.out.println("connection successfull");
        // String query = "update student set name='dhoni' where name='MSD'";
        boolean f=true;
        System.out.println("Enter the attribute which needs to be edited");
        String ch=(br.readLine()).toLowerCase();
        String query="";
        switch(ch)
        {
            case "name":System.out.println("Enter the new name and the id where it need to be updated"); 
                        String newname=br.readLine();
                        int id=Integer.parseInt(br.readLine());
                        query="update student set name="+"'"+newname+"'"+"where id="+ id;
                        break;

            case "age": System.out.println("Enter the new age and the id where it need to be updated"); 
                        int newage=Integer.parseInt(br.readLine());
                        id=Integer.parseInt(br.readLine());
                        query="update student set name="+"'"+newage+"'"+"where id="+ id;
                        break;               
            
            case "address": System.out.println("Enter the new address and the id where it need to be updated"); 
                            String newaddress=br.readLine();
                            id=Integer.parseInt(br.readLine());
                            query="update student set name="+"'"+newaddress+"'"+"where id="+ id;
                            break;

            case "course": System.out.println("Enter the new course id and the id where it need to be updated");
                            int newcourse=Integer.parseInt(br.readLine());
                            id=Integer.parseInt(br.readLine());
                            query="update student set name="+"'"+newcourse+"'"+"where id="+ id;
                            break;

            default:System.out.println("Invalid input nothing to update");
                    break;

        }
        java.sql.Statement stmt=conSQL.createStatement();
        int rs=stmt.executeUpdate(query);
        System.out.println(rs+" record updated");
        
         }
         catch(SQLException e)
         {
             System.out.println(e.getMessage());
         }
     }
}
