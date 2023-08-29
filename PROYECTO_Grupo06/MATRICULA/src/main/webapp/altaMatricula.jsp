<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>

<h1>Agregar Matricula</h1>
<form class="matricula" action="SvMatricula" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fecha" name="fecha"
                   placeholder="fecha">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="vehiculo" name="vehiculo"
                   placeholder="vehiculo">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="agencia" name="agencia"
                   placeholder="agencia">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="anio" name="anio"
                   placeholder="anio">
        </div>

    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Matricular
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
