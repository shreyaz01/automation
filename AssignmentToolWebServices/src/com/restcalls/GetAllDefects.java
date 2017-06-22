package com.restcalls;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.requestors.AssignmentToolManager;

@Path("/Defects")
public class GetAllDefects {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllDefectsFromDB() throws JSONException
	{	

		Response response = null;

		JSONObject jObj = new JSONObject();
		try
		{
			
			AssignmentToolManager.getAllTasks();
			
			response = Response.ok().entity(jObj.toString()).build();

		} 
		catch(NullPointerException e)
		{

			jObj.accumulate("message", "No Tasks Found");
			response = Response.status(500).entity(jObj.toString()).build();
		}
		catch(WebApplicationException e)
		{
			jObj.accumulate("message", "No Tasks Found");
			response = Response.status(e.getResponse().getStatus()).entity(jObj.toString()).build();
		}
		catch(Exception e)
		{
			jObj.accumulate("message", "No Tasks Found");
			response = Response.status(500).entity(jObj.toString()).build();
		}

		return response;
	}
}

