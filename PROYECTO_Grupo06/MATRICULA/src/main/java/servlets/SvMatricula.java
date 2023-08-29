package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Matricula;

@WebServlet(name = "SvMatricula", urlPatterns = {"/SvMatricula"})
public class SvMatricula extends HttpServlet {
    Controladora control=new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvMatricula</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvMatricula at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Matricula> listaMatriculas = new ArrayList<Matricula>();
        listaMatriculas = control.getMatricula();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaMatriculas", listaMatriculas);
                
        response.sendRedirect("verMatricula.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fechaStr = request.getParameter("fecha");
        String vehiculoStr = request.getParameter("vehiculo");
        String agenciaStr = request.getParameter("agencia");
        String anioStr = request.getParameter("anio");

        Date fecha = null;
        int vehiculo = 0;
        int agencia = 0;
        int anio = 0;

        try {
            fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
            vehiculo = Integer.parseInt(vehiculoStr);
            agencia = Integer.parseInt(agenciaStr);
            anio = Integer.parseInt(anioStr);
        } catch (ParseException | NumberFormatException e) {
            // Manejo de errores de conversión
            e.printStackTrace(); // O manejo de error adecuado
        }
        
        control.crearMatricula(fecha, vehiculo, agencia, anio);
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}