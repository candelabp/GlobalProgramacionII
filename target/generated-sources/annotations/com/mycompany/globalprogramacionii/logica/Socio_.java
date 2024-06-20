package com.mycompany.globalprogramacionii.logica;

import com.mycompany.globalprogramacionii.logica.Colectivo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-19T22:48:41", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Socio.class)
public class Socio_ { 

    public static volatile SingularAttribute<Socio, Integer> legajo;
    public static volatile SingularAttribute<Socio, Colectivo> conduce;
    public static volatile SingularAttribute<Socio, Integer> id;
    public static volatile SingularAttribute<Socio, String> nombre;

}