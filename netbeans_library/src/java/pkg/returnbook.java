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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
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
public class returnbook extends HttpServlet {

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
            out.println("<title>Servlet returnbook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet returnbook at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Logger logger = Logger.getLogger(returnbook.class.getName());
        try {
            Connection con = connection.getConnection();
            String username = request.getParameter("un");
            String booknum = request.getParameter("bn");
            PreparedStatement ps;
            String sql1 = "delete from borrowed_info where username = ? and num = ?";
            String sql2 = "update user_info set books = books-1 where username = ?";
            ps = con.prepareStatement(sql1);
            ps.setString(2, booknum);
            ps.setString(1, username);
            int n = ps.executeUpdate();
            ps = con.prepareStatement(sql2);
            ps.setString(1, username);
            int m = ps.executeUpdate();
            if (n>0 && m>0) {
                RequestDispatcher rd = request.getRequestDispatcher("9.jsp");
                rd.include(request, response);
                logger.info("user: "+username+"\treturn"+"\tsucceed");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("9.jsp");
                rd.include(request, response);
                logger.warn("user: "+username+"\treturn\t"+"fail");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(Level.SEVERE, null, ex);
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
