package com.kira.entities;

import com.kira.entities.PurchaseBean;
import com.kira.settings.entities.CommissionsDistribution;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-03T21:33:26")
@StaticMetamodel(PurchaseCommissionsDetail.class)
public class PurchaseCommissionsDetail_ { 

    public static volatile SingularAttribute<PurchaseCommissionsDetail, CommissionsDistribution> comm;
    public static volatile SingularAttribute<PurchaseCommissionsDetail, PurchaseBean> purchase;
    public static volatile SingularAttribute<PurchaseCommissionsDetail, Integer> detailId;
    public static volatile SingularAttribute<PurchaseCommissionsDetail, Double> commissionAmount;

}