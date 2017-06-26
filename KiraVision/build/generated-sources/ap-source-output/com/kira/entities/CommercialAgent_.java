package com.kira.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-26T12:12:11")
@StaticMetamodel(CommercialAgent.class)
public class CommercialAgent_ { 

    public static volatile SingularAttribute<CommercialAgent, String> agentPin;
    public static volatile SingularAttribute<CommercialAgent, Long> agentId;
    public static volatile SingularAttribute<CommercialAgent, String> agentPhone;
    public static volatile SingularAttribute<CommercialAgent, Date> modifiedOn;
    public static volatile SingularAttribute<CommercialAgent, String> agentType;
    public static volatile SingularAttribute<CommercialAgent, String> agentSurname;
    public static volatile SingularAttribute<CommercialAgent, String> agentEmail;
    public static volatile SingularAttribute<CommercialAgent, String> agentName;
    public static volatile SingularAttribute<CommercialAgent, Date> createdOn;
    public static volatile SingularAttribute<CommercialAgent, Boolean> status;

}