package com.acc;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.acc.domain.GetCountryRequest;
import com.acc.domain.GetCountryResponse;
import com.acc.domain.ObjectFactory;


@Component("countryBean")
public class CountryClient {
	
	 @Autowired
	  private WebServiceTemplate webServiceTemplate;

	 public void requestCountry() throws DatatypeConfigurationException {
		 ObjectFactory factory = new ObjectFactory();
		 GetCountryRequest request = factory.createGetCountryRequest();
		 request.setName("India");
		 GetCountryResponse response = (GetCountryResponse) webServiceTemplate.marshalSendAndReceive(request);
		 System.out.println(response.getCountryStatus().toString());
		 System.out.println(response.getCapitalStatus().toString());
		 
	 }
	
}
