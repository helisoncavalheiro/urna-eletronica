package modelo;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Urna;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-12T02:55:58")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> idUser;
    public static volatile SingularAttribute<Usuario, String> loginUser;
    public static volatile SingularAttribute<Usuario, BigInteger> passwdUser;
    public static volatile SingularAttribute<Usuario, String> tipoUser;
    public static volatile SingularAttribute<Usuario, Urna> urnaUser;

}