
package com.esicia.gateway.soap.ksms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for kchangeRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="kchangeRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="newpin" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kchangeRequestType", propOrder = {

})
public class KchangeRequestType {

    @XmlElement(required = true)
    protected String account;
    @XmlElement(required = true)
    protected String newpin;
    @XmlElement(required = true)
    protected String pin;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the newpin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewpin() {
        return newpin;
    }

    /**
     * Sets the value of the newpin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewpin(String value) {
        this.newpin = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPin(String value) {
        this.pin = value;
    }

}
