//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.25 at 10:11:15 AM SAST 
//


package za.co.paygate.payhost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ThreeDSecureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThreeDSecureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Enrolled" type="{http://www.paygate.co.za/PayHOST}YNU"/&gt;
 *         &lt;element name="Paresstatus" type="{http://www.paygate.co.za/PayHOST}YNUA"/&gt;
 *         &lt;element name="Eci" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="Xid" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="Cavv" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ThreeDSecureType", propOrder = {
    "enrolled",
    "paresstatus",
    "eci",
    "xid",
    "cavv"
})
public class ThreeDSecureType {

    @XmlElement(name = "Enrolled", required = true)
    @XmlSchemaType(name = "token")
    protected YNU enrolled;
    @XmlElement(name = "Paresstatus", required = true)
    @XmlSchemaType(name = "token")
    protected YNUA paresstatus;
    @XmlElement(name = "Eci", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String eci;
    @XmlElement(name = "Xid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String xid;
    @XmlElement(name = "Cavv", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String cavv;

    /**
     * Gets the value of the enrolled property.
     * 
     * @return
     *     possible object is
     *     {@link YNU }
     *     
     */
    public YNU getEnrolled() {
        return enrolled;
    }

    /**
     * Sets the value of the enrolled property.
     * 
     * @param value
     *     allowed object is
     *     {@link YNU }
     *     
     */
    public void setEnrolled(YNU value) {
        this.enrolled = value;
    }

    /**
     * Gets the value of the paresstatus property.
     * 
     * @return
     *     possible object is
     *     {@link YNUA }
     *     
     */
    public YNUA getParesstatus() {
        return paresstatus;
    }

    /**
     * Sets the value of the paresstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link YNUA }
     *     
     */
    public void setParesstatus(YNUA value) {
        this.paresstatus = value;
    }

    /**
     * Gets the value of the eci property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEci() {
        return eci;
    }

    /**
     * Sets the value of the eci property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEci(String value) {
        this.eci = value;
    }

    /**
     * Gets the value of the xid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXid() {
        return xid;
    }

    /**
     * Sets the value of the xid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXid(String value) {
        this.xid = value;
    }

    /**
     * Gets the value of the cavv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCavv() {
        return cavv;
    }

    /**
     * Sets the value of the cavv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCavv(String value) {
        this.cavv = value;
    }

}
