//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.25 at 10:11:15 AM SAST 
//


package za.co.paygate.payhost;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for VoidRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoidRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Account" type="{http://www.paygate.co.za/PayHOST}PayGateAccountType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="MerchantOrderId" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="PaymentType" type="{http://www.paygate.co.za/PayHOST}PaymentType" minOccurs="0"/&gt;
 *         &lt;element name="TransactionType" type="{http://www.paygate.co.za/PayHOST}TransactionType"/&gt;
 *         &lt;element name="UserDefinedFields" type="{http://www.paygate.co.za/PayHOST}KeyValueType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoidRequestType", propOrder = {
    "account",
    "transactionId",
    "merchantOrderId",
    "paymentType",
    "transactionType",
    "userDefinedFields"
})
public class VoidRequestType {

    @XmlElement(name = "Account", required = true)
    protected PayGateAccountType account;
    @XmlElement(name = "TransactionId")
    protected String transactionId;
    @XmlElement(name = "MerchantOrderId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String merchantOrderId;
    @XmlElement(name = "PaymentType")
    protected PaymentType paymentType;
    @XmlElement(name = "TransactionType", required = true)
    @XmlSchemaType(name = "token")
    protected TransactionType transactionType;
    @XmlElement(name = "UserDefinedFields")
    protected List<KeyValueType> userDefinedFields;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link PayGateAccountType }
     *     
     */
    public PayGateAccountType getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayGateAccountType }
     *     
     */
    public void setAccount(PayGateAccountType value) {
        this.account = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the merchantOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    /**
     * Sets the value of the merchantOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantOrderId(String value) {
        this.merchantOrderId = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentType }
     *     
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *     
     */
    public void setPaymentType(PaymentType value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setTransactionType(TransactionType value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the userDefinedFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userDefinedFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserDefinedFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValueType }
     * 
     * 
     */
    public List<KeyValueType> getUserDefinedFields() {
        if (userDefinedFields == null) {
            userDefinedFields = new ArrayList<KeyValueType>();
        }
        return this.userDefinedFields;
    }

}
