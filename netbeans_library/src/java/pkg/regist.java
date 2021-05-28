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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class regist extends HttpServlet {

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
            out.println("<title>Servlet regist</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet regist at " + request.getContextPath() + "</h1>");
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
            Logger logger = Logger.getLogger(regist.class.getName());
            String n = request.getParameter("name");
            String p = request.getParameter("password");
            String p2 = request.getParameter("password2");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String age = request.getParameter("age");
            String balance = request.getParameter("balance");
            int a, b;
            a = Integer.parseInt(age);
            b = Integer.parseInt(balance);
            Connection con = connection.getConnection();

            String sql3 = "select * from user_info where username=?";
            PreparedStatement pt;
            pt = con.prepareStatement(sql3);
            pt.setString(1, n);
            ResultSet rs3 = pt.executeQuery();
            if (rs3.next()) {
                out.println("<h2 style=\"color:white;font-family:Segoe Print;font-size: 25px\">Username has already existed</h2>");
                RequestDispatcher rd = request.getRequestDispatcher("/regist.jsp");
                rd.include(request, response);
                logger.warn("user: "+n + "\tregist"+"\tfail");
            }
            String uu, regex2;
            Pattern pattern2;
            Matcher matcher2;
            uu = p;
            regex2 = "[a-zA-Z0-9]{6,15}";
            pattern2 = Pattern.compile(regex2);
            matcher2 = pattern2.matcher(uu);
            if (!matcher2.matches()) {
                out.println("<h2 style=\"color:white;font-family:Segoe Print;font-size: 25px\">Password should be between 6 and 15 characters</h2>");
                RequestDispatcher rd = request.getRequestDispatcher("/regist.jsp");
                rd.include(request, response);
                logger.warn("user: "+n + "\tregist"+"\tfail");
            }
            if (p.equals(p2)) {
                try {
                    PreparedStatement ps;
                    String str = "INSERT INTO user_info(username,passwd,email,phone,age) VALUES (?,?,?,?,?,?,?)";
                    ps = con.prepareStatement(str);
                    ps.setString(1, n);
                    ps.setString(2, p);
                    ps.setString(3, email);
                    ps.setString(4, phone);
                    ps.setInt(5, a);
                    ps.setInt(6, b);
                    ps.setInt(7, 0);
                    int rt = ps.executeUpdate();
                    if (rt > 0) {
                        logger.info("user: "+n + "\tregist"+"\tsucceed");
                        out.println("<h2 style=\"color:white;font-family:Segoe Print;font-size: 25px\">Regist successfully , please login </h2>");
                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.forward(request, response);
                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(regist.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                out.println("<h2 style=\"color:white;font-family:Segoe Print;font-size: 25px\">Two passwords differ</h2>");
                RequestDispatcher rd = request.getRequestDispatcher("/regist.jsp");
                rd.include(request, response);
                logger.warn("user: "+n + "\tregist"+"\tfail");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(regist.class.getName()).log(Level.SEVERE, null, ex);
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
