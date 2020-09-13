package guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImpl implements Dao {

	private DBConn db;

	public DaoImpl() {
		db = DBConn.getInstance();
	}

	@Override
	public void insert(Article a) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "INSERT INTO GUESTBOOK VALUES(seq_guestbook.nextval,?,?,sysdate,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, a.getWriter());
			pstm.setString(2, a.getPwd());
			pstm.setString(3, a.getContent());
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
	public Article select(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "SELECT * FROM GUESTBOOK WHERE NUM=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
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
	public ArrayList<Article> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "SELECT * FROM GUESTBOOK ORDER BY NUM";
		ArrayList<Article> articles = new ArrayList<Article>();
		ResultSet rs = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				articles.add(
						new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));
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
		return articles;
	}

	@Override
	public void update(Article a) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "UPDATE GUESTBOOK SET CONTENT=? WHERE NUM=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, a.getContent());
			pstm.setInt(2, a.getNum());
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
	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "DELETE GUESTBOOK WHERE NUM=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
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
