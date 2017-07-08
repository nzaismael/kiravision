package com.kira.entities;

import com.kira.entities.CommercialAgent;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-03T21:33:26")
@StaticMetamodel(CardHolder.class)
public class CardHolder_ { 

    public static volatile SingularAttribute<CardHolder, CommercialAgent> parent;
    public static volatile SingularAttribute<CardHolder, Long> clientId;
    public static volatile SingularAttribute<CardHolder, String> clientName;
    public static volatile SingularAttribute<CardHolder, String> clientEmail;
    public static volatile SingularAttribute<CardHolder, String> clientSurname;
    public static volatile SingularAttribute<CardHolder, String> clientPin;
    public static volatile SingularAttribute<CardHolder, Date> createdOn;
    public static volatile SingularAttribute<CardHolder, String> clientPhone;
    public static volatile SingularAttribute<CardHolder, Date> modifiedOn;
    public static volatile SingularAttribute<CardHolder, CommercialAgent> grandChild;
    public static volatile SingularAttribute<CardHolder, String> cardNumber;
    public static volatile SingularAttribute<CardHolder, Boolean> status;
    public static volatile SingularAttribute<CardHolder, CommercialAgent> child;

}