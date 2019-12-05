package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serjer.iban.Iban;



@Component
public class IbanRepository {
	
	@Autowired
	private IbanService ibanService;
	
	public Iban checkListOfIbans(String ibanNumber) {
        Iban iban = new Iban();
        iban.setIbanNumber(ibanNumber);
        	if(ibanService.isValidIban(ibanNumber)) 
        		iban.setIsValid(true);
        	else         		
        		iban.setIsValid(false);
        	
             return iban;
    }

}	

