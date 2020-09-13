package board;

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
	public void insert(Board b) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();// db 연결
		String sql = "insert into board values(seq_board.nextval, ?,?,sysdate,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, b.getWriter());
			pstm.setString(2, b.getTitle());
			pstm.setString(3, b.getContent());
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
	public Board selectById(int num) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Connection conn = db.getConnect();// db 연결
		String sql = "select * from board where num=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			rs = pstm.executeQuery();// select를 실행하는 메서드, 반환:검색결과
			if (rs.next()) {
				return new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
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
	public ArrayList<Board> selectByWriter(String writer) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		Connection conn = db.getConnect();// db 연결
		String sql = "select * from board where writer=?  order by num";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, writer);
			rs = pstm.executeQuery();// select를 실행하는 메서드, 반환:검색결과
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));
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

	@Override
	public ArrayList<Board> selectByTitle(String title) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		Connection conn = db.getConnect();// db 연결
		String sql = "select * from board where title like '%"+title+"%'  order by num";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();// select를 실행하는 메서드, 반환:검색결과
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));
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

	@Override
	public ArrayList<Board> select() {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		Connection conn = db.getConnect();// db 연결
		String sql = "select * from board order by num";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();// select를 실행하는 메서드, 반환:검색결과
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));
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

	@Override
	public void update(Board b) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();// db 연결
		String sql = "update board set title=?, content=?, w_date=sysdate where num=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, b.getTitle());
			pstm.setString(2, b.getContent());
			pstm.setInt(3, b.getNum());
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
	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();// db 연결
		String sql = "delete from board where num=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
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

}
