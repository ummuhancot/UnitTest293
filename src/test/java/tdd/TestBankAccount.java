package tdd;

//TDD:test driven development:kodlardan önce testi yazma yaklaşımıdır İLK ALGORİTMAYI KURMAK ÖNEMLİ KODA DÖKMEK DAHA KOLAY OLUR.
//öncelikle testler yazılır ve ilk etapta testler başarısız olur, daha sonra
//testten geçecek şekilde minimum kod yazılır
//birimin işlevleri için tüm senaryolara göre testler önceden yazıldığı için
//kodun daha doğru, güvenilir yani sağlam olmasını sağlar.

//1-henüz kodlar yok
//2-test seneryoları belirliyoruz
/*
I-Para Yatırma İşlemi:

-->Pozitif miktar yatırıldığında bakiye artmalı.

-->Negatif miktar yatırıldığında para yatırma başarısız olmalı, hata fırlatmalı.

II-Para Çekme İşlemi:

-->Bakiye yeterli olduğunda para çekme işlemi başarılı olmalı, bakiye azalmalı

-->Bakiye yetersiz olduğunda para çekme işlemi başarısız olmalı, bakiye aynı kalmalı

-->Günlük çekim limiti aşıldığında para çekme işlemi başarısız olmalı, bakiye aynı kalmalı

-->Negatif miktar girildiğinde para çekme işlemi başarısız olmalı, hata fırlatılmalı
hata fırlatmalı.

3-Hesap Geçmişi:

-->Para çekme ve yatırma işlemleri hesap geçmişine eklenmeli.
*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBankAccount {


    BankAccount account;//null

    @BeforeEach
    void setAccount() {
        account = new BankAccount("12345", 100.0, 1000.0);
    }

    @AfterEach
    void setAccountToNull() {
        account = null;
    }

    //hesap oluşturma işlemi
    @Test
    void testCreationAccount() {
        assertNotNull(account, "Not null...");//null olmadığını iddia etmenizi sağlar.
        assertEquals("12345", account.getAccountNumber());//hesap numarasını kontrol eder
        assertEquals(100.0, account.getBalance());//bakiyeyi kontrol eder
        assertEquals(1000.0, account.getDailyWithdrawLimit());//günlük çekim limitini kontrol eder
        assertEquals(0, account.getDailyWithdrawnAmount());//günlük para cekme miktarı 0 eşit olmalı
        assertEquals(0, account.getHistory().size());//history isleminin boş olmasını bekleyebiliriz.
    }

    //para yatırma testleri
    //Pozitif miktar yatırıldığında bakiye artmalı.
    @Test
    void testDepositWithPositiveAmount() {
        // Hesap Geçmişi: ne ekledik.
        int size = account.getHistory().size(); // Mevcut hesap geçmişi boyutu
        double balance = account.getBalance(); // Mevcut bakiye

        assertTrue(account.deposit(200.0));//balance+200.0 // Beklenen bakiyenin +200.0 artması true olmalı

        assertEquals(balance + 200.0, account.getBalance()); // Mevcut değerin 200.0 artması bekleniyor
        assertEquals(size + 1, account.getHistory().size()); // Daha önceki hesap geçmişinden 1 fazla olmalı
    }


    // Negatif miktar yatırıldığında para yatırma başarısız olmalı, hata fırlatmalı.
    @Test
    void testDepositWithNegativeAmount() {
        int size = account.getHistory().size(); // Mevcut hesap geçmişi boyutu
        double balance = account.getBalance(); // Mevcut bakiye

        // Negatif miktar yatırma işlemi hata fırlatmalı
        assertThrows(RuntimeException.class, () -> {
            account.deposit(-100.0);
        });
        // 0 miktar yatırma işlemi hata fırlatmalı
        assertThrows(RuntimeException.class, () -> {
            account.deposit(0);
        });
        // Bakiye değişmemeli
        assertEquals(balance, account.getBalance());
        // Hesap geçmişi değişmemeli
        assertEquals(size, account.getHistory().size());
    }

    //II-Para Çekme İşlemi:
    //-->Bakiye yeterli olduğunda para çekme işlemi başarılı olmalı, bakiye azalmalı
    //pozitive
    @Test
    void testWithdrawForEnoughBalance() {

        // balance:100.0 ise 50.0 çekelim
        double amount = account.getDailyWithdrawnAmount(); // şuana kadar çekilen miktar
        int size = account.getHistory().size(); // hesap geçmişi boyutu

        assertTrue(account.withdraw(50)); // 50 çekme işlemi başarılı olmalı
        assertEquals(50, account.getBalance()); // bakiye 50 olmalı
        assertEquals(size + 1, account.getHistory().size()); // hesap geçmişi boyutu 1 artmalı
        assertEquals(amount + 50, account.getDailyWithdrawnAmount()); // günlük çekilen miktar 50 artmalı
    }


    //-->Bakiye yetersiz olduğunda para çekme işlemi başarısız olmalı, bakiye aynı kalmalı
    //negative
    @Test
    void testWithdrawForBalanceNotEnough() {

        // Bakiye: 100.0 ise 500.0 çekelim
        double amount = account.getDailyWithdrawnAmount(); // Şu ana kadar çekilen miktar
        int size = account.getHistory().size(); // Hesap geçmişi boyutu

        assertFalse(account.withdraw(500.0)); // 500.0 çekme işlemi başarısız olmalı
        assertEquals(100.0, account.getBalance()); // Bakiye aynı kalmalı
        assertEquals(size, account.getHistory().size()); // Hesap geçmişi değişmemeli
        assertEquals(amount, account.getDailyWithdrawnAmount()); // Günlük çekilen miktar değişmemeli
    }

    //-->Günlük çekim limiti aşıldığında para çekme işlemi başarısız olmalı, bakiye aynı kalmalı
    @Test
    void testWithdrawForOverDailyLimit() {
        //günlük limit:1000
        //balance:1500.0 olsun
        account.setBalance(1500.0); // Bakiyeyi 1500.0 olarak ayarlıyoruz
        double amount = account.getDailyWithdrawnAmount();//şuana kadar çekilen miktar:0
        int size = account.getHistory().size(); // Mevcut hesap geçmişi boyutu

        account.withdraw(1000.0);//true-->günlük çekilen miktar:1000.0
        assertFalse(account.withdraw(500.0)); // Günlük limit aşıldığı için 500.0 çekme işlemi başarısız olmalı
        assertEquals(500.0, account.getBalance()); // Bakiye 500.0 olmalı
        assertEquals(size + 1, account.getHistory().size()); // Hesap geçmişi boyutu 1 artmalı öncesinde para cekildiği icin
        assertEquals(1000.0, account.getDailyWithdrawnAmount()); // Günlük çekilen miktar 1000.0 olmalı
    }

    //-->Negatif miktar girildiğinde para çekme işlemi başarısız olmalı, hata fırlatılmalı hata fırlatmalı.
    @Test
    void testWithdrawForNonPositiveAmount() {
        // balance: 100.0 iken -100 ya da 0 çekilirse
        double amount = account.getDailyWithdrawnAmount(); // şu ana kadar çekilen miktar: 0
        int size = account.getHistory().size(); // hesap geçmişi boyutu

        assertThrows(RuntimeException.class, () -> { //hata fırlatmalı negatif para cekmek isterse
            account.withdraw(-100.0);
        });
        assertEquals(100.0, account.getBalance());// Bakiye değişmemeli
        assertEquals(size, account.getHistory().size());// Hesap geçmişi değişmemeli
        assertEquals(amount, account.getDailyWithdrawnAmount());// Günlük çekilen miktar değişmemeli
    }

}