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
 * Servlet implementation class edit
 */
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		BanHangDao bh = new BanHangDao();
		BanHangModel s = bh.getBanHang(id);
		request.setAttribute("s", s);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BanHangDao bh = new BanHangDao();
		int id = Integer.parseInt(request.getParameter("id"));
		String tenhang = request.getParameter("tenhang");
		String ngaynhap = request.getParameter("ngaynhap");
		String nhomhang = request.getParameter("nhomhang");
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		BanHangModel banhang = new BanHangModel(id,tenhang,ngaynhap,nhomhang,soluong);
		bh.edit(banhang);
		response.sendRedirect("load");
	}

}
