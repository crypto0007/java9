import java.sql.*;
import java.util.*;
class Query_Class
{
	Scanner sc,sc1;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet res;
	Query_Class()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			sc=new Scanner(System.in);
			sc1=new Scanner(System.in);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void insertData() throws Exception
	{

		System.out.println("ENTER NAME:");
		String name=sc.nextLine();
		System.out.println("ENTER SURNAME:");
		String s_name=sc.nextLine();
		System.out.println("ENTER BRACNH:");
		String branch=sc.nextLine();
		System.out.println("ENTER SEMESTER:");
		int sem=sc1.nextInt();
		System.out.println("ENTER CITY:");
		String city=sc.nextLine();
		System.out.println("ENTER PHONE NUMBER :");
		String p_no=sc.nextLine();
		String query="Insert Into student_table(name,surname,sem,branch,city,phone_no) values(?,?,?,?,?,?)";
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,name);
		pstmt.setString(2,s_name);
		pstmt.setInt(3,sem);
		pstmt.setString(4,branch);
		pstmt.setString(5,city);
		pstmt.setString(6,p_no);
		int res=pstmt.executeUpdate();
		if(res==1)
		{
			System.out.println("RECORED INSERTED SUCCESSFULLY");
		}

	}

	public void showData()
	{
		try
		{


			stmt=con.createStatement();
			ResultSet res=stmt.executeQuery("select * from student_table");

			boolean more=res.next();
			while(more)
			{
				System.out.println("ID:"+res.getInt(1));
				System.out.println("NAME:"+res.getString(2));
				System.out.println("SURNAME:"+res.getString(3));
				System.out.println("SEM:"+res.getString(4));
				System.out.println("BRANCH:"+res.getString(5));
				System.out.println("CITY:"+res.getString(6));
				System.out.println("PHONE NO:"+res.getString(7));
				more=res.next();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void updateData() throws Exception
	{
		System.out.println("ENTER ID TO UPDATE RECORED:");
		int id=sc1.nextInt();

		System.out.println("ENTER NAME:");
		String name=sc.nextLine();
		System.out.println("ENTER SURNAME:");
		String s_name=sc.nextLine();
		System.out.println("ENTER BRACNH:");
		String branch=sc.nextLine();
		System.out.println("ENTER SEMESTER:");
		int sem=sc1.nextInt();
		System.out.println("ENTER CITY:");
		String city=sc.nextLine();
		System.out.println("ENTER PHONE NUMBER :");
		String p_no=sc.nextLine();

		String query="UPDATE student_table set name=?,surname=?,sem=?,branch=?,city=?,phone_no=? where s_id="+id;
		pstmt=con.prepareStatement(query);

		pstmt.setString(1,name);
		pstmt.setString(2,s_name);
		pstmt.setInt(3,sem);
		pstmt.setString(4,branch);
		pstmt.setString(5,city);
		pstmt.setString(6,p_no);
		int res=pstmt.executeUpdate();
		if(res==1)
		{
			System.out.println("RECORED UPDATED SUCCESSFULLY");
		}

	}
	public void deleteData() throws Exception
	{
		System.out.println("ENTER ID TO UPDATE RECORED:");
		int id=sc1.nextInt();

		String query="DELETE FROM student_table where s_id="+id;
		pstmt=con.prepareStatement(query);

		int res=pstmt.executeUpdate();
		if(res==1)
		{
			System.out.println("RECORED DELETED SUCCESSFULLY");
		}

	}

	public void showDataById()
		{
			try
			{
				System.out.println("ENTER ID TO UPDATE RECORED:");
				int id=sc1.nextInt();

				stmt=con.createStatement();
				ResultSet res=stmt.executeQuery("select * from student_table where s_id="+id);

				boolean more=res.next();
				while(more)
				{
					System.out.println("ID:"+res.getInt(1));
					System.out.println("NAME:"+res.getString(2));
					System.out.println("SURNAME:"+res.getString(3));
					System.out.println("SEM:"+res.getString(4));
					System.out.println("BRANCH:"+res.getString(5));
					System.out.println("CITY:"+res.getString(6));
					System.out.println("PHONE NO:"+res.getString(7));
					more=res.next();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	public void showSortedData(String value)
		{
			try
			{


				stmt=con.createStatement();
				String query="select * from student_table ORDER BY "+value;

				ResultSet res=stmt.executeQuery(query);

				boolean more=res.next();
				while(more)
				{
					System.out.println("ID:"+res.getInt(1));
					System.out.println("NAME:"+res.getString(2));
					System.out.println("SURNAME:"+res.getString(3));
					System.out.println("SEM:"+res.getString(4));
					System.out.println("BRANCH:"+res.getString(5));
					System.out.println("CITY:"+res.getString(6));
					System.out.println("PHONE NO:"+res.getString(7));
					more=res.next();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}

}
class Main_Class
{
	public static void main(String args[])
	{
		try
		{
			Query_Class q1=new  Query_Class();
		Scanner sc=new Scanner(System.in);
			Scanner sc1=new Scanner(System.in);
		while(true)
		{
			System.out.println("1.INSERT DATA");
			System.out.println("2.UPDATE DATA");
			System.out.println("3.DELETE DATA");
			System.out.println("4.DISPLAY ALL DATA");
			System.out.println("5.DISPLAY DATA BY ID");
			System.out.println("6.DISPLAY SHORT DATA");
			System.out.println("ENTER YOUR CHOICE:");
			int ch=sc.nextInt();

			switch(ch)
			{
				case 1:
					q1.insertData();
					break;
				case 2:
					q1.updateData();
					break;
				case 3:
					q1.deleteData();
					break;
				case 4:
					q1.showData();
					break;
				case 5:
					q1.showDataById();
					break;
				case 6:
					System.out.println("ENTER FIELD NAME TO SHORT:");
					String name=sc1.nextLine();
					q1.showSortedData(name);
					break;
				default:
					System.out.println("INVALID CHOICE");
					break;

			}
	}



		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}