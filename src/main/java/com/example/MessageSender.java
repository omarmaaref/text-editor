package com.example;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageSender {
    private static Channel channel;
    public static Channel getChannel() throws IOException, TimeoutException {
        if (channel == null) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
        }
        return channel;
    }
    /**
     * send message to queue
     */
    public static void sendMessage(String message, String queueName) {
        try {
            channel = getChannel();
            channel.queueDeclare(queueName, // queue name
                                 false,     // durable
                                 false,     // exclusive
                                 false,     // auto-delete
                                 null);     // arguments
            channel.basicPublish("", queueName, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * read message from queue queueName and feed to callback
     */
    public static void
    readMessage(String queueName,
                java.util.function.Consumer<String> callback) {
        try {
            channel = getChannel();
            channel.queueDeclare(queueName, // queue name
                                 false,     // durable
                                 false,     // exclusive
                                 false,     // auto-delete
                                 null);     // arguments
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                callback.accept(message);
            };
            channel.basicConsume(queueName, true, deliverCallback,
                                 consumerTag -> {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
