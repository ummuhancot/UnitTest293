package test1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test03BeforeAllAfterAll {

    /*
    veritabanı bağlantısını açma ve kapama vs
    büyük hazırlıklarda kullanılabilir
    */

    @BeforeAll
    static void beforeAll(){
        System.out.println("Veri tabanı bağlantısı başladı.");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Veri tabanı bağlantısı kapatıldı.");
    }
    //bu methodlar tüm classlardan önce calışması gerektiği icin static olmalı

    //split metodunu test edelim
    @Test
    void testSplit(){
       String[] actual =  "Junit bir unit test kütüphanesidir.".split(" ");//bosluktan böldük
       String[] excepted = {"Junit","bir","unit","test","kütüphanesidir."};//bekleneni yazdık

       assertArrayEquals(excepted,actual);
       //beklenen ve gercek dizileri karşılaştırma kullanılır.
        System.out.println("testSplit çalıştı.");
    }

    //Math min
    @Test
    void testMin(){
        int actual = Math.min(999,2);
        int expected = 2;

        assertEquals(expected,actual);
        assertTrue(actual==2);
        System.out.println("testMin çalıstı");

    }




}
