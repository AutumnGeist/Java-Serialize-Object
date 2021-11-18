/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeobject;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author marilyn
 */
@XmlRootElement(name = "Payment")
@XmlType(propOrder= {"type", "cardNumber", "pin"})
public class Payment {
    private String type;
    private String cardNumber;
    private String pin;

    public Payment(String type, String cardNumber, String pin) {
        this.type = type;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public Payment() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Payment{" + "type=" + type + ", cardNumber=" + cardNumber + ", pin=" + pin + '}';
    }
    
    
    
}
