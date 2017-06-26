package com.kira.entities;

import com.kira.entities.Device;
import com.kira.entities.MerchantBean;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-26T12:12:11")
@StaticMetamodel(DeviceMerchant.class)
public class DeviceMerchant_ { 

    public static volatile SingularAttribute<DeviceMerchant, MerchantBean> merchant;
    public static volatile SingularAttribute<DeviceMerchant, Device> device;
    public static volatile SingularAttribute<DeviceMerchant, String> deviceLocation;

}