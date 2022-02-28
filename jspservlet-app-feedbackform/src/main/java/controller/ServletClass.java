package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FeedbackForm;
import service.FeedbackFormDao;



@WebServlet("/feedback")
public class ServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FeedbackFormDao feedbackDao;
	
	public void init() {
		feedbackDao = new FeedbackFormDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertFeedback(request, response);
				break;
			case "delete":
				deleteFeedback(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateFeedback(request, response);
				break;
			case "list":
				listFeedback(request, response);
				break;
			default:
				listFeedback(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listFeedback(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<FeedbackForm> listFeedback = feedbackDao.getAllFeedback();
		request.setAttribute("listFeedback", listFeedback);
		RequestDispatcher dispatcher = request.getRequestDispatcher("feedbackDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("feedbackIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int formId = Integer.parseInt(request.getParameter("formId"));
		FeedbackForm existingFeedback = feedbackDao.getFeedback(formId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("feedbackIndex.jsp");
		request.setAttribute("feedback", existingFeedback );
		dispatcher.forward(request, response);

	}

	private void insertFeedback(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String productName = request.getParameter("productName");
		String productQuality = request.getParameter("productQuality");
		String productWarranty = request.getParameter("productWarranty");
		String productRating = request.getParameter("productRating");
		
		FeedbackForm newFeedback = new FeedbackForm(productName, productQuality,productWarranty,productRating);
		feedbackDao.saveFeedback(newFeedback);
		response.sendRedirect("feedback?action=list");
	}

	private void updateFeedback(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int formId = Integer.parseInt(request.getParameter("formId"));
		String productName  = request.getParameter("productName");
		String productQuality = request.getParameter("productQuality");
		String productWarranty = request.getParameter("productWarranty");
		String productRating = request.getParameter("productRating");
		
		

		FeedbackForm feedback = new FeedbackForm(formId,productName, productQuality,productWarranty,productRating);
		
		
		feedbackDao.updateFeedback(feedback);
		response.sendRedirect("feedback?action=list");
	}

	private void deleteFeedback(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int formId = Integer.parseInt(request.getParameter("formId"));
		feedbackDao.deleteFeedback(formId);
		response.sendRedirect("feedback?action=list");
	}
}