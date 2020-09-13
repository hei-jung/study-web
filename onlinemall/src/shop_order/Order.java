package shop_order;

import java.sql.Date;

public class Order {

	private int num;
	private int prod_num;
	private int amt;
	private int total_price;
	private String c_id;
	private Date order_date;
	private int order_type;

	public Order() {
	}

	public Order(int num, int prod_num, int amt, int total_price, String c_id, Date order_date, int order_type) {
		this.num = num;
		this.prod_num = prod_num;
		this.amt = amt;
		this.total_price = total_price;
		this.c_id = c_id;
		this.order_date = order_date;
		this.order_type = order_type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getOrder_type() {
		return order_type;
	}

	public void setOrder_type(int order_type) {
		this.order_type = order_type;
	}

	@Override
	public String toString() {
		return "Order [num=" + num + ", prod_num=" + prod_num + ", amt=" + amt + ", total_price=" + total_price
				+ ", c_id=" + c_id + ", order_date=" + order_date + ", order_type=" + order_type + "]";
	}

}
