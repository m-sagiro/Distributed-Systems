package JMS;

import FundStock.Fund;
import FundStock.Stock;

import javax.jms.*;
import javax.naming.*;
import java.util.*;

public class Server implements MessageListener{

    private Fund fund1 = new Fund("fund1");
    private Fund fund2 = new Fund("fund2");
    private TopicPublisher publisher;
    private TopicSession session;

    public Server(TopicPublisher publisher, TopicSession session){
        this.publisher = publisher;
        this.session = session;
    }

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

        Topic topic_get_invoke = (Topic) context.lookup("dynamicTopics/topicInvoke");
        Topic topic_set_response = (Topic) context.lookup("dynamicTopics/topicResponse");

        TopicSubscriber subscriber = session.createSubscriber(topic_get_invoke);
        TopicPublisher publisher = session.createPublisher(topic_set_response);

        //MessageListener
        subscriber.setMessageListener(new Server(publisher, session));
        //MessageListener end


        //Reading messages until input
        Scanner sc = new Scanner(System.in);
        String str = sc.next();


        session.close();
        conn.close();
    }

    @Override
    public void onMessage(Message message) {
        TextMessage rec_message = (TextMessage) message;
        try {
            String invoke = rec_message.getText();
            System.out.println("Received invoke: " + invoke);
            String[] invoked = invoke.split(" ");

            switch (invoked[0]) {
                case "as":
                    if (invoked[1].equals("f1")) {
                        fund1.addStock(invoked[2], Float.parseFloat(invoked[3]), Integer.parseInt(invoked[4]));
                        System.out.println("Server INFO: Stock added to fund1");
                        String response_message = "Added stock successfully";
                        publish(response_message, publisher, session);
                    } else {
                        fund2.addStock(invoked[2], Float.parseFloat(invoked[3]), Integer.parseInt(invoked[4]));
                        System.out.println("Server INFO: Stock added to fund2");
                        String response_message = "Added stock successfully";
                        publish(response_message, publisher, session);
                    }
                    break;
                case "gs":
                    if (invoked[1].equals("f1")) {
                        ArrayList<Stock> funds = new ArrayList<Stock>(fund1.getAllStocks());
                        String[] names = new String[funds.size()];
                        for(int i=0; i< funds.size(); i++){
                            names[i] = funds.get(i).getStockName();
                        }
                        String response_message = Arrays.toString(names);
                        publish(response_message, publisher, session);
                        System.out.println("Server INFO: Returned list of all stocks in fund1");
                    } else {
                        ArrayList<Stock> funds = new ArrayList<Stock>(fund2.getAllStocks());
                        String[] names = new String[funds.size()];
                        for(int i=0; i< funds.size(); i++){
                            names[i] = funds.get(i).getStockName();
                        }
                        String response_message = Arrays.toString(names);
                        publish(response_message, publisher, session);
                        System.out.println("Server INFO: Returned list of all stocks in fund2");
                    }
                    break;
                case "gsbn":
                    if (invoked[1].equals("f1")) {
                        Stock stock = fund1.getStockByName(invoked[2]);
                        String dividend = String.valueOf(stock.getStockDividend());
                        String response_message = "Stock dividend for " + stock.getStockName() + " is " + dividend;
                        publish(response_message, publisher, session);
                        System.out.println("Server INFO: Stock dividend returned");
                    } else {
                        Stock stock = fund2.getStockByName(invoked[2]);
                        String dividend = String.valueOf(stock.getStockDividend());
                        String response_message = "Stock dividend for " + stock.getStockName() + " is " + dividend;
                        publish(response_message, publisher, session);
                        System.out.println("Server INFO: Stock dividend returned");
                    }
                    break;
                default:
                    System.out.println("Received wrong encoding");
                    break;
            }

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public static void publish(String message, TopicPublisher publisher, TopicSession session) throws JMSException {
        TextMessage textMessage = session.createTextMessage(message);
        System.out.println("Published response: " + textMessage.getText());
        publisher.publish(textMessage);
    }
}