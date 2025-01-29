package tdd;

//TDD:test driven development:kodlardan önce testi yazma yaklaşımıdır
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
    void setAccount(){
        account=new BankAccount("12345",100.0,1000.0);
    }

    @AfterEach
    void setAccountToNull(){
        account=null;
    }

    //hesap oluşturma işlemi
    @Test
    void testCreationAccount(){
        assertNotNull(account,"Not null...");//null olmadığını iddia etmenizi sağlar.
        assertEquals("12345",account.getAccountNumber());//hesap numarasını kontrol eder
        assertEquals(100.0,account.getBalance());//bakiyeyi kontrol eder
        assertEquals(1000.0,account.getDailyWithdrawLimit());//günlük çekim limitini kontrol eder
        assertEquals(0,account.getDailyWithdrawnAmount());//günlük para cekme miktarı 0 eşit olmalı
        assertEquals(0,account.getHistory().size());//history isleminin boş olmasını bekleyebiliriz.
    }

    //para yatırma testleri
    //Pozitif miktar yatırıldığında bakiye artmalı.
    @Test
    void testDepositWithPositiveAmount(){
        // Hesap Geçmişi: ne ekledik.
        int size = account.getHistory().size(); // Mevcut hesap geçmişi boyutu
        double balance = account.getBalance(); // Mevcut bakiye

        account.deposit(200.0); // Beklenen bakiyenin +200.0 artması

        assertEquals(balance + 200.0, account.getBalance()); // Mevcut değerin 200.0 artması bekleniyor
        assertEquals(size + 1, account.getHistory().size()); // Daha önceki hesap geçmişinden 1 fazla olmalı
    }


    // Negatif miktar yatırıldığında para yatırma başarısız olmalı, hata fırlatmalı.
    @Test
    void testDepositWithNegativeAmount(){
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











}
