package Model;

public class BanHangModel {
	int id;
	String tenhang;
	String ngaynhap;
	String nhomhang;
	int soluong;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTenhang() {
		return tenhang;
	}


	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}


	public String getNgaynhap() {
		return ngaynhap;
	}


	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}


	public String getNhomhang() {
		return nhomhang;
	}


	public void setNhomhang(String nhomhang) {
		this.nhomhang = nhomhang;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	public BanHangModel(int id, String tenhang, String ngaynhap, String nhomhang, int soluong) {
		super();
		this.id = id;
		this.tenhang = tenhang;
		this.ngaynhap = ngaynhap;
		this.nhomhang = nhomhang;
		this.soluong = soluong;
	}
	
	public BanHangModel(String tenhang, String ngaynhap, String nhomhang, int soluong) {
		super();
		this.tenhang = tenhang;
		this.ngaynhap = ngaynhap;
		this.nhomhang = nhomhang;
		this.soluong = soluong;
	}


	public BanHangModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "BanHangModel [id=" + id + ", tenhang=" + tenhang + ", ngaynhap=" + ngaynhap + ", nhomhang=" + nhomhang
				+ ", soluong=" + soluong + "]";
	}
	
	
}
