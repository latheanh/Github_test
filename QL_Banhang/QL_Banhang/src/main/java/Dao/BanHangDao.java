package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.BanHangModel;

public class BanHangDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private String URL = "jdbc:mysql://localhost:3306/banhang";
	private String Username = "root";
	private String Password = "";

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, Username, Password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Kết nối thất bại!!");
		}
		return conn;
	}

	public List<BanHangModel> getAllBanHang() {
		List<BanHangModel> list = new ArrayList<>();
		String sql = "SELECT * FROM t_banhang";	
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BanHangModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public void deleteBanHang(int id) {
		String sql = "DELETE FROM `t_banhang` WHERE id = ?;";
		try {
			conn =  getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void addBanHang(BanHangModel bh) {
		String sql = "INSERT INTO `t_banhang`(`tenhang`, `ngaynhap`, `nhomhang`, `soluong`) VALUES (?,?,?,?)";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bh.getTenhang());
			ps.setString(2, bh.getNgaynhap());
			ps.setString(3, bh.getNhomhang());
			ps.setFloat(4, bh.getSoluong());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public BanHangModel getBanHang(int id) {
		String sql = "SELECT * FROM t_banhang WHERE id = ?";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new BanHangModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	} 
	
	public void edit(BanHangModel bh) {
		String sql = "UPDATE `t_banhang` SET `tenhang`=?,`ngaynhap`=?,`nhomhang`=?,`soluong`=? WHERE id = ?;";
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bh.getTenhang());
			ps.setString(2, bh.getNgaynhap());
			ps.setString(3, bh.getNhomhang());
			ps.setInt(4, bh.getSoluong());
			ps.setInt(5, bh.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
