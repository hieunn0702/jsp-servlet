package model;

import java.sql.Date;

public class KhachHang {
	private String maKhachHang;
	private String userName;
	private String password;
	private String hoVaTen;
	private String gioiTinh;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private boolean dangKyNhanBanTin;
	private String maXacThuc;
	private Date thoiGianHieuLucMaXacThuc;
	private boolean trangThaiXacThuc;
	private String duongDanAnh;

	public KhachHang() {
	}

	public KhachHang(String maKhachHang, String userName, String password, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBanTin) {
		this.maKhachHang = maKhachHang;
		this.userName = userName;
		this.password = password;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBanTin = dangKyNhanBanTin;
	}

	public KhachHang(String maKhachHang, String userName, String password, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBanTin, String maXacThuc, Date thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc) {
		super();
		this.maKhachHang = maKhachHang;
		this.userName = userName;
		this.password = password;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBanTin = dangKyNhanBanTin;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public KhachHang(String maKhachHang, String userName, String password, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBanTin, String maXacThuc, Date thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc,
			String duongDanAnh) {
		super();
		this.maKhachHang = maKhachHang;
		this.userName = userName;
		this.password = password;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBanTin = dangKyNhanBanTin;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.duongDanAnh = duongDanAnh;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDangKyNhanBanTin() {
		return dangKyNhanBanTin;
	}

	public void setDangKyNhanBanTin(boolean dangKyNhanBanTin) {
		this.dangKyNhanBanTin = dangKyNhanBanTin;
	}

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Date getThoiGianHieuLucMaXacThuc() {
		return thoiGianHieuLucMaXacThuc;
	}

	public void setThoiGianHieuLucMaXacThuc(Date thoiGianHieuLucMaXacThuc) {
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public String getDuongDanAnh() {
		return duongDanAnh;
	}

	public void setDuongDanAnh(String duongDanAnh) {
		this.duongDanAnh = duongDanAnh;
	}

}
