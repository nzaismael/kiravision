/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.beans;

import com.settings.beans.User;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author AOS
 */
public class AccountBean implements Serializable{
  @Id
@GeneratedValue(strategy=GenerationType.IDENTITY)  
  @XmlElement(name="ID")
  private Long id;
  @XmlElement(name="ACCOUNTNUMBER")
  @Column(name="accountNumber",length=10,nullable =false,unique=true)
  private String accountNumber;
  @XmlElement(name="ACCOUNTDESCRIPTION")
  @Column(name="accountDescription",nullable=false,length=255)
  String accountDescription;
  @XmlElement(name="ACCOUNTTYPE")
  @Column(name="accountType",nullable=false,length=1)
  private String accountType; // Actif or Passif
  @XmlElement(name="ACCOUNTOWNER")
  @Column(name="accountOwner",nullable=false,length=3)
  private String accountOwner; //B bank,P partnerCommissions payable by customers,C money owed to Customers, I Income account 
  // CH check waiting for payment, TR transfers waiting for payment
  @XmlElement(name="CREATEDON")
  private java.util.Date createdOn;
  @XmlElement(name="MODIFIEDON")
  private java.util.Date modifiedOn;
  @XmlElement(name="CREATEDBY")
  private User createdBy;
  @XmlElement(name="MODIFIEDBY")
  private User modifiedBy;  
}
