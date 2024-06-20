package com.mycompany.globalprogramacionii.logica;

import com.mycompany.globalprogramacionii.logica.Colectivo;
import com.mycompany.globalprogramacionii.logica.Socio;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-19T22:48:41", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Viaje.class)
public class Viaje_ { 

    public static volatile SingularAttribute<Viaje, Colectivo> colectivo;
    public static volatile SingularAttribute<Viaje, Socio> socio;
    public static volatile SingularAttribute<Viaje, Integer> id;
    public static volatile SingularAttribute<Viaje, Integer> cantPasajeros;
    public static volatile SingularAttribute<Viaje, Integer> cantKm;

}