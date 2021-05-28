/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import c.connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Meruem
 */
public class change extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet change</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet change at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html");
        Logger logger = Logger.getLogger(change.class.getName());

        try (PrintWriter out = response.getWriter()) {
            Connection con = connection.getConnection();

            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String age = request.getParameter("age");
            String balance = request.getParameter("balance");
            String books = request.getParameter("books");

            String sql5 = "update user_info set email = ? , passwd = ? , phonenumber = ? , age = ? , balace = ? ,books = ? where username= ? ";
            PreparedStatement ps;
            ps = con.prepareStatement(sql5);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, phone);
            ps.setString(4, age);
            ps.setString(5, balance);
            ps.setString(6, books);
            ps.setString(7, name);

            int num = ps.executeUpdate();
            if (num > 0) {
                out.println("Change successfully <br>");
                out.println("<a href=\"4.jsp\"> Back </a>");
                logger.info("user: "+name + "\tchange"+"\tsucceed");
            } else {
                out.println("Something went wrong <br>");
                out.println("<a href=\"4.jsp\"> Back </a>");
                logger.warn("user: "+name + "\tchange"+"\tfail");
            }

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
