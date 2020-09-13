package shop_order;

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
	public void insert(Order o) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "insert into shop_order values(seq_shop_order.nextval,?,?,?,?,sysdate,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, o.getProd_num());
			pstm.setInt(2, o.getAmt());
			pstm.setInt(3, o.getTotal_price());
			pstm.setString(4, o.getC_id());
			pstm.setInt(5, o.getOrder_type());
			int rows = pstm.executeUpdate();
			System.out.println(rows + "개의 주문이 추가됨");
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
	public ArrayList<Order> selectAll(int order_type) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "select * from shop_order where order_type=? order by num";
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, order_type);
			rs = pstm.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7)));
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
	public Order select(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "select * from shop_order where num=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6),
						rs.getInt(7));
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
	public void update(Order o) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();
		String sql = "update shop_order set amt=?, total_price=?, order_type=? where num=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, o.getAmt());
			pstm.setInt(2, o.getTotal_price());
			pstm.setInt(3, o.getOrder_type());
			int rows = pstm.executeUpdate();
			System.out.println(rows + "개의 주문이 수정됨");
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
		String sql = "delete shop_order where num=?";
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
