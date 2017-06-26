
package com.kira.sms.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ksendRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ksendRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="sender" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="msgid" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="receivedlr" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="callurl" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="messagetype" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ksendRequestType", propOrder = {

})
public class KsendRequestType {

    @XmlElement(required = true)
    protected String account;
    @XmlElement(required = true)
    protected String pin;
    @XmlElement(required = true)
    protected String sender;
    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected String phone;
    @XmlElement(required = true)
    protected String msgid;
    @XmlElement(required = true)
    protected String receivedlr;
    @XmlElement(required = true)
    protected String callurl;
    @XmlElement(required = true)
    protected String messagetype;

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

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSender(String value) {
        this.sender = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the msgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgid() {
        return msgid;
    }

    /**
     * Sets the value of the msgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgid(String value) {
        this.msgid = value;
    }

    /**
     * Gets the value of the receivedlr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceivedlr() {
        return receivedlr;
    }

    /**
     * Sets the value of the receivedlr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceivedlr(String value) {
        this.receivedlr = value;
    }

    /**
     * Gets the value of the callurl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallurl() {
        return callurl;
    }

    /**
     * Sets the value of the callurl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallurl(String value) {
        this.callurl = value;
    }

    /**
     * Gets the value of the messagetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessagetype() {
        return messagetype;
    }

    /**
     * Sets the value of the messagetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessagetype(String value) {
        this.messagetype = value;
    }

}
