/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.io.IOException;
import java.io.PrintWriter;
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
public class book extends HttpServlet {

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
            out.println("<title>Servlet book</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet book at " + request.getContextPath() + "</h1>");
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
        PrintWriter out=response.getWriter();
        Logger logger = Logger.getLogger(book.class.getName());
        
        String b = request.getParameter("act");
        String bn=request.getParameter("bookname");
        
        HttpSession session=request.getSession(false);
        String n=(String)session.getAttribute("name");
        
        if(b.equals("Borrow")){
            out.println("<h4 style=\"font-family: cursive;font-size: 30px;text-align:center;height:40px; line-height:40px;\"> Borrowed successfully,thank you for your reading. </h4><br>");
            logger.info(n+"\t"+bn+"\tBorrowed");
        }else if (b.equals("Return")){
            out.println("<h4 style=\"font-family: cursive;font-size: 30px;text-align:center;height:40px; line-height:40px;\"> Returned successfully,thank you for your reading. </h4><br>");
            logger.info(n+"\t"+bn+"\tReturned");
        }
        out.println("<div style=\"text-align:center;height:40px; line-height:40px;\"><a href=\"home.jsp\" style=\"font-size: 35px;font-family: cursive;\">Click here to continue</a></div>");
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
