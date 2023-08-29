
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Agencia;
import logica.Controladora;
import logica.Matricula;
import logica.Vehiculo;

@WebServlet(name = "SvEditMatricula", urlPatterns = {"/SvEditMatricula"})
public class SvEditMatricula extends HttpServlet {

    Controladora control=new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditMarcas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditMarcas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Matricula mat = control.traerMatricula(id);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("matEditar", mat);
        
        response.sendRedirect("editarMatricula.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fechaStr = request.getParameter("fecha");
        String vehiculoStr = request.getParameter("vehiculo");
        String agenciaStr = request.getParameter("agencia");
        String anioStr = request.getParameter("anio");

        // Obtener el objeto Matricula de la sesión
        Matricula mat = (Matricula) request.getSession().getAttribute("matEditar");

        // Convertir las cadenas a los tipos de datos apropiados
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        int vehiculoId = 0;
        int agenciaId = 0;
        int anio = 0;

        try {
            fecha = dateFormat.parse(fechaStr);
            vehiculoId = Integer.parseInt(vehiculoStr);
            agenciaId = Integer.parseInt(agenciaStr);
            anio = Integer.parseInt(anioStr);
        } catch (ParseException | NumberFormatException e) {
            // Manejo de errores
            e.printStackTrace();
            // Puedes redirigir a una página de error si es necesario
            return;
        }

        // Actualizar los campos de la instancia de Matricula
        mat.setFecha(fecha);
        mat.setAnio(anio);

        // Obtener los objetos Vehiculo y Agencia por sus IDs
        Vehiculo vehiculo = control.traerVehiculo(vehiculoId);
        Agencia agencia = control.traerAgencia(agenciaId);

        // Actualizar los objetos Vehiculo y Agencia en la Matricula
        mat.setVehiculo(vehiculo);
        mat.setAgencia(agencia);

        // Guardar la instancia actualizada en la base de datos
        control.editarMatricula(mat);

        // Redirigir a la página de listado de matrículas u otra página apropiada
        response.sendRedirect("SvMatricula");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
