package dev.kritter.jersey.consumer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import dev.kritter.common.Message;
import dev.kritter.kafka.consumer.MyConsumer;


@Path("/api")
public class ConsumerService {
	
	private static MyConsumer consumer = new MyConsumer();
	private static Message bad_api = new Message(9, "Only api 0 is supported");
	
	private Message stats = new Message(7);
	
	public ConsumerService() {}
	
	@GET
	@Path("/{api}/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getStatus(@PathParam("api") int api) {
		if (api == 0) {
			this.stats.addParameter("api=" + api);
			this.stats.addParameter("count=" + ConsumerService.consumer.getCount());
			return this.stats;
		} else {
			return ConsumerService.bad_api;
		}
	}
	
}
