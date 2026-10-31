<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.Restaurant"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Craveo- All Restaurants</title>

<link rel="stylesheet"
	href="<%= request.getContextPath() %>/css/restaurant.css">

</head>

<body>
<video class="background-video" autoplay muted loop playsinline>
	<source
		src="<%=request.getContextPath()%>/videos/restaurant-bg.mp4"
		type="video/mp4">
</video>

<div class="video-overlay"></div>

	<div class="navbar">

		<div>
			<strong>Craveo</strong>
		</div>

		<div>
			<a href="<%= request.getContextPath() %>/restaurant">Home</a>

			<a href="<%= request.getContextPath() %>/login.jsp">Login</a>

			<a href="<%= request.getContextPath() %>/register.jsp">Sign Up</a>

			<a href="#">Cart</a>

			<a href="#">Profile</a>
		</div>

	</div>

	<div class="restaurant-grid">

		<%
		List<Restaurant> allRestaurant =
				(List<Restaurant>) request.getAttribute("allRestaurant");

		if (allRestaurant != null) {

			for (Restaurant restaurant : allRestaurant) {
		%>

		<a class="restaurant-link"
			href="<%= request.getContextPath() %>/menu?restaurantID=<%= restaurant.getRestaurantID() %>">

			<div class="restaurant-card">

				<img
					src="<%= request.getContextPath() %>/<%= restaurant.getImagePath().replace("\\", "/") %>"
					alt="<%= restaurant.getName() %>">

				<div class="restaurant-info">

					<h2><%= restaurant.getName() %></h2>

					<div class="details">

						<span class="rating">
							★ <%= restaurant.getRating() %>
						</span>

						<span class="time">
							<%= restaurant.getDeliveryTime() %> mins
						</span>

					</div>

					<p class="cuisine">
						<%= restaurant.getCuisineType() %>
					</p>

					<p class="address">
						<%= restaurant.getAddress() %>
					</p>

				</div>

			</div>

		</a>

		<%
			}
		}
		%>

	</div>

	<div class="footer">
		&copy; 2026 Craveo. All rights reserved.
	</div>

</body>
</html>