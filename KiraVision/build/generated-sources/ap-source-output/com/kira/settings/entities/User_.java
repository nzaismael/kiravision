package com.kira.settings.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-26T12:12:11")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> userPin;
    public static volatile SingularAttribute<User, Date> modifiedOn;
    public static volatile SingularAttribute<User, String> mobileNumber;
    public static volatile SingularAttribute<User, String> userEmail;
    public static volatile SingularAttribute<User, String> userId;
    public static volatile SingularAttribute<User, Date> createdOn;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> userSurname;
    public static volatile SingularAttribute<User, Boolean> status;

}