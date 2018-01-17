package mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PahoDemo {

  MqttClient client;
  
  public PahoDemo() {}

  public static void main(String[] args) {
    new PahoDemo().doDemo();
  }

  public void doDemo() {
    try {
      client = new MqttClient("tcp://10.0.0.143:1883", "test");
      client.connect();
      System.out.println("Connecting to broker:");
      MqttMessage message = new MqttMessage();
      message.setPayload("A single message".getBytes());
      client.publish("test", message);
      client.disconnect();
    } catch (MqttException e) {
      e.printStackTrace();
    }
  }
}