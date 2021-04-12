package com.target.flow.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SlackRoute extends RouteBuilder {

	@Value("${topic}")
	String topicName;

	@Value("${spring.kafka.bootstrap-servers}")
	String kafkaServer;

	@Value("${slack.channel}")
	private String channel;

	@Value("${camel.component.slack.webhook-url}")
	private String webHookUrl;

	@Override
	public void configure() throws Exception {
		from("kafka:" + topicName + "?brokers=" + kafkaServer + "&groupId=topic2")
				.to("slack:#" + channel + "?webhookUrl=" + webHookUrl);
	}

}
