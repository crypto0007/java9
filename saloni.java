import java.sql.*;
import java.util.*;
class Student
{
	public static void main(String a[])
	{
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		String fname,lname,branch,city,mobile,query;
		int sem,id,i;
		ResultSet res;
		boolean more;
		PreparedStatement stmt;
		Statement stmt1;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/Student","root","");
			while(true)
			{
				System.out.println("1.Insert \n 2. Update \n 3.Delete \n 4. Display all \n 5. Display by firstname \n 6.exit");
				System.out.println("Enter ur choice::");
				int c=sc1.nextInt();
				switch(c)
				{
					case 1:
						System.out.println("Enter ur first name:");
						fname=sc.nextLine();
						System.out.println("Enter ur last name:");
						lname=sc.nextLine();
						System.out.println("Enter ur branch:");
						branch=sc.nextLine();
						System.out.println("Enter ur Semester:");
						sem=sc1.nextInt();
						System.out.println("Enter ur city:");
						city=sc.nextLine();
						System.out.println("Enter ur Mobile number:");
						mobile=sc.nextLine();
						query="insert into stud (fname,lname,branch,sem,city,mobile) values (?,?,?,?,?,?)";
						stmt=con.prepareStatement(query);
						stmt.setString(1,fname);
						stmt.setString(2,lname);
						stmt.setString(3,branch);
						stmt.setInt(4,sem);
						stmt.setString(5,city);
						stmt.setString(6,mobile);
						i=stmt.executeUpdate();
						if(i==0)
							System.out.println("Data inserted successfully");
						break;
					case 2:
						System.out.println("Enter ur first name:");
						fname=sc.nextLine();
						System.out.println("Enter ur last name:");
						lname=sc.nextLine();
						System.out.println("Enter ur branch:");
						branch=sc.nextLine();
						System.out.println("Enter ur Semester:");
						sem=sc1.nextInt();
						System.out.println("Enter ur city:");
						city=sc.nextLine();
						System.out.println("Enter ur Mobile number:");
						mobile=sc.nextLine();
						System.out.println("Enter ur id:");
						id=sc1.nextInt();
						query="update stud set fname=?,lname=?,branch=?,sem=?,city=?,mobile=? where s_id=?";
						System.out.println(query);
						stmt=con.prepareStatement(query);
						stmt.setString(1,fname);
						stmt.setString(2,lname);
						stmt.setString(3,branch);
						stmt.setInt(4,sem);
						stmt.setString(5,city);
						stmt.setString(6,mobile);
						stmt.setInt(7,id);
						i=stmt.executeUpdate();
						if(i==0)
							System.out.println("Data Updated successfully");
						break;
					case 3:
						query="delete from stud where s_id=?";
						stmt=con.prepareStatement(query);
						System.out.println("Enter ur id:");
						id=sc1.nextInt();
						stmt.setInt(1,id);
						i=stmt.executeUpdate();
						if(i==0)
							System.out.println("Data deleted successfully");
						break;
					case 4:
						query="select * from stud";
						stmt1=con.createStatement();
						res=stmt1.executeQuery(query);
						more=res.next();
						System.out.println("Fname	Lname	Branch	Sem	City	Mobile	");
						while(more)
						{
							System.out.print(res.getString(2)+"	");
							System.out.print(res.getString(3)+"	");
							System.out.print(res.getString(4)+"	");
							System.out.print(res.getString(5)+"	");
							System.out.print(res.getString(6)+"	");
							System.out.print(res.getString(7)+"	");
							System.out.println();
							more=res.next();
						}
						break;
					case 5:
						query="select * from stud order by (fname)ASC";
						stmt1=con.createStatement();
						res=stmt1.executeQuery(query);
						more=res.next();
						System.out.println("Fname	Lname	Branch	Sem	City	Mobile	");
						while(more)
						{
							System.out.print(res.getString(2)+"	");
							System.out.print(res.getString(3)+"	");
							System.out.print(res.getString(4)+"	");
							System.out.print(res.getString(5)+"	");
							System.out.print(res.getString(6)+"	");
							System.out.print(res.getString(7)+"	");
							System.out.println();
							more=res.next();
						}
						break;
					case 6:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice");
				}
			}



		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}