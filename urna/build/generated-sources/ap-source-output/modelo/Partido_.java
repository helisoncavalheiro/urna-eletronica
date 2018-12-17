package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Candidato;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-17T14:49:36")
@StaticMetamodel(Partido.class)
public class Partido_ { 

    public static volatile SingularAttribute<Partido, String> nomePartido;
    public static volatile SingularAttribute<Partido, String> legendaPartido;
    public static volatile SingularAttribute<Partido, Integer> numeroPartido;
    public static volatile ListAttribute<Partido, Candidato> candidatoList;

}