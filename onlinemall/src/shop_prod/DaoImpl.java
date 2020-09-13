package shop_prod;

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
	public void insert(Product p) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "insert into shop_product values(seq_shop_product.nextval,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, p.getS_id());
			pstm.setString(2, p.getName());
			pstm.setInt(3, p.getPrice());
			pstm.setInt(4, p.getQty());
			pstm.setString(5, p.getImg_path());
			pstm.setString(6, p.getInfo());
			int rows = pstm.executeUpdate();
			System.out.println(rows + "개의 상품이 등록됨");
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
	public ArrayList<Product> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "select * from shop_product order by num";
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7)));
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
	public Product select(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "select * from shop_product where num=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7));
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
	public void update(Product p) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "update shop_product set price=?, qty=?, info=? where num=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getPrice());
			pstm.setInt(2, p.getQty());
			pstm.setString(3, p.getInfo());
			pstm.setInt(4, p.getNum());
			int rows = pstm.executeUpdate();
			System.out.println(rows + "개의 상품이 수정됨");
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
		String sql = "delete shop_product where num=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			int rows = pstm.executeUpdate();
			System.out.println(rows + "개의 상품이 삭제됨");
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
