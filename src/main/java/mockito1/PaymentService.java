package mockito1;

/*
Senaryo: PaymentService sınıfı, bir ödeme geçmişi tutan bir PaymentManager sınıfına bağımlıdır.
    PaymentService, ödeme geçmişini kontrol etmek için PaymentHistoryManager'ı kullanır. Bizim test
    senaryomuzda, PaymentService'in checkPaymentStatus metodunu test edeceğiz ve PaymentHistoryManager'ın
    gerçek bir örneğini kullanmak yerine mock bir nesneyle değiştireceğiz.
 */

public class PaymentService {


    //manuel olarak dipendensis enjeksın yaptık.
    private PaymentManager paymentManager;

    public  PaymentService (PaymentManager paymentManager){
        this.paymentManager=paymentManager;
    }

    //kullanıcıya id verilen payment in "STATUS:..."
    public String checkPaymentStatus(int id){
        String str = "STATUS : ";
        String status=paymentManager.getPaymentStatus(id);

        return str+status;
    }
// A methodu B'ye bagli olsun
// A methodunu Test ederken B'yi dogru gibi Kabul edip A'yi test ederiz
// A'da Hata Yoksa B'yi ayri bir sekilde test ederek hatayi bulma yoluna gideriz.
// B methodunun testi gectiğini kabul ediyoruz yani beklenen işlevi doğru olarak yaptığını kabul etmek
// icin mook (sahte,vekil vs) obje kullanılır.

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







}
