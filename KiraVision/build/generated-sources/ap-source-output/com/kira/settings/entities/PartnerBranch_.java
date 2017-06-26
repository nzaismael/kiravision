package com.kira.settings.entities;

import com.kira.entities.MerchantBean;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-26T12:12:11")
@StaticMetamodel(PartnerBranch.class)
public class PartnerBranch_ { 

    public static volatile SingularAttribute<PartnerBranch, String> Description;
    public static volatile SingularAttribute<PartnerBranch, String> deviceImei;
    public static volatile SingularAttribute<PartnerBranch, Long> id;
    public static volatile SingularAttribute<PartnerBranch, MerchantBean> merchantBean;
    public static volatile SingularAttribute<PartnerBranch, String> deviceSerialNumber;
    public static volatile SingularAttribute<PartnerBranch, Boolean> status;

}