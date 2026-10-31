package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/session")
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            out.print("{\"loggedIn\":false}");
        } else {
            String username = (String) session.getAttribute("username");
            String email = (String) session.getAttribute("email");
            String address = (String) session.getAttribute("address");
            
            out.print("{" +
                "\"loggedIn\":true," +
                "\"username\":\"" + escapeJson(username) + "\"," +
                "\"email\":\"" + escapeJson(email) + "\"," +
                "\"address\":\"" + escapeJson(address) + "\"" +
                "}");
        }
        out.flush();
    }
    
    private String escapeJson(String str) {
        if (str == null) return "";
        return str.replace("\\", "\\\\")
                  .replace("\"", "\\\"")
                  .replace("\b", "\\b")
                  .replace("\f", "\\f")
                  .replace("\n", "\\n")
                  .replace("\r", "\\r")
                  .replace("\t", "\\t");
    }
}
