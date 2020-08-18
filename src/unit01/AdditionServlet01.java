package unit01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit01.dao.TitleDao;
import unit01.dao.TitleDaoImpl;
import unit01.dto.Title;

/**
 * Servlet implementation class AdditionServlet01
 */
@WebServlet("/AdditionServlet01")
public class AdditionServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionServlet01() {
        super();
    }

	@Override
	public void init() throws ServletException {
		dao = TitleDaoImpl.getInstance();
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		Title newTitle = new Title(no, name);
		Title delTitle = new Title(no);
		
		List<Title> list = dao.selectTitleByAll();
		for (Title t : list) {
			System.out.println(t);
		}
		
		request.setAttribute("no", no);
		request.setAttribute("name", name);
//		request.setAttribute("add", add);
		request.setAttribute("list", list);
		
		dao.insertTitle(newTitle);
		for (Title t : list) {
			System.out.println(t);
		}
		
//		dao.deleteTitle(delTitle);
//		for (Title t : list) {
//			System.out.println(t);
//		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
