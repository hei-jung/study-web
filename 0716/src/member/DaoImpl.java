package member;

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
	public void insert(Member m) {// m: 회원가입 정보(id,pwd, name,email)
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();// db 연결
		String sql = "insert into member values(?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);// PreparedStatement:
																// sql 처리하는 객체
			pstm.setString(1, m.getId());// sql의 ?를 매칭
			pstm.setString(2, m.getPwd());
			pstm.setString(3, m.getName());
			pstm.setString(4, m.getEmail());
			int rows = pstm.executeUpdate();// insert, update, delete를 실행하는 메서드, 적용된 줄수											
			System.out.println(rows + " 줄이 추가되었습니다. ");
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
		ResultSet rs = null;
		Connection conn = db.getConnect();// db 연결
		String sql = "select * from member where id=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();// select를 실행하는 메서드, 반환:검색결과											
			if(rs.next()){
				return new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
		Connection conn = db.getConnect();// db 연결
		String sql = "update member set pwd=?, email=? where id=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);			
			pstm.setString(1, m.getPwd());
			pstm.setString(2, m.getEmail());
			pstm.setString(3, m.getId());
			int rows = pstm.executeUpdate();// insert, update, delete를 실행하는 메서드, 적용된 줄수											
			System.out.println(rows + " 줄이 수정되었습니다. ");
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
		Connection conn = db.getConnect();// db 연결
		String sql = "delete member where id=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);			
			pstm.setString(1, id);
			int rows = pstm.executeUpdate();// insert, update, delete를 실행하는 메서드, 적용된 줄수											
			System.out.println(rows + " 줄이 삭제되었습니다. ");
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
