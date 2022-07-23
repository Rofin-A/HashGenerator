/**
 * @classname computeHashServlet
 * @author rofin
 */
/*----------------------------------------------------------------------------- 
*  This class handles the HTTP request from the web application and handle them
*  Get method is implemented in this clss to capture user inputs and encrypt them
*  and add the encrypted message to the HTTP request and route it back to the
*  web application for rendering output
-------------------------------------------------------------------------------*/
package hash;

//Import required libraries 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;

public class computeHashServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * THIS METHOD IS NOT IMPLEMENTED
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
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet computeHashServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet computeHashServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
    /*------------------------------------------------------------------------
    The get method parses the incoming HTTP request,extracts the input string
    and uses the encryption method specified by the user to encrypt the input
    text. The encrypted text will then be converted to base 64 and hexadecimal
    notations and these notations will be added to HTTP request as attributes
    and routed back to the index.jsp, where the request will be parsed and the
    result will be rentdered
    --------------------------------------------------------------------------*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Parse the HTTP request and extract the the user inputs from index.jsp
        String txt = request.getParameter("inputStr");
        String hashMethod = request.getParameter("hash");
        String b64Binary = null;
        String hexadec = null;
        try {
            //Use Java Crypto API methods to encrypt the input text 
            //appropriate hash methods will be instantiated using the user input
            //the radio button value on index.jsp corresponds to the hash method
            MessageDigest algorithm = MessageDigest.getInstance(hashMethod);
            algorithm.update(txt.getBytes());
            byte[] hashed = algorithm.digest();

            //Convert the encrypted methods to base64 and hexadecimal notations
            b64Binary = javax.xml.bind.DatatypeConverter.printBase64Binary(hashed);
            hexadec = javax.xml.bind.DatatypeConverter.printHexBinary(hashed);

            //Pass the base64 and hexadecimal notations to the HTTP request
            request.setAttribute("base64", b64Binary);
            request.setAttribute("hexadec", hexadec);
        } catch (NoSuchAlgorithmException e) { //exception handling
            System.out.println("Unexpected Error finding the algorithm");
        }

        //pass the HTTP request back to index.jsp to render the output
        //String check = request.getAttribute("hexadec");
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);

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
