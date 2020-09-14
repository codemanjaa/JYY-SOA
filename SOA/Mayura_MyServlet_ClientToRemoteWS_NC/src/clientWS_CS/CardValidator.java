package clientWS_CS;

import java.util.List;

import localhost.smartpayments.CreditCardValidator;
import localhost.smartpayments.CreditCardValidatorSoap;
import localhost.smartpayments.IsDebitCardResponse.IsDebitCardResult;


public class CardValidator {
	
	public CardValidator() {}
	
	public String getCardType(String inputStr) {
		
		String cardNumber = inputStr;
		CreditCardValidator cardService = new CreditCardValidator();
		CreditCardValidatorSoap cardServiceSoap = cardService.getCreditCardValidatorSoap();
		String cardType = cardServiceSoap.getCardType(cardNumber);
		return cardType;
	}
	
	public List<Object> isDebitCard(String inputStr) {
		
		String cardNumber = inputStr;
		CreditCardValidator cardService = new CreditCardValidator();
		CreditCardValidatorSoap cardServiceSoap = cardService.getCreditCardValidatorSoap();
		IsDebitCardResult isDebitCardResult = cardServiceSoap.isDebitCard(cardNumber);
		return isDebitCardResult.getContent();
		
	}
	
	public boolean isCommercialCard(String inputStr) {
		String cardNumber = inputStr;
		CreditCardValidator cardService = new CreditCardValidator();
		CreditCardValidatorSoap cardServiceSoap = cardService.getCreditCardValidatorSoap();
		boolean isCommercial = cardServiceSoap.isCommercialCard(cardNumber);
		return isCommercial;	
	}
	
	
	
	

}
