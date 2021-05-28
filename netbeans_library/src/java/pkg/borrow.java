/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import c.connection;
import hbase.Hbase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Meruem
 */
public class borrow extends HttpServlet {

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
            out.println("<title>Servlet borrow</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet borrow at " + request.getContextPath() + "</h1>");
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
        Logger logger = Logger.getLogger(borrow.class.getName());
        HttpSession s = request.getSession(false);
        try {
            Connection con = connection.getConnection();

            String username = (String) s.getAttribute("name");
            String phonenumber = null;

            String str = null;
            int age=0;
            PreparedStatement p;
            str = "select * from user_info where username = ?";
            p = con.prepareStatement(str);
            p.setString(1, username);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                phonenumber = rs.getString(4);
                age = rs.getInt(5);
            }

            String num = request.getParameter("num");
            String bookname = request.getParameter("bookname");
            String category = request.getParameter("category");
            int overdue = 0;

            String sql = null, sql2 = null, sql3 = null;
            PreparedStatement ps = null;

            sql = "update user_info set books= books+1 where username = ?;";
            sql2 = "update book_info set ava= ava-1 where num = ?;";
            sql3 = "insert into borrowed_info values (?,?,?,?,?,?,?,?);";

            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            int rs1 = ps.executeUpdate();

            ps = con.prepareStatement(sql2);
            ps.setString(1, num);
            int rs2 = ps.executeUpdate();

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            Date date = new Date();
            String date2 = df.format(new Date(date.getTime() + (long) 3 * 24 * 60 * 60 * 1000));//三天后的日期

            ps = con.prepareStatement(sql3);
            ps.setString(1, num);
            ps.setString(2, bookname);
            ps.setString(3, category);
            ps.setString(4, username);
            ps.setString(5, phonenumber);
            ps.setDate(6, new java.sql.Date(date.getTime()));
            ps.setString(7, date2);
            ps.setInt(8, overdue);

            int rs3 = ps.executeUpdate();

            if (rs1 > 0 && rs2 > 0 && rs3 > 0) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Borrow</title>");
                out.println("</head>");
                out.println("<body style=\"background-color: #F5DEB3;\">");
                out.println("<h4 style=\"font-family: cursive;font-size: 30px;text-align:center;height:40px; line-height:40px;\"> Borrowed successfully,thank you for your reading. </h4><br>");
                out.println("<div style=\"text-align:center;height:40px; line-height:40px;\"><a href=\"home.jsp\" style=\"font-size: 35px;font-family: cursive;\">Click here to continue</a></div>");
                out.println("</body>");
                out.println("</html>");
                logger.info("user: " + username + "\tborrow\t" + bookname);   
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
            String dt = sdf.format(date);
            
            SimpleDateFormat hour = new SimpleDateFormat("HH");
            String hh = hour.format(date);
            
            String a = Integer.toString(age);
            
            Hbase h = new Hbase();
            h.updateTable("logs",dt,"cf","username",username);
            h.updateTable("logs",dt,"cf","age",a);
            h.updateTable("logs",dt,"cf","bookname",bookname);
            h.updateTable("logs",dt,"cf","booktype",category);
            h.updateTable("logs",dt,"cf","time",hh);
            
        } catch (SQLException e) {
            e.printStackTrace();
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
