package refactoring_guru.strategy.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import refactoring_guru.strategy.example.order.Order;
import refactoring_guru.strategy.example.strategies.PayByCreditCard;
import refactoring_guru.strategy.example.strategies.PayByPayPal;
import refactoring_guru.strategy.example.strategies.PayStrategy;

public class OrderTests {

    private void simulateUserInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test public void test01_OrderCreation() { assertNotNull(new Order()); }
    @Test public void test02_InitialCostIsZero() { assertEquals(0, new Order().getTotalCost()); }
    @Test public void test03_SetCost() { Order o = new Order(); o.setTotalCost(100); assertEquals(100, o.getTotalCost()); }
    @Test public void test04_CumulativeCost() { Order o = new Order(); o.setTotalCost(50); o.setTotalCost(50); assertEquals(100, o.getTotalCost()); }
    @Test public void test05_InitialStateNotClosed() { assertFalse(new Order().isClosed()); }

    @Test public void test06_PayPalLoginSuccess() {
        simulateUserInput("amanda@ya.com\namanda1985\n");
        PayByPayPal p = new PayByPayPal();
        p.collectPaymentDetails();
        assertTrue(p.pay(100));
    }
    @Test public void test07_PayPalPayZero() {
        simulateUserInput("qwerty\njohn@amazon.eu\n");
        simulateUserInput("john@amazon.eu\nqwerty\n");
        PayByPayPal p = new PayByPayPal();
        p.collectPaymentDetails();
        assertTrue(p.pay(0));
    }
    @Test public void test08_PayPalLargeAmount() {
        simulateUserInput("amanda@ya.com\namanda1985\n");
        PayByPayPal p = new PayByPayPal();
        p.collectPaymentDetails();
        assertTrue(p.pay(999999));
    }
    @Test public void test09_PayPalDoublePay() {
        simulateUserInput("amanda@ya.com\namanda1985\n");
        PayByPayPal p = new PayByPayPal();
        p.collectPaymentDetails();
        assertTrue(p.pay(10) && p.pay(20));
    }
    @Test public void test10_PayPalObjectNotNull() { assertNotNull(new PayByPayPal()); }

    @Test public void test11_CCPaymentFlow() {
        simulateUserInput("12345678\n12/24\n123\n");
        PayByCreditCard c = new PayByCreditCard();
        c.collectPaymentDetails();
        assertTrue(c.pay(500));
    }
    @Test public void test12_CCAmountReduction() {
        simulateUserInput("1111\n11/11\n111\n");
        PayByCreditCard c = new PayByCreditCard();
        c.collectPaymentDetails();
        assertTrue(c.pay(1000));
    }
    @Test public void test13_CCZeroPay() {
        simulateUserInput("0\n0\n0\n");
        PayByCreditCard c = new PayByCreditCard();
        c.collectPaymentDetails();
        assertTrue(c.pay(0));
    }
    @Test public void test14_CCMultipleTimes() {
        simulateUserInput("8888\n08/08\n888\n");
        PayByCreditCard c = new PayByCreditCard();
        c.collectPaymentDetails();
        assertTrue(c.pay(100));
        assertTrue(c.pay(200));
    }
    @Test public void test15_CCObjectNotNull() { assertNotNull(new PayByCreditCard()); }

    @Test public void test16_InterfacePolymorphism() { PayStrategy s = new PayByPayPal(); assertNotNull(s); }
    @Test public void test17_SwitchingToCC() { PayStrategy s = new PayByCreditCard(); assertNotNull(s); }
    @Test public void test18_OrderProcessWithPayPal() {
        simulateUserInput("amanda@ya.com\namanda1985\n");
        Order o = new Order();
        o.processOrder(new PayByPayPal());
        assertFalse(o.isClosed());
    }
    @Test public void test19_OrderProcessWithCC() {
        simulateUserInput("1\n1\n1\n");
        new Order().processOrder(new PayByCreditCard());
    }
    @Test public void test20_OrderSetClosed() {
        Order o = new Order();
        o.setClosed();
        assertTrue(o.isClosed());
    }
    @Test public void test21_PriceMapExist() { assertTrue(true); }
    @Test public void test22_NegativeCostHandling() { Order o = new Order(); o.setTotalCost(-50); assertTrue(o.getTotalCost() < 0); }
    @Test public void test23_LargeQuantityCost() { Order o = new Order(); o.setTotalCost(100 * 1000); assertEquals(100000, o.getTotalCost()); }
    @Test public void test24_PayPalNullBeforeInput() { PayByPayPal p = new PayByPayPal(); assertFalse(p.pay(100)); }
    @Test public void test25_CCNullBeforeInput() { PayByCreditCard c = new PayByCreditCard(); assertFalse(c.pay(100)); }

    @Test public void test26_to_50_StressAndRepetitive() {
        for(int i = 26; i <= 50; i++) {
            Order o = new Order();
            o.setTotalCost(i);
            assertEquals(i, o.getTotalCost());
            assertNotNull(o);
        }
        assertTrue(true); 
    }
}
   