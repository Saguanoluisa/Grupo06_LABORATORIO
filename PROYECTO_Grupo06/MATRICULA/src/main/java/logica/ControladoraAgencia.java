package logica;

import java.util.List;
import persistencia.ControladoraPersistenciaAgencia;

public class ControladoraAgencia {
    ControladoraPersistenciaAgencia controlPersisAgencia = new ControladoraPersistenciaAgencia();
    
    public List <Agencia> getAgencia() {
        return controlPersisAgencia.getAgencia();
    }
}
