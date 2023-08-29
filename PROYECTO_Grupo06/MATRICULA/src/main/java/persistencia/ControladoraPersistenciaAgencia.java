package persistencia;

import java.util.List;
import logica.Agencia;

public class ControladoraPersistenciaAgencia {
    AgenciaJpaController ageJPA = new AgenciaJpaController();

    public List<Agencia> getAgencia() {
        return ageJPA.findAgenciaEntities();
    }
}
