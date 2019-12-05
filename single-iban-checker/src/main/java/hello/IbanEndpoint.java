package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.serjer.iban.GetIbanRequest;
import com.serjer.iban.GetIbanResponse;

@Endpoint
public class IbanEndpoint {
	private static final String NAMESPACE_URI = "http://serjer.com/iban";
	
	
	@Autowired
	private IbanRepository ibanRepository;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIbanRequest")
	@ResponsePayload
	public GetIbanResponse getIban(@RequestPayload GetIbanRequest request) {
		GetIbanResponse response = new GetIbanResponse();
		
		response.setIban(ibanRepository.checkListOfIbans(request.getIbanNumber()));
	
		return response;
	}
	
}	