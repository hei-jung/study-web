package jdbc.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static DBConn db = new DBConn();
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	private DBConn() {
	}

	public static DBConn getInstance() {
		return db;
	}

	public Connection getConnect() {//db시스템에 연결.
		Connection conn = null;
		try {
			Class.forName(driver);//jdbc 드라이버 로드
			conn = DriverManager.getConnection(url, "hr", "hr");//db서버의 주소, 계정, 비밀번호를 이용해서 세션수립
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
