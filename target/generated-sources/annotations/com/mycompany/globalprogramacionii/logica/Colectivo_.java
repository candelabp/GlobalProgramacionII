package com.mycompany.globalprogramacionii.logica;

import com.mycompany.globalprogramacionii.logica.Socio;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-19T22:48:41", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Colectivo.class)
public class Colectivo_ { 

    public static volatile SingularAttribute<Colectivo, Socio> chofer;
    public static volatile SingularAttribute<Colectivo, Integer> id;
    public static volatile SingularAttribute<Colectivo, Integer> cantPasajeros;
    public static volatile SingularAttribute<Colectivo, String> modelo;
    public static volatile SingularAttribute<Colectivo, String> patente;

}