/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.io.IOException;
import java.io.PrintWriter;
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
public class jump extends HttpServlet {

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
            out.println("<title>Servlet jump</title>");            
            out.println("</head>");
            out.println("<body>");
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
        String t= (String) request.getParameter("t");
        Logger logger = Logger.getLogger(jump.class.getName());
        
        HttpSession session=request.getSession(false);
        String n=(String)session.getAttribute("name");
        
        if(t.equals("Home")){
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("Fiction")){
            RequestDispatcher rd = request.getRequestDispatcher("fiction.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("Science")){
            RequestDispatcher rd = request.getRequestDispatcher("science.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("Economic")){
            RequestDispatcher rd = request.getRequestDispatcher("economic.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("Life")){
            RequestDispatcher rd = request.getRequestDispatcher("life.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("Art")){
            RequestDispatcher rd = request.getRequestDispatcher("art.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("Biography")){
            RequestDispatcher rd = request.getRequestDispatcher("biography.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("user")){
            RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("information")){
            RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
            rd.forward(request, response);
            logger.info("user: "+n+"\tview\t"+t);
        }
        if(t.equals("logout")){
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
            logger.info("user: "+n + "\tlogout"+"\tsucceed");
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
