package Model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BasHekim extends User {
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	public BasHekim(int id, String tc_no, String name, String password, String type) {
		super(id, tc_no, name, password, type);
		
	}
	public BasHekim() {}
	
	public ArrayList<User> getDoctorList() throws SQLException{
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE type = 'yonetim'");
			while (rs.next()) {
				obj = new User (rs.getInt("id"),rs.getString("tc_no"),rs.getString("name"),rs.getString("password"),rs.getString("type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return list;
	
	
	
	
	
	}
}
