package rs.ftn.reviewer.rest;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import rs.ftn.reviewer.rest.ejb.Tag;

@Path("/proizvodi")
public class ProductService {

	@Context
	HttpServletRequest request;
	@Context
	ServletContext ctx;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Hello Jersey";
	}
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML)
	public String htmlTest() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
		        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}

	@GET
	@Path("/getGroup")
	@Produces(MediaType.APPLICATION_JSON)
	public Tag getJustProducts() {
		System.out.println("get products");
		Tag testGroup = new Tag();
		return testGroup;
	}
	
	@GET
	@Path("/pushMessage")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendPushNotificatoin() {
		
		try {
			SendPushNotification.pushFCMNotification("news");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Done";
	}
	
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	//TODO : Ovde snimiti
//	@Produces(MediaType.TEXT_PLAIN)
	public JSONObject add(Tag g) {
		System.out.println("Group " + g.getName());
		JSONObject obj = new JSONObject();
		obj.put("status", "ok");
		return obj;
	}

}
