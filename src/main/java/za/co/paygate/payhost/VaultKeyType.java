//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.25 at 10:11:15 AM SAST 
//


package za.co.paygate.payhost;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VaultKeyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VaultKeyType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="cardNumber"/&gt;
 *     &lt;enumeration value="expDate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VaultKeyType")
@XmlEnum
public enum VaultKeyType {

    @XmlEnumValue("cardNumber")
    CARD_NUMBER("cardNumber"),
    @XmlEnumValue("expDate")
    EXP_DATE("expDate");
    private final String value;

    VaultKeyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VaultKeyType fromValue(String v) {
        for (VaultKeyType c: VaultKeyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
