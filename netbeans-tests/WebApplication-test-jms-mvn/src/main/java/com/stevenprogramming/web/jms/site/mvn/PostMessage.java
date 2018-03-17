package com.stevenprogramming.web.jms.site.mvn;

import ejb.NewsEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author steven.mendez
 * @since Dec 22 2017
 * @version 1.0
 */
@WebServlet(name = "PostMessage", urlPatterns = {"/PostMessage"})
public class PostMessage extends HttpServlet {

    @Resource(mappedName = "jms/NewMessageFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/NewMessage")
    private javax.jms.Queue queue;
    
    @Resource(mappedName = "jms/NewMessage2")
    private javax.jms.Queue queue2;

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
        // Add the following code to send the JMS message
        String title = request.getParameter("title");
        String body = request.getParameter("body");
        if ((title != null) && (body != null)) {
            try {
                javax.jms.Connection connection = connectionFactory.createConnection();
                javax.jms.Session session = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue);
                MessageProducer messageProducer2 = session.createProducer(queue2);

                ObjectMessage message = session.createObjectMessage();
                // here we create NewsEntity, that will be sent in JMS message
                NewsEntity e = new NewsEntity();
                e.setTitle(title);
                e.setBody(body);

                message.setObject(e);
                messageProducer.send(message);
                messageProducer.close();
                messageProducer2.send(message);
                messageProducer2.close();
                connection.close();
                response.sendRedirect("ListNews");

            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }

        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet PostMessage</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet PostMessage at " + request.getContextPath() + "</h1>");
        // The following code adds the form to the web page
        out.println("<form>");
        out.println("Title: <input type='text' name='title'><br/>");
        out.println("Message: <textarea name='body'></textarea><br/>");
        out.println("<input type='submit'><br/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
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
