package com.kira.sms.entities;

import com.kira.entities.CardHolder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-03T21:33:26")
@StaticMetamodel(SentMessages.class)
public class SentMessages_ { 

    public static volatile SingularAttribute<SentMessages, Double> cost;
    public static volatile SingularAttribute<SentMessages, Double> balance;
    public static volatile SingularAttribute<SentMessages, String> phone;
    public static volatile SingularAttribute<SentMessages, String> success;
    public static volatile SingularAttribute<SentMessages, Long> msgid;
    public static volatile SingularAttribute<SentMessages, CardHolder> cardHolder;
    public static volatile SingularAttribute<SentMessages, String> message;

}