package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Sach;
import model.TacGia;
import model.TheLoai;

public class SachDAO implements DAOInterface<Sach> {

	private ArrayList<Sach> data = new ArrayList<>();

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM sach";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tensach");
				String maTacGia = rs.getString("matacgia");
				int namXuatBan = rs.getInt("namxuatban");
				double giaNhap = rs.getDouble("gianhap");
				double giaGoc = rs.getDouble("giagoc");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String maTheLoai = rs.getString("matheloai");
				String ngonNgu = rs.getString("ngonngu");
				String moTa = rs.getString("mota");

				TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));
				TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));

				Sach s = new Sach(maSach, tenSach, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, theLoai,
						ngonNgu, moTa);
				ketQua.add(s);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public Sach selectById(Sach t) {
		Sach ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia WHERE masach = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSach());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tensach");
				String maTacGia = rs.getString("matacgia");
				int namXuatBan = rs.getInt("namxuatban");
				double giaNhap = rs.getDouble("gianhap");
				double giaGoc = rs.getDouble("giagoc");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String maTheLoai = rs.getString("matheloai");
				String ngonNgu = rs.getString("ngonngu");
				String moTa = rs.getString("mota");

				TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));
				TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));

				ketQua = new Sach(maSach, tenSach, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, theLoai,
						ngonNgu, moTa);
				break;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO sanpham (masanpham,tensanpham, matacgia, namxuatban,"
					+ " gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSach());
			st.setString(2, t.getMaSach());
			st.setString(3, t.getTacGia().getMaTacGia());
			st.setInt(4, t.getNamXuatBan());
			st.setDouble(5, t.getGiaNhap());
			st.setDouble(6, t.getGiaGoc());
			st.setDouble(7, t.getGiaBan());
			st.setInt(8, t.getSoLuong());
			st.setString(9, t.getTheLoai().getMaTheLoai());
			st.setString(10, t.getNgonNgu());
			st.setString(11, t.getMoTa());

			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<Sach> arr) {
		int dem = 0;
		for (Sach sach : arr) {
			dem += this.insert(sach);
		}
		return dem;
	}

	@Override
	public int delete(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from sach " + " WHERE masach=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSach());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<Sach> arr) {
		int dem = 0;
		for (Sach sach : arr) {
			dem += this.delete(sach);
		}
		return dem;
	}

	@Override
	public int update(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE sach " + " SET " + "tensach=?, matacgia=?, namxuatban=?, gianhap=?, giagoc=?, "
					+ "giaban=?, soluong=?, matheloai=?, ngonngu=?, mota=?" + " WHERE masach=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenSach());
			st.setString(2, t.getTacGia().getMaTacGia());
			st.setInt(3, t.getNamXuatBan());
			st.setDouble(4, t.getGiaNhap());
			st.setDouble(5, t.getGiaGoc());
			st.setDouble(6, t.getGiaBan());
			st.setInt(7, t.getSoLuong());
			st.setString(8, t.getTheLoai().getMaTheLoai());
			st.setString(9, t.getNgonNgu());
			st.setString(10, t.getMoTa());
			st.setString(11, t.getMaSach());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}
