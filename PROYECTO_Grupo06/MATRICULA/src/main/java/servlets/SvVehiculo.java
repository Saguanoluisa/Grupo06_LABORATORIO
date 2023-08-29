package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraVehiculo;
import logica.Vehiculo;

@WebServlet(name = "SvVehiculo", urlPatterns = {"/SvVehiculo"})
public class SvVehiculo extends HttpServlet {
    
    ControladoraVehiculo control=new ControladoraVehiculo();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvVehiculo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvVehiculo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos = control.getVehiculo();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaVehiculos", listaVehiculos);
                
        response.sendRedirect("verVehiculo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
