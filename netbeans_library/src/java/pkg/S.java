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
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Meruem
 */
public class S extends HttpServlet {

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
            out.println("<title>Servlet S</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet S at " + request.getContextPath() + "</h1>");
            /*String s = "2019-11-02 00:40:48 ERROR S:49 - bookname  ";
                 String [] ss =s.split("\t");
                 for(String s1:ss){
                     out.println(s1+"<br>");
                 }
             */
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
        processRequest(request, response);
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
        try {
            //processRequest(request, response);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            Logger logger = Logger.getLogger(S.class.getName());

            String n = request.getParameter("name");
            String p = request.getParameter("password");

            HttpSession session = request.getSession();
            session.setAttribute("name", n);

            Connection con = connection.getConnection();

            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql = "select * from user_info where username=? and passwd=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, n);
            pst.setString(2, p);
            rs = pst.executeQuery();
            if (rs.next()) {
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
                logger.info("user: " + n + "\tlogin"+"\tsucceed");
            } else if (n.length() == 0) {
                out.println("<h3 style=\"color:blue;font-family:Segoe Print;font-size: 25px\">Sorry , username can not be empty</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.include(request, response);
                logger.warn("user: " + n + "\tlogin"+"\tfail");
            } else if (p.length() == 0) {
                out.println("<h3 style=\"color:blue;font-family:Segoe Print;font-size: 25px\">Sorry , password can not be empty</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.include(request, response);
                logger.warn("user: " + n + "\tlogin"+"\tfail");
            } else {
                out.println("<h3 style=\"color:blue;font-family:Segoe Print;font-size: 25px\">Sorry , incorrect username or password </h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.include(request, response);
                logger.warn("user: " + n + "\tlogin"+"\tfail");
            }

            /*
            if(p.equals("123456")){
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
            logger.info(n + "\tsuccessfully login");
            }
            else{
            out.println("<h2 style=\"color:white;font-family:Segoe Print;font-size: 25px\">Sorry,incorrect username or password </h2>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.include(request, response);
            logger.error(n + "\tlogin failed");
            }
             */
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(S.class.getName()).log(Level.SEVERE, null, ex);
        }

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
