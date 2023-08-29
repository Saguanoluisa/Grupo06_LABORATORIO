package logica;

import java.util.List;
import persistencia.ControladoraPersistenciaVehiculo;

public class ControladoraVehiculo {
    ControladoraPersistenciaVehiculo controlPersisVehiculo = new ControladoraPersistenciaVehiculo();
    
    public List <Vehiculo> getVehiculo() {
        return controlPersisVehiculo.getVehiculo();
    }
}
