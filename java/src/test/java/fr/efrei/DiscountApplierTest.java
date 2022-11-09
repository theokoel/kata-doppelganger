package fr.efrei;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class NotifierTest implements Notifier {

  public ArrayList<String> notifs = new ArrayList<String>();

  @Override
  public void notify(User user, String message) {
    // TODO Auto-generated method stub
    notifs.add(user.name() + " " + message);
  }

}


public class DiscountApplierTest {
  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    // TODO: trigger the bug in DiscountApplier.applyV1() by implementing the Notifier interface

    User user1 = new User("Guitton", "guitton@efrei.net");
    User user2 = new User("Koel", "koel@efrei.net");
    List<User> userList = new ArrayList<User>();
    userList.add(user1);
    userList.add(user2);

    NotifierTest MyNotifier = new NotifierTest();

    DiscountApplier DA = new DiscountApplier(MyNotifier);
    DA.applyV1(20, userList);
    System.out.println(MyNotifier.notifs.toString());

    assertEquals("[Guitton You've got a new discount of 20,000000, Koel You've got a new discount of 20,000000]", MyNotifier.notifs.toString(), "Discount applying V1 failed");

  }

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v2() {
    // TODO: trigger the bug in DiscountApplier.applyV2() by implementing Notifier interface

    User user1 = new User("Guitton", "guitton@efrei.net");
    User user2 = new User("Koel", "koel@efrei.net");
    List<User> userList = new ArrayList<User>();
    userList.add(user1);
    userList.add(user2);

    NotifierTest MyNotifier = new NotifierTest();

    DiscountApplier DA = new DiscountApplier(MyNotifier);
    DA.applyV2(20, userList);
    System.out.println(MyNotifier.notifs.toString());

    assertEquals("[Guitton You've got a new discount of 20,000000, Koel You've got a new discount of 20,000000]", MyNotifier.notifs.toString(), "Discount applying V2 failed");

  }

}
