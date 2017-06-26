
package com.kira.sms.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kira.sms.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ksend_QNAME = new QName("http://gateway.esicia.com/soap/ksms", "ksend");
    private final static QName _KsendResponse_QNAME = new QName("http://gateway.esicia.com/soap/ksms", "ksendResponse");
    private final static QName _Kchk_QNAME = new QName("http://gateway.esicia.com/soap/ksms", "kchk");
    private final static QName _KchkResponse_QNAME = new QName("http://gateway.esicia.com/soap/ksms", "kchkResponse");
    private final static QName _Kchange_QNAME = new QName("http://gateway.esicia.com/soap/ksms", "kchange");
    private final static QName _KchangeResponse_QNAME = new QName("http://gateway.esicia.com/soap/ksms", "kchangeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kira.sms.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KsendRequestType }
     * 
     */
    public KsendRequestType createKsendRequestType() {
        return new KsendRequestType();
    }

    /**
     * Create an instance of {@link KsendResponseType }
     * 
     */
    public KsendResponseType createKsendResponseType() {
        return new KsendResponseType();
    }

    /**
     * Create an instance of {@link KchkRequestType }
     * 
     */
    public KchkRequestType createKchkRequestType() {
        return new KchkRequestType();
    }

    /**
     * Create an instance of {@link KchkResponseType }
     * 
     */
    public KchkResponseType createKchkResponseType() {
        return new KchkResponseType();
    }

    /**
     * Create an instance of {@link KchangeRequestType }
     * 
     */
    public KchangeRequestType createKchangeRequestType() {
        return new KchangeRequestType();
    }

    /**
     * Create an instance of {@link KchangeResponseType }
     * 
     */
    public KchangeResponseType createKchangeResponseType() {
        return new KchangeResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KsendRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gateway.esicia.com/soap/ksms", name = "ksend")
    public JAXBElement<KsendRequestType> createKsend(KsendRequestType value) {
        return new JAXBElement<KsendRequestType>(_Ksend_QNAME, KsendRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KsendResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gateway.esicia.com/soap/ksms", name = "ksendResponse")
    public JAXBElement<KsendResponseType> createKsendResponse(KsendResponseType value) {
        return new JAXBElement<KsendResponseType>(_KsendResponse_QNAME, KsendResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KchkRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gateway.esicia.com/soap/ksms", name = "kchk")
    public JAXBElement<KchkRequestType> createKchk(KchkRequestType value) {
        return new JAXBElement<KchkRequestType>(_Kchk_QNAME, KchkRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KchkResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gateway.esicia.com/soap/ksms", name = "kchkResponse")
    public JAXBElement<KchkResponseType> createKchkResponse(KchkResponseType value) {
        return new JAXBElement<KchkResponseType>(_KchkResponse_QNAME, KchkResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KchangeRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gateway.esicia.com/soap/ksms", name = "kchange")
    public JAXBElement<KchangeRequestType> createKchange(KchangeRequestType value) {
        return new JAXBElement<KchangeRequestType>(_Kchange_QNAME, KchangeRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KchangeResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gateway.esicia.com/soap/ksms", name = "kchangeResponse")
    public JAXBElement<KchangeResponseType> createKchangeResponse(KchangeResponseType value) {
        return new JAXBElement<KchangeResponseType>(_KchangeResponse_QNAME, KchangeResponseType.class, null, value);
    }

}
