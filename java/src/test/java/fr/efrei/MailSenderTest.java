package fr.efrei;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HttpClientTest implements HttpClient {

  ArrayList<String> clients = new ArrayList<>();

  @Override
  public Response post(String url, Object request) {
    // TODO Auto-generated method stub
    clients.add(url + " " + request);
    return new Response(503, "Internal error");
  }

}


public class MailSenderTest {
  @Test
  void should_make_a_sendgrid_request() {
    // TODO: trigger the bug in MailSender.sendV1() by implementing the HttpClient interface

    User user1 = new User("Guitton", "guitton@efrei.net");

    HttpClientTest MyHttpClient = new HttpClientTest();

    MailSender myMailSender = new MailSender(MyHttpClient);
    myMailSender.sendV1(user1, "Bonjour");

    assertEquals("[https://api.mailprovider.com/v3/ SendRequest[name=Guitton, email=guitton@efrei.net, subject=New notification, message=Bonjour]]", MyHttpClient.clients.toString());

  }

  @Test
  void should_retry_when_getting_a_503_error() {
    // TODO: trigger the bug in MailSender.sendV2() by implementing the HttpClient interface

    User user1 = new User("Guitton", "guitton@efrei.net");

    HttpClientTest MyHttpClient = new HttpClientTest();

    MailSender myMailSender = new MailSender(MyHttpClient);
    myMailSender.sendv2(user1, "Bonjour");

    assertEquals("[https://api.mailprovider.com/v3/ SendRequest[name=Guitton, email=guitton@efrei.net, subject=New notification, message=Bonjour]]", MyHttpClient.clients.toString());

  }
}
