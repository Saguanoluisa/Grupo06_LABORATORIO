<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="logica.Matricula"%>
<%@page import="logica.Vehiculo"%>
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
            <h6 class="m-0 font-weight-bold text-primary">Matriculas</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>fecha</th>
                            <th>vehiculo</th>
                            <th>agencia</th>
                            <th>anio</th>  
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <%
                        List<Matricula> listaMatriculas = (List) request.getSession().getAttribute("listaMatriculas");
                    %>
                    <tbody>
                        <%for (Matricula mat : listaMatriculas) {%>
                        <tr>
                            <td><%=mat.getId()%></td>
                            <td><%=mat.getFecha()%></td>
                            <td><%= mat.getVehiculo().getPlaca() %></td>
                            <td><%= mat.getAgencia().getDescripcion() %></td>
                            <td><%=mat.getAnio()%></td>
                            <td style="display: flex; width: 250px;">
                                <form name="eliminar" action="SvElimMatricula" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i>Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%=mat.getId()%>">                                    
                                </form>
                                <form name="editar" action="SvEditMatricula" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i>Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%=mat.getId()%>">                                    
                                </form>             
                            </td>
                        </tr>   
                        <% }%>
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