//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.22 at 09:33:59 AM SAST 
//


package za.co.paygate.payhost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CardPayoutRequest" type="{http://www.paygate.co.za/PayHOST}CardPayoutRequestType"/&gt;
 *           &lt;element name="BankPayoutRequest" type="{http://www.paygate.co.za/PayHOST}BankPayoutRequestType"/&gt;
 *           &lt;element name="WalletPayoutRequest" type="{http://www.paygate.co.za/PayHOST}WalletPayoutRequestType"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cardPayoutRequest",
    "bankPayoutRequest",
    "walletPayoutRequest"
})
@XmlRootElement(name = "SinglePayoutRequest")
public class SinglePayoutRequest {

    @XmlElement(name = "CardPayoutRequest")
    protected CardPayoutRequestType cardPayoutRequest;
    @XmlElement(name = "BankPayoutRequest")
    protected BankPayoutRequestType bankPayoutRequest;
    @XmlElement(name = "WalletPayoutRequest")
    protected WalletPayoutRequestType walletPayoutRequest;

    /**
     * Gets the value of the cardPayoutRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CardPayoutRequestType }
     *     
     */
    public CardPayoutRequestType getCardPayoutRequest() {
        return cardPayoutRequest;
    }

    /**
     * Sets the value of the cardPayoutRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardPayoutRequestType }
     *     
     */
    public void setCardPayoutRequest(CardPayoutRequestType value) {
        this.cardPayoutRequest = value;
    }

    /**
     * Gets the value of the bankPayoutRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BankPayoutRequestType }
     *     
     */
    public BankPayoutRequestType getBankPayoutRequest() {
        return bankPayoutRequest;
    }

    /**
     * Sets the value of the bankPayoutRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayoutRequestType }
     *     
     */
    public void setBankPayoutRequest(BankPayoutRequestType value) {
        this.bankPayoutRequest = value;
    }

    /**
     * Gets the value of the walletPayoutRequest property.
     * 
     * @return
     *     possible object is
     *     {@link WalletPayoutRequestType }
     *     
     */
    public WalletPayoutRequestType getWalletPayoutRequest() {
        return walletPayoutRequest;
    }

    /**
     * Sets the value of the walletPayoutRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link WalletPayoutRequestType }
     *     
     */
    public void setWalletPayoutRequest(WalletPayoutRequestType value) {
        this.walletPayoutRequest = value;
    }

}
