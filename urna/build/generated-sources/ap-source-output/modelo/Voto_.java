package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Chapa;
import modelo.Urna;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-05T20:03:30")
@StaticMetamodel(Voto.class)
public class Voto_ { 

    public static volatile SingularAttribute<Voto, Integer> idVoto;
    public static volatile SingularAttribute<Voto, Date> dataVoto;
    public static volatile SingularAttribute<Voto, Chapa> idChapaVoto;
    public static volatile SingularAttribute<Voto, Urna> idUrna;

}