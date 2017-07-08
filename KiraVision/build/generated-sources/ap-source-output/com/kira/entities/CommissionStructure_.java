package com.kira.entities;

import com.kira.entities.CommissionBeneficiary;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-03T21:33:26")
@StaticMetamodel(CommissionStructure.class)
public class CommissionStructure_ { 

    public static volatile SingularAttribute<CommissionStructure, CommissionBeneficiary> beneficiary;
    public static volatile SingularAttribute<CommissionStructure, Double> percentage;
    public static volatile SingularAttribute<CommissionStructure, Integer> upperLimit;
    public static volatile SingularAttribute<CommissionStructure, Integer> lowerLimit;

}