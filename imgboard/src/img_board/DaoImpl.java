package img_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dbconn.DBConn;

public class DaoImpl implements Dao {

	private DBConn db;

	public DaoImpl() {
		db = DBConn.getInstance();
	}

	@Override
	public void insert(ImgBoard ib) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "insert into img_board values(seq_img_board.nextval, ?, ?, ?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ib.getWriter());
			pstm.setString(2, ib.getTitle());
			pstm.setString(3, ib.getImg());
			pstm.executeUpdate();
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
	public ArrayList<ImgBoard> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "select * from img_board order by num";
		ArrayList<ImgBoard> list = new ArrayList<ImgBoard>();
		ResultSet rs = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				list.add(new ImgBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
		return list;
	}

}
