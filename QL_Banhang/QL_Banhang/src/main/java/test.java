import java.util.List;

import Dao.BanHangDao;
import Model.BanHangModel;

public class test {
	public static void main(String[] args) {
		BanHangDao bh = new BanHangDao();
		List<BanHangModel> list = bh.getAllBanHang();
	
		for (BanHangModel o : list) { System.out.println(o); }
	}	
}
