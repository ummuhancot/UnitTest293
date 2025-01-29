package test2;

import mockito1.PaymentManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPaymentManager {

    PaymentManager paymentManager;

    @BeforeEach//payment objesini böyle oluşturduk.
    void createObject(){//test etmeden önce calısır
        paymentManager= new PaymentManager();
    }

    @AfterEach
    void setNullToObject(){
        paymentManager=null;
    }


    //getPaymentStatus methodunu test edelim.
    @Test
    void testGetPaymentStatus(){
        String actual = paymentManager.getPaymentStatus(100);//gercek değer
        String expected="SUCCESS";//beklenen değer
        assertEquals(expected,actual);
    }






}
