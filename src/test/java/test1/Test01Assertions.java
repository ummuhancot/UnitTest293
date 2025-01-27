package test1;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Test01Assertions {


    @Test//bu bir test metodudur ve tek başına çalıştırılabilir.
    public void test(){
        //A methodu icin bir test metodu

    }


    //JDK da (java kütüphaneleri icindeki methodları test edicez) hazır olan methodları test edelim

    //String in length methodunu test edelim
    @Test
    public void testLength(){

        String str = "Hello world!!!";
        int gercekDeger = str.length();//12
        int beklenenDeger =14;//test gecmezse methodu düzeltiriz

        assertEquals(beklenenDeger,gercekDeger,"Yanlıs karakter kayısı veriyor!!!");//message : burdada essertion başarsızsa hata yı yazabiliriz
        //assertEquals(12,str.length());
        //ilkinde impor edemiyor biz yapıcaz yazdıktan sonra
        //beklenenDeger ile gercekDeger i karşılaştırır, eşit ise test geçer(passed)
        //aksi halde test başarısız olur(failed)
    }//geriye dönüşü olmaz test methodlarının return; olmaz yani


    //Math addExact
    @Test
    public void testAddExact(){
        //beklenen değer ile gercekleşen değeri kontrol edeceğiz
        int actual = Math.addExact(9,6);
        int expected= 15;
        int notExpected=16;
        assertEquals(expected,actual);//beklenen değer gercek değerle aynı mı?
        //sırası önemli hata mesajı anlamsız olur tersi olursa karşılaştırma acısından bir şey değişmez ama.
        assertNotEquals(notExpected,actual);
    }




}
