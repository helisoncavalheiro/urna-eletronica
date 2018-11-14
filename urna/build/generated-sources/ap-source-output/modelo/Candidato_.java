package modelo;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Chapa;
import modelo.Partido;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-13T22:54:50")
@StaticMetamodel(Candidato.class)
public class Candidato_ { 

    public static volatile SingularAttribute<Candidato, String> ufCandidato;
    public static volatile ListAttribute<Candidato, Chapa> chapaList1;
    public static volatile SingularAttribute<Candidato, Integer> idCandidato;
    public static volatile SingularAttribute<Candidato, BigInteger> numeroCandidato;
    public static volatile SingularAttribute<Candidato, Partido> partidoCandidato;
    public static volatile SingularAttribute<Candidato, String> nome;
    public static volatile SingularAttribute<Candidato, String> tipoCandidato;
    public static volatile ListAttribute<Candidato, Chapa> chapaList;

}