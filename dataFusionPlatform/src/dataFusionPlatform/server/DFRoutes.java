package dataFusionPlatform.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataFusionPlatform.server.DFService;
import dataFusionPlatform.utility.*;
import spark.servlet.SparkApplication;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;

public class DFRoutes implements SparkApplication{

	private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private DFService service = new DFService(Util.getNeo4jUrl());

	@Override
	public void init() 
	{
		
		get("/ty/graph", new Route() {
            public Object handle(Request request, Response response) {
            	int limit = request.queryParams("limit") != null ? Integer.valueOf(request.queryParams("limit")) : 100;
                
            	return gson.toJson(service.graph(limit));
               
            }
        });
		
		get("/ty/datasets", new Route() {
            public Object handle(Request request, Response response) {
            	int limit = request.queryParams("limit") != null ? Integer.valueOf(request.queryParams("limit")) : 100;
                
            	return gson.toJson(service.datasets(limit));
               
            }
        });
               
            
		
		get("/ty/getDataset", new Route() {
            public Object handle(Request request, Response response) {
            	int limit = request.queryParams("limit") != null ? Integer.valueOf(request.queryParams("limit")) : 100;
                
            	return gson.toJson(service.getDataset(limit));
               
            }
        });
		
	}
	
	/*
	public static void main(String[] args) 
	{
	    SparkBase.port(Util.getWebPort());
	    externalStaticFileLocation("WebContent");
	    final DFService service = new DFService(Util.getNeo4jUrl());
	    new DFRoutes(service).init();
	} */
	


}
