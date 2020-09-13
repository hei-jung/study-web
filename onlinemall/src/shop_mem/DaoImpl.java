package shop_mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.dbconn.DBConn;

public class DaoImpl implements Dao {

	private DBConn db;

	public DaoImpl() {
		db = DBConn.getInstance();
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "insert into shop_mem values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getId());
			pstm.setString(2, m.getPwd());
			pstm.setString(3, m.getName());
			pstm.setString(4, m.getEmail());
			pstm.setString(5, m.getType());
			int rows = pstm.executeUpdate();
			System.out.println(rows + "¡Ÿ¿Ã √ﬂ∞°µ ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Member select(String id) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "select * from shop_mem where id=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "update shop_mem set pwd=?, email=? where id=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getPwd());
			pstm.setString(2, m.getEmail());
			pstm.setString(3, m.getId());
			int rows = pstm.executeUpdate();
			System.out.println(rows + "¡Ÿ¿Ã ºˆ¡§µ ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "delete shop_mem where id=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			int rows = pstm.executeUpdate();
			System.out.println(rows + "¡Ÿ¿Ã ªË¡¶µ ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
