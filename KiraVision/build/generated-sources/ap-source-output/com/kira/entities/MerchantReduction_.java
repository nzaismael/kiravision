package com.kira.entities;

import com.kira.entities.MerchantBean;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-03T21:33:26")
@StaticMetamodel(MerchantReduction.class)
public class MerchantReduction_ { 

    public static volatile SingularAttribute<MerchantReduction, String> signatoryPartner;
    public static volatile SingularAttribute<MerchantReduction, String> partnerPosition;
    public static volatile SingularAttribute<MerchantReduction, MerchantBean> merchant;
    public static volatile SingularAttribute<MerchantReduction, String> signatoryKira;
    public static volatile SingularAttribute<MerchantReduction, String> kiraPosition;
    public static volatile SingularAttribute<MerchantReduction, Long> Id;
    public static volatile SingularAttribute<MerchantReduction, Double> reduction;
    public static volatile SingularAttribute<MerchantReduction, Date> signedOn;
    public static volatile SingularAttribute<MerchantReduction, Date> stopedOn;
    public static volatile SingularAttribute<MerchantReduction, Boolean> status;

}