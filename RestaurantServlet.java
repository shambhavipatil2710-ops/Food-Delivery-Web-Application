package com.tap;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // 1. Create DAO object
	        RestaurantDAOImpl restaurantDAOImpl = new RestaurantDAOImpl();

	        // 2. Call getAllRestaurants() to fetch data from the DB
	        List<Restaurant> allRestaurants = restaurantDAOImpl.getAllRestaurant();

	        // (Debug step used in class to confirm data was fetched)
	        for (Restaurant restaurant : allRestaurants) {
	            System.out.println(restaurant);
	        }

	        // 3. Store the list on the request object so the JSP page can access it
	        request.setAttribute("allRestaurant", allRestaurants);

	        // 4. Forward (NOT redirect) to the JSP — same request object carries the data
	        RequestDispatcher rd = request.getRequestDispatcher("restaurant.jsp");
	        rd.forward(request, response);
	    }

}
