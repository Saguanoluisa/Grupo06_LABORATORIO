package logica;

import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearMatricula(Date fecha, int vehiculoId, int agenciaId, int anio){
        Matricula mat = new Matricula();
        mat.setFecha(fecha);

        Vehiculo vehiculo = controlPersis.getVehiculoById(vehiculoId);
        Agencia agencia = controlPersis.getAgenciaById(agenciaId);
        
        mat.setVehiculo(vehiculo);
        mat.setAgencia(agencia);
        
        mat.setAnio(anio);
        controlPersis.crearMatricula(mat);   
    }

    public List <Matricula> getMatricula() {
        return controlPersis.getMatricula();
    }
    public void borrarMatricula(int id) {
        controlPersis.borrarMatricula(id);
    }
    
    public Matricula traerMatricula(int id) {        
        return controlPersis.traerMatricula(id);
    }

    public void editarMatricula(Matricula mat) {
        controlPersis.EditarMatricula(mat);
    }

    public Vehiculo traerVehiculo(int id) {
        return controlPersis.getVehiculoById(id);
    }
    
    public Agencia traerAgencia(int id) {
        return controlPersis.getAgenciaById(id);
    }
}