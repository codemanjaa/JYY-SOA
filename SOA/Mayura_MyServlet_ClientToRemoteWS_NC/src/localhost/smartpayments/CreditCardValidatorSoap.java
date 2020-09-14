
package localhost.smartpayments;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CreditCardValidatorSoap", targetNamespace = "http://localhost/SmartPayments/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CreditCardValidatorSoap {


    /**
     * Returns the card issuer Visa, MasterCard, AMEX, etc., based  on the card number.
     * 
     * @param cardNumber
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCardType", action = "http://localhost/SmartPayments/GetCardType")
    @WebResult(name = "GetCardTypeResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "GetCardType", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.GetCardType")
    @ResponseWrapper(localName = "GetCardTypeResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.GetCardTypeResponse")
    public String getCardType(
        @WebParam(name = "CardNumber", targetNamespace = "http://localhost/SmartPayments/")
        String cardNumber);

    /**
     * Returns (T/F) if the card is a known commercial card (commercial cards require customer code and sales tax amount to receive preferred discount rate pricing.)
     * 
     * @param cardNumber
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "IsCommercialCard", action = "http://localhost/SmartPayments/IsCommercialCard")
    @WebResult(name = "IsCommercialCardResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "IsCommercialCard", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.IsCommercialCard")
    @ResponseWrapper(localName = "IsCommercialCardResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.IsCommercialCardResponse")
    public boolean isCommercialCard(
        @WebParam(name = "CardNumber", targetNamespace = "http://localhost/SmartPayments/")
        String cardNumber);

    /**
     * Validates the credit card by checking the card length based on the card type, performs a mod 10 checksum and validates the expiration date. Returns 0 if good, 1001 - no card number, 1002 - no exp date, 1003 - invalid card type, 1004 - invalid card length, 1005 - bad mod 10 check, 1006 - bad expiration date.
     * 
     * @param cardNumber
     * @param expDate
     * @return
     *     returns int
     */
    @WebMethod(operationName = "ValidCard", action = "http://localhost/SmartPayments/ValidCard")
    @WebResult(name = "ValidCardResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "ValidCard", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.ValidCard")
    @ResponseWrapper(localName = "ValidCardResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.ValidCardResponse")
    public int validCard(
        @WebParam(name = "CardNumber", targetNamespace = "http://localhost/SmartPayments/")
        String cardNumber,
        @WebParam(name = "ExpDate", targetNamespace = "http://localhost/SmartPayments/")
        String expDate);

    /**
     * Validates the credit card length by checking the card length based on the card type, Returns (T/F).
     * 
     * @param cardNumber
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "ValidCardLength", action = "http://localhost/SmartPayments/ValidCardLength")
    @WebResult(name = "ValidCardLengthResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "ValidCardLength", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.ValidCardLength")
    @ResponseWrapper(localName = "ValidCardLengthResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.ValidCardLengthResponse")
    public boolean validCardLength(
        @WebParam(name = "CardNumber", targetNamespace = "http://localhost/SmartPayments/")
        String cardNumber);

    /**
     * Validates the expiration date by making sure it is a valid date and the card has not expired, Returns (T/F).
     * 
     * @param expDate
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "ValidExpDate", action = "http://localhost/SmartPayments/ValidExpDate")
    @WebResult(name = "ValidExpDateResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "ValidExpDate", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.ValidExpDate")
    @ResponseWrapper(localName = "ValidExpDateResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.ValidExpDateResponse")
    public boolean validExpDate(
        @WebParam(name = "ExpDate", targetNamespace = "http://localhost/SmartPayments/")
        String expDate);

    /**
     * Validates the credit card by performing a mod 10 checksum on the card number, Returns (T/F).
     * 
     * @param cardNumber
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "ValidMod10", action = "http://localhost/SmartPayments/ValidMod10")
    @WebResult(name = "ValidMod10Result", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "ValidMod10", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.ValidMod10")
    @ResponseWrapper(localName = "ValidMod10Response", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.ValidMod10Response")
    public boolean validMod10(
        @WebParam(name = "CardNumber", targetNamespace = "http://localhost/SmartPayments/")
        String cardNumber);

    /**
     * Lookup the Debit Network ID using a Card Number. Network ID is a 3 characters string. If there is a match, the card can likely be used as a Debit Card and processed through the Debit network. Possible Network ID: ACL – Accel, AFN - AFFN, AKO – Alaska Option, C24 – CU24, ILK – Interlink, JEN - Jeanie, MAC – Star Northeast (MAC), MAE – Maestro, NET - NETS, NYC – NYCE, PUL – Pulse, SES – Star Southeast, SHZ – Shazam, STX – Star West, TYM - TYME
     * 
     * @param password
     * @param userName
     * @param cardNumber
     * @return
     *     returns localhost.smartpayments.Response
     */
    @WebMethod(operationName = "GetNetworkID", action = "http://localhost/SmartPayments/GetNetworkID")
    @WebResult(name = "GetNetworkIDResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "GetNetworkID", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.GetNetworkID")
    @ResponseWrapper(localName = "GetNetworkIDResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.GetNetworkIDResponse")
    public Response getNetworkID(
        @WebParam(name = "UserName", targetNamespace = "http://localhost/SmartPayments/")
        String userName,
        @WebParam(name = "Password", targetNamespace = "http://localhost/SmartPayments/")
        String password,
        @WebParam(name = "CardNumber", targetNamespace = "http://localhost/SmartPayments/")
        String cardNumber);

    /**
     * Returns (T/F) if the card is a known FSA card.
     * 
     * @param vendor
     * @param pnRef
     * @param ccInfoKey
     * @param cardNumber
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "IsFSACard", action = "http://localhost/SmartPayments/IsFSACard")
    @WebResult(name = "IsFSACardResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "IsFSACard", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.IsFSACard")
    @ResponseWrapper(localName = "IsFSACardResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.IsFSACardResponse")
    public boolean isFSACard(
        @WebParam(name = "CardNumber", targetNamespace = "http://localhost/SmartPayments/")
        String cardNumber,
        @WebParam(name = "PNRef", targetNamespace = "http://localhost/SmartPayments/")
        String pnRef,
        @WebParam(name = "Vendor", targetNamespace = "http://localhost/SmartPayments/")
        String vendor,
        @WebParam(name = "CcInfoKey", targetNamespace = "http://localhost/SmartPayments/")
        String ccInfoKey);

    /**
     * Returns (T/F) if the routing number is present in the routing table.
     * 
     * @param routingNumber
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "IsValidCheckRoutingNumber", action = "http://localhost/SmartPayments/IsValidCheckRoutingNumber")
    @WebResult(name = "IsValidCheckRoutingNumberResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "IsValidCheckRoutingNumber", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.IsValidCheckRoutingNumber")
    @ResponseWrapper(localName = "IsValidCheckRoutingNumberResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.IsValidCheckRoutingNumberResponse")
    public boolean isValidCheckRoutingNumber(
        @WebParam(name = "RoutingNumber", targetNamespace = "http://localhost/SmartPayments/")
        String routingNumber);

    /**
     * Returns an XMLDocument with the following nodes:  - IsDebit: (T/F) if the routing number is present in the debit table. - CardType: The card type associated with the card number.
     * 
     * @param cardNumber
     * @return
     *     returns localhost.smartpayments.IsDebitCardResponse.IsDebitCardResult
     */
    @WebMethod(operationName = "IsDebitCard", action = "http://localhost/SmartPayments/IsDebitCard")
    @WebResult(name = "IsDebitCardResult", targetNamespace = "http://localhost/SmartPayments/")
    @RequestWrapper(localName = "IsDebitCard", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.IsDebitCard")
    @ResponseWrapper(localName = "IsDebitCardResponse", targetNamespace = "http://localhost/SmartPayments/", className = "localhost.smartpayments.IsDebitCardResponse")
    public localhost.smartpayments.IsDebitCardResponse.IsDebitCardResult isDebitCard(
        @WebParam(name = "CardNumber", targetNamespace = "http://localhost/SmartPayments/")
        String cardNumber);

}
