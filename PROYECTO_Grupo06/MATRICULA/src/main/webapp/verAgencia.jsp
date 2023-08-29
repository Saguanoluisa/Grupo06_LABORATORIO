<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="logica.Agencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
    
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Agencia</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>descripcion</th>
                            <th>direccion</th>
                            <th>telefono</th>
                            <th>hora inicio</th>
                            <th>hora final</th>
                            <th>foto</th> 
                        </tr>
                    </thead>
                    
                    <%
                        String contextPath = request.getContextPath();
                        List<Agencia> listaAgencias = (List) request.getSession().getAttribute("listaAgencias");
                    %>
                    <tbody>
    <% for (Agencia age : listaAgencias) { %>
    <tr>
        <td><%= age.getId() %></td>
        <td><%= age.getDescripcion() %></td>
        <td><%= age.getDireccion() %></td>
        <td><%= age.getTelefono() %></td>
        <td><%= age.getHorainicio() %></td>
        <td><%= age.getHorafin() %></td>
        <td><img src="<%= contextPath + "/imagenes/" + age.getFoto() %>" alt="Foto de la agencia" width="200"></td>
    </tr>
    <% } %>
</tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->


<%@include file="components/bodyfinal.jsp"%>

