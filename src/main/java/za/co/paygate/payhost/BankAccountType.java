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
 * <p>Java class for BankAccountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BankAccountType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Current"/&gt;
 *     &lt;enumeration value="Savings"/&gt;
 *     &lt;enumeration value="Transmission"/&gt;
 *     &lt;enumeration value="Bond"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BankAccountType")
@XmlEnum
public enum BankAccountType {

    @XmlEnumValue("Current")
    CURRENT("Current"),
    @XmlEnumValue("Savings")
    SAVINGS("Savings"),
    @XmlEnumValue("Transmission")
    TRANSMISSION("Transmission"),
    @XmlEnumValue("Bond")
    BOND("Bond");
    private final String value;

    BankAccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BankAccountType fromValue(String v) {
        for (BankAccountType c: BankAccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}