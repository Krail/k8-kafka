package dev.kritter.jersey.producer;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import dev.kritter.common.Message;
import dev.kritter.kafka.producer.MyProducer;


@Path("/api")
public class ProducerService {
	
	private static MyProducer producer = new MyProducer();
	private static Message bad_api = new Message(9, "Only api 0 is supported");
	private static int count = 0;
	
	private Message stats = new Message(7);
	
	public ProducerService() {}
	
	@POST
	@Path("/{api}/process")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message postProcess(Message msg, @PathParam("api") int api) {
		if (api == 0) {
			ProducerService.producer
					.publish(Integer.toString(ProducerService.count), msg);
			ProducerService.count++;
			return msg;
		} else {
			return ProducerService.bad_api;
		}
	}
	
	@GET
	@Path("/{api}/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getStatus(@PathParam("api") int api) {
		//String test = this.producer.getStats();
		if (api == 0) {
			// return producer.getStats()
			this.stats.addParameter("api=" + api);
			this.stats.addParameter("count=" + ProducerService.count);
			return this.stats;
		} else {
			//return ProducerService.bad_api;
			return this.stats;
		}
	}
	
}
