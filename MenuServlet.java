package com.tap;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String restaurantIDValue = request.getParameter("restaurantID");

		if (restaurantIDValue == null || restaurantIDValue.trim().isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/restaurant");
			return;
		}

		try {

			int restaurantID = Integer.parseInt(restaurantIDValue);

			MenuDAOImpl menuDAOImpl = new MenuDAOImpl();

			List<Menu> menuList = menuDAOImpl.getMenuByRestaurant(restaurantID);

			request.setAttribute("menuList", menuList);
			request.setAttribute("restaurantID", restaurantID);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/menu.jsp");

			requestDispatcher.forward(request, response);

		} catch (NumberFormatException e) {

			response.sendRedirect(request.getContextPath() + "/restaurant");
		}
	}
}