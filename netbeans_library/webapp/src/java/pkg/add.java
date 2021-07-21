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
public class add extends HttpServlet {

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
            out.println("<title>Servlet add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add at " + request.getContextPath() + "</h1>");
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
        Logger logger = Logger.getLogger(add.class.getName());

        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String date = request.getParameter("date");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String tnum = request.getParameter("tnum");
        String anum = request.getParameter("anum");

        int a, b, c;
        a = Integer.parseInt(price);
        b = Integer.parseInt(tnum);
        c = Integer.parseInt(anum);

        try {
            Connection con = connection.getConnection();

            PreparedStatement ps;
            String str = "INSERT INTO book_info(num,bookname,author,putdate,category,price,total,ava) VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(str);
            ps.setString(1,no);
            ps.setString(2,name);
            ps.setString(3,author);
            ps.setString(4,date);
            ps.setString(5,category);
            ps.setInt(6, a);
            ps.setInt(7, b);
            ps.setInt(8, c);
            int rt = ps.executeUpdate();
            if (rt > 0) {
                logger.info("book: "+name + "\tadd"+"\tsucceed");
                RequestDispatcher rd = request.getRequestDispatcher("1.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
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
