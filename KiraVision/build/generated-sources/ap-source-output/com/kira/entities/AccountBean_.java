package com.kira.entities;

import com.kira.settings.entities.AccountType;
import com.kira.settings.entities.BankBean;
import com.kira.settings.entities.CurrencyBean;
import com.kira.settings.entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-03T21:33:26")
@StaticMetamodel(AccountBean.class)
public class AccountBean_ { 

    public static volatile SingularAttribute<AccountBean, String> accountDescription;
    public static volatile SingularAttribute<AccountBean, String> accountType;
    public static volatile SingularAttribute<AccountBean, String> accountOwner;
    public static volatile SingularAttribute<AccountBean, String> accountNumber;
    public static volatile SingularAttribute<AccountBean, AccountType> accountSchema;
    public static volatile SingularAttribute<AccountBean, Date> createdOn;
    public static volatile SingularAttribute<AccountBean, Date> modifiedOn;
    public static volatile SingularAttribute<AccountBean, BankBean> bank;
    public static volatile SingularAttribute<AccountBean, Double> balance;
    public static volatile SingularAttribute<AccountBean, User> createdBy;
    public static volatile SingularAttribute<AccountBean, User> modifiedBy;
    public static volatile SingularAttribute<AccountBean, CurrencyBean> currency;
    public static volatile SingularAttribute<AccountBean, Long> id;
    public static volatile SingularAttribute<AccountBean, String> state;

}