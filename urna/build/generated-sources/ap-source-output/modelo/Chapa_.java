package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Candidato;
import modelo.Voto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-13T22:54:50")
@StaticMetamodel(Chapa.class)
public class Chapa_ { 

    public static volatile SingularAttribute<Chapa, Integer> idChapa;
    public static volatile SingularAttribute<Chapa, Integer> numeroChapa;
    public static volatile ListAttribute<Chapa, Voto> votoList;
    public static volatile SingularAttribute<Chapa, Candidato> nomeCandidato;
    public static volatile SingularAttribute<Chapa, Candidato> nomeViceCandidato;

}