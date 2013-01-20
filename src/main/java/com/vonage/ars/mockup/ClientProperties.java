package com.vonage.ars.mockup;
 
import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

// https://arsbeta.api.vonage.com/ars/2/clientproperties?clientType=iPhone&clientVersion=2.0&productName=TTC_BETA
@Path("/2")
public class ClientProperties {	
	
	@GET
	@Path("/clientproperties")
	@Produces({"application/json"})
	public Response redirect(@QueryParam("clientType") String clientType,
			@QueryParam("clientVersion") String clientVersion,
			@QueryParam("productName") String productName,
			@QueryParam("responseStatus") int status) {
		URI location = null;
		if ("2.0".equalsIgnoreCase(clientVersion)) {
			location = UriBuilder.fromUri("https://arsbeta.api.vonage.com/ars/2/clientproperties?clientType=iPhone&clientVersion=2.0&productName=TTC_BETA").build();
		} else if ("2.1".equalsIgnoreCase(clientVersion)) {
			location = UriBuilder.fromUri("https://arsbeta.api.vonage.com/ars/2/clientproperties?clientType=iPhone&clientVersion=2.0&productName=TTC2").build();
		}
		
		return location == null ? Response
				   .status(200)
				   .entity("client type : " + clientType + ", version : " + clientVersion
					+ ", productName" + productName).build() : Response.status(status).location(location).build();
	}
}