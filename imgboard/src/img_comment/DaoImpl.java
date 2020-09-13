package img_comment;

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
	public void insert(ImgComment ic) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "insert into img_comment values(seq_img_comment.nextval,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ic.getImg_num());
			pstm.setString(2, ic.getWriter());
			pstm.setString(3, ic.getContent());
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
	public ArrayList<ImgComment> selectAll(int img_num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "select * from img_comment where img_num=? order by num";
		ArrayList<ImgComment> list = new ArrayList<ImgComment>();
		ResultSet rs = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, img_num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				list.add(new ImgComment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
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
