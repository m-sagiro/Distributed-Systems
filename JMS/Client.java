package JMS;

import javax.jms.*;
import javax.naming.*;
import java.io.ObjectOutputStream;
import java.util.*;

public class Client {
	public static void main(String argv[]) throws Exception {
		Hashtable<String, String> properties = new Hashtable<String, String>();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
						 "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");
		Context context = new InitialContext(properties);
		TopicConnectionFactory connFactory =
			  (TopicConnectionFactory) context.lookup("ConnectionFactory");
		TopicConnection conn = connFactory.createTopicConnection();
		conn.start();
		TopicSession session =
			  conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic_invoke = (Topic) context.lookup("dynamicTopics/topicInvoke");
		TopicPublisher publisher = session.createPublisher(topic_invoke);
		Topic topic_response = (Topic) context.lookup("dynamicTopics/topicResponse");
		TopicSubscriber subscriber = session.createSubscriber(topic_response);


		//Create invokeMessage
		String add_stock_f1_stock1 = "as f1 stock1 5.5 30";
		String add_stock_f1_stock2 = "as f1 stock2 10.5 50";
		String add_stock_f1_stock3 = "as f1 stock3 2.5 40";
		String add_stock_f1_stock4 = "as f1 stock4 11.5 75";
		String add_stock_f2_stock1 = "as f2 stock1 7.5 45";
		String add_stock_f2_stock2 = "as f2 stock2 13.5 80";
		String add_stock_f2_stock3 = "as f2 stock3 4.5 25";
		String add_stock_f2_stock4 = "as f2 stock4 6.5 10";
		String get_stocks_f1 = "gs f1";
		String get_stocks_f2 = "gs f2";
		String get_stock_dividend_by_name_f1 = "gsbn f1 stock1";
		String get_stock_dividend_by_name_f2 = "gsbn f2 stock1";
		//Create invokeMessageEnd

		publish(add_stock_f1_stock1, publisher, session);
		subscribe(subscriber);
		publish(add_stock_f1_stock2, publisher, session);
		subscribe(subscriber);
		publish(add_stock_f1_stock3, publisher, session);
		subscribe(subscriber);
		publish(add_stock_f1_stock4, publisher, session);
		subscribe(subscriber);
		publish(add_stock_f2_stock1, publisher, session);
		subscribe(subscriber);
		publish(add_stock_f2_stock2, publisher, session);
		subscribe(subscriber);
		publish(add_stock_f2_stock3, publisher, session);
		subscribe(subscriber);
		publish(add_stock_f2_stock4, publisher, session);
		subscribe(subscriber);

		publish(get_stocks_f1, publisher, session);
		subscribe(subscriber);
		publish(get_stocks_f2, publisher, session);
		subscribe(subscriber);

		publish(get_stock_dividend_by_name_f1, publisher, session);
		subscribe(subscriber);
		publish(get_stock_dividend_by_name_f2, publisher, session);
		subscribe(subscriber);


		session.close();
		conn.close();
	}

	public static void publish(String message, TopicPublisher publisher, TopicSession session) throws JMSException {
		TextMessage textMessage = session.createTextMessage(message);
		System.out.println("Published request: " + textMessage.getText());
		publisher.publish(textMessage);
	}

	public static void subscribe(TopicSubscriber subscriber) throws JMSException {
		TextMessage textMessage = (TextMessage) subscriber.receive();
		System.out.println("Received response: " + textMessage.getText());
	}
}