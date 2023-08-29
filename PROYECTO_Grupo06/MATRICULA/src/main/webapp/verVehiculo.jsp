<!DOCTYPE html>

<%@page import="java.util.List"%>
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
            <h6 class="m-0 font-weight-bold text-primary">Vehiculo</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>placa</th>
                            <th>marca</th>
                            <th>motor</th>
                            <th>chasis</th>
                            <th>combustible</th>
                            <th>anio</th>
                            <th>color</th>
                            <th>foto</th>
                            <th>avaluo</th>
                        </tr>
                    </thead>
                    <%
                        String contextPath = request.getContextPath();
                        List<Vehiculo> listaVehiculos = (List) request.getSession().getAttribute("listaVehiculos");
                    %>
                    <tbody>
                        <%for (Vehiculo veh : listaVehiculos) {%>
                        <tr>
                            <td><%=veh.getId()%></td>
                            <td><%=veh.getPlaca()%></td>
                            <td><%=veh.getMarca()%></td>
                            <td><%=veh.getMotor()%></td>
                            <td><%=veh.getChasis()%></td>
                            <td><%=veh.getCombustible()%></td>
                            <td><%=veh.getAnio()%></td>
                            <td><%=veh.getColor()%></td>
                            <td><img src="<%= contextPath + "/imagenes/" + veh.getFoto() %>" alt="Foto de la agencia" width="200"></td>
                            <td><%=veh.getAvaluo()%></td>
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

