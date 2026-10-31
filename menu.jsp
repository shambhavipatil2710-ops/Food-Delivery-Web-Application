<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.tap.model.Menu"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0">

<title>Craveo | Menu</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/menu.css">

</head>

<body>

	<div class="navbar">

		<div>
			<strong>Craveo</strong>
		</div>

		<div>

			<a href="<%=request.getContextPath()%>/restaurant">
				Home
			</a>

			<a href="<%=request.getContextPath()%>/login.jsp">
				Login
			</a>

			<a href="<%=request.getContextPath()%>/register.jsp">
				Sign Up
			</a>

			<a href="#">
				Cart
			</a>

			<a href="#">
				Profile
			</a>

		</div>

	</div>


	<div class="menu-header">

		<h1>Explore Menu</h1>

		<p>
			Choose your favourite food and add it to your cart.
		</p>

	</div>


	<div class="menu-grid">

		<%

		List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");


		if (menuList != null && !menuList.isEmpty()) {


			for (Menu menu : menuList) {

		%>


		<div class="menu-card">


			<img
				src="<%=request.getContextPath()%>/<%=menu.getImagePath().replace("\\", "/")%>"

				alt="<%=menu.getItemName()%>">


			<div class="menu-info">


				<span class="category">

					<%=menu.getCategory()%>

				</span>


				<h2>

					<%=menu.getItemName()%>

				</h2>


				<p class="description">

					<%=menu.getDescription()%>

				</p>


				<div class="price-row">


					<span class="price">

						₹<%=menu.getPrice()%>

					</span>


					<%

					if (menu.IsAvailable()) {

					%>


					<span class="available">

						Available

					</span>


					<%

					} else {

					%>


					<span class="not-available">

						Unavailable

					</span>


					<%

					}

					%>


				</div>


				<%

				if (menu.IsAvailable()) {

				%>


				<form
					action="<%=request.getContextPath()%>/cart"

					method="post">


					<input
						type="hidden"

						name="menuID"

						value="<%=menu.getMenuID()%>">


					<input
						type="hidden"

						name="restaurantID"

						value="<%=menu.getRestaurantID()%>">


					<input
						type="hidden"

						name="quantity"

						value="1">


					<button
						type="submit"

						class="add-button">

						Add to Cart

					</button>


				</form>


				<%

				} else {

				%>


				<button
					type="button"

					class="disabled-button"

					disabled>

					Not Available

				</button>


				<%

				}

				%>


			</div>


		</div>


		<%

			}

		} else {

		%>


		<div class="empty-message">


			<h2>

				No menu items available

			</h2>


			<p>

				This restaurant currently has no menu items.

			</p>


			<a href="<%=request.getContextPath()%>/restaurant">

				Back to Restaurants

			</a>


		</div>


		<%

		}

		%>


	</div>


	<div class="footer">

		&copy; 2026 Craveo. All rights reserved.

	</div>


</body>
</html>