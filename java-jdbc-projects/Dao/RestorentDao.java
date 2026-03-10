package jdbc.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.entity.Restorent;

public class RestorentDao {
	private Connection con;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=sql123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int insert(Restorent r) throws SQLException {
		String query="insert into restorent values(?,?,?,?,?,?)";
		PreparedStatement psmt=con.prepareStatement(query);
		psmt.setLong(1, r.getId());
		psmt.setString(2, r.getName());
		psmt.setString(3, r.getLoc());
		psmt.setString(4, r.getFooditems());
		psmt.setString(5, r.getRating());
		psmt.setString(6,r.getDes());
		return psmt.executeUpdate();		
	}
  
	public ResultSet feacthAll() throws SQLException {
		String query="select * from restorent";
		PreparedStatement psmt=con.prepareStatement(query);
		return psmt.executeQuery();
	}

	public Restorent fetchbyId(long id) throws SQLException {
		String query="select * from restorent where id=?";
		PreparedStatement psmt=con.prepareStatement(query);
		psmt.setLong(1, id);
		ResultSet res= psmt.executeQuery();
		if(res.isBeforeFirst()){
			Restorent r=new Restorent();
			while(res.next()){
				 r.setId(res.getLong(1));
				 r.setName("name: "+res.getString(2));
				 r.setLoc("location: "+res.getString(3));
				 r.setFooditems("footitems: "+res.getString(4));
				 r.setRating("rating: "+res.getString(5));
				 r.setDes("description: "+res.getString(6));
				 return r;
			}
		}
		return null;
	}

	public int updateData(String data, long id) throws SQLException {
		String query="update restorent set name=? where id=?";
		PreparedStatement psmt=con.prepareStatement(query);
		psmt.setString(1, data);
		psmt.setLong(2, id);
		return psmt.executeUpdate();
	}

	public int deleteData(long id) throws SQLException {
		String query="delete from restorent where id=?";
		PreparedStatement psmt=con.prepareStatement(query);
		psmt.setLong(1, id);
		return psmt.executeUpdate();
	}
}
