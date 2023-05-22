package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dao.BanHangDao;
import Model.BanHangModel;

/**
 * Servlet implementation class create
 */
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BanHangDao bh = new BanHangDao();
		String tenhang = request.getParameter("tenhang");
		String ngaynhap = request.getParameter("ngaynhap");
		String nhomhang = request.getParameter("nhomhang");
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		BanHangModel banhang = new BanHangModel(tenhang,ngaynhap,nhomhang,soluong);
		bh.addBanHang(banhang);
		response.sendRedirect("load");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
