package persistencia;

import java.util.List;
import logica.Vehiculo;

public class ControladoraPersistenciaVehiculo {
    VehiculoJpaController vehJPA = new VehiculoJpaController();

    public List<Vehiculo> getVehiculo() {
        return vehJPA.findVehiculoEntities();
    }
}
