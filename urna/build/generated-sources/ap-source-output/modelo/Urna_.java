package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Eleitor;
import modelo.Usuario;
import modelo.Voto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-12T02:55:58")
@StaticMetamodel(Urna.class)
public class Urna_ { 

    public static volatile SingularAttribute<Urna, Integer> zona;
    public static volatile ListAttribute<Urna, Voto> votoList;
    public static volatile ListAttribute<Urna, Eleitor> eleitorList;
    public static volatile ListAttribute<Urna, Usuario> usuarioList;
    public static volatile SingularAttribute<Urna, String> presidenteSecao;
    public static volatile SingularAttribute<Urna, Integer> secao;
    public static volatile SingularAttribute<Urna, Integer> idUrna;

}