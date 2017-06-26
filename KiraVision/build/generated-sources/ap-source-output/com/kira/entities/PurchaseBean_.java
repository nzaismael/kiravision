package com.kira.entities;

import com.kira.entities.CardHolder;
import com.kira.entities.CommercialAgent;
import com.kira.entities.MerchantReduction;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-26T12:12:11")
@StaticMetamodel(PurchaseBean.class)
public class PurchaseBean_ { 

    public static volatile SingularAttribute<PurchaseBean, CommercialAgent> parent;
    public static volatile SingularAttribute<PurchaseBean, String> ebmBillNumber;
    public static volatile SingularAttribute<PurchaseBean, Long> purchaseId;
    public static volatile SingularAttribute<PurchaseBean, MerchantReduction> contract;
    public static volatile SingularAttribute<PurchaseBean, CardHolder> client;
    public static volatile SingularAttribute<PurchaseBean, Date> purchaseOn;
    public static volatile SingularAttribute<PurchaseBean, CommercialAgent> grandchild;
    public static volatile SingularAttribute<PurchaseBean, Double> purchaseAmount;
    public static volatile SingularAttribute<PurchaseBean, CommercialAgent> child;

}