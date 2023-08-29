<%@page import="logica.Matricula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>

<h1>Editar Matricula</h1>
<%Matricula mat = (Matricula)request.getSession().getAttribute("matEditar");%>
<form class="matricula" action="SvEditMatricula" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fecha" name="fecha"
                   value="<%=mat.getFecha()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="vehiculo" name="vehiculo"
                   value="<%=mat.getVehiculo()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="agencia" name="agencia"
                   value="<%=mat.getAgencia()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="anio" name="anio"
                   value="<%=mat.getAnio()%>">
        </div>

    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar
    </button>

</form>
<script>
    $(document).ready(function () {
        $("#fecha").datepicker({
            dateFormat: "yy-mm-dd"
        });
    });
</script>
<%@include file="components/bodyfinal.jsp"%>
