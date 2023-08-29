package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Agencia;
import logica.Vehiculo;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-08-28T20:50:12")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Date> fecha;
    public static volatile SingularAttribute<Matricula, Integer> id;
    public static volatile SingularAttribute<Matricula, Vehiculo> vehiculo;
    public static volatile SingularAttribute<Matricula, Integer> anio;
    public static volatile SingularAttribute<Matricula, Agencia> agencia;

}