/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

import com.kira.settings.entities.AccountType;
import com.kira.settings.entities.BankBean;
import com.kira.settings.entities.CurrencyBean;
import com.kira.settings.entities.User;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AOS
 */
@Entity
@Table(name="accounts")
@XmlRootElement(name="ACCOUNT")
@XmlAccessorType(XmlAccessType.FIELD)
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
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private java.util.Date createdOn;
  @XmlElement(name="MODIFIEDON")
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private java.util.Date modifiedOn;
 
  @XmlElement(name="CREATEDBY")
  private User createdBy;
  @XmlElement(name="MODIFIEDBY")
 
  private User modifiedBy;
  @XmlElement(name="STATE")
  @Column(name="state",nullable=false,length=1)
  private String state;  // O open, C closed, S suspended
   @XmlElement(name="BALANCE")
  @Column(name="balance",nullable=false)
  private double balance;
   @XmlElement(name="BANK")
   private BankBean bank;
   @XmlElement(name="CURRENCY")
   private CurrencyBean currency;
   @XmlElement(name="ACCOUNTSCHEMA")
   private AccountType accountSchema;
           
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the accountDescription
     */
    public String getAccountDescription() {
        return accountDescription;
    }

    /**
     * @param accountDescription the accountDescription to set
     */
    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the accountOwner
     */
    public String getAccountOwner() {
        return accountOwner;
    }

    /**
     * @param accountOwner the accountOwner to set
     */
    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    /**
     * @return the createdOn
     */
    public java.util.Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(java.util.Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the modifiedOn
     */
    public java.util.Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * @param modifiedOn the modifiedOn to set
     */
    public void setModifiedOn(java.util.Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    /**
     * @return the createdBy
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the modifiedBy
     */
    public User getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the bank
     */
    public BankBean getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(BankBean bank) {
        this.bank = bank;
    }

    /**
     * @return the currency
     */
    public CurrencyBean getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    /**
     * @return the accountSchema
     */
    public AccountType getAccountSchema() {
        return accountSchema;
    }

    /**
     * @param accountSchema the accountSchema to set
     */
    public void setAccountSchema(AccountType accountSchema) {
        this.accountSchema = accountSchema;
    }


}
