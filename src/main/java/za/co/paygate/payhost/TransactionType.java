//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.18 at 04:59:45 PM CAT 
//


package za.co.paygate.payhost;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Authorisation"/&gt;
 *     &lt;enumeration value="Settlement"/&gt;
 *     &lt;enumeration value="Refund"/&gt;
 *     &lt;enumeration value="Payout"/&gt;
 *     &lt;enumeration value="Purchase"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransactionType")
@XmlEnum
public enum TransactionType {

    @XmlEnumValue("Authorisation")
    AUTHORISATION("Authorisation"),
    @XmlEnumValue("Settlement")
    SETTLEMENT("Settlement"),
    @XmlEnumValue("Refund")
    REFUND("Refund"),
    @XmlEnumValue("Payout")
    PAYOUT("Payout"),
    @XmlEnumValue("Purchase")
    PURCHASE("Purchase");
    private final String value;

    TransactionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionType fromValue(String v) {
        for (TransactionType c: TransactionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}