package test2;

// A methodu B'ye bagli olsun
// A methodunu Test ederken B'yi dogru gibi Kabul edip A'yi test ederiz
// A'da Hata Yoksa B'yi ayri bir sekilde test ederek hatayi bulma yoluna gideriz.
//B metodunun beklenen işlevi doğru olarak yaptığını kabul
//etmek için mock(sahte, vekil vs) obje kullanılır.

import mockito1.PaymentManager;
import mockito1.PaymentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/// sahte obje üretmek icin mockito1 kütüphanesini ekleriz
///        <!--Mockito : Mock obyeler oluşturma icin kullanılır.-->
//        <!-- MOCKITO https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter -->
//        <dependency>
//            <groupId>org.mockito1</groupId>
//            <artifactId>mockito1-junit-jupiter</artifactId>
//            <version>4.5.1</version>
//            <scope>test</scope>
//        </dependency>
//        <!-- MOCKITO https://mvnrepository.com/artifact/org.mockito/mockito-core -->
//        <dependency>
//            <groupId>org.mockito1</groupId>
//            <artifactId>mockito1-core</artifactId>
//            <version>4.5.1</version>
//            <scope>test</scope>
//        </dependency>

public class TestPaymentService {

    //PaymentManager için ayrı bir test classı oluşturulur
    //ve metodları için unit testler yazılır.
    //checkPaymentStatus metodunu test edelim.
    //1-verilen id(100) göre STATUS : SUCCESS döndürür -->beklenen işlev
    //2-getPaymentStatus methodunu cağırır -->işlevi var beklenen işlev
    @Test
    void testCheckPaymentStatus() {

        //1-PaymentService PaymentManager objesine bağımlı
        //PaymentManager objesine ihtiyac var : payment manager objesi yerine sahte veya vekil obje(mock) kullaıcaz
        PaymentManager pm = mock(PaymentManager.class);//vekil
        // vekil'e gercek objenin nasıl davranması gerektiğini gösterelim.
        when(pm.getPaymentStatus(100)).thenReturn("SUCCESS");
        //getPaymentStatus beklenen işlevi yerine getirdiğini kabul etmiş olduk

        //2-PaymentService objesini oluşturalım
        PaymentService paymentService = new PaymentService(pm);

        String actual = paymentService.checkPaymentStatus(100);
        String expected = "STATUS : SUCCESS";

        assertEquals(expected, actual);

        //getPaymentStatus tam olarak 1 kez 100 idsi ile çağrılıyor mu?
        verify(pm, times(1)).getPaymentStatus(100);

    }






























}
