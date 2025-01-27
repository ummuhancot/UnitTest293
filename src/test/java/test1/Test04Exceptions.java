package test1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test04Exceptions {


    @Test
    void testLengthForNullValue(){

        //pazitive seneryo
        String str = "Hello World!";
        //str.length()-->12 (test ettik)

        //negative seneryo bu seneryoda exception fırlatılırsa method başarılı olur.
        String str2 = null;
        //str2.length()-->NullPointerException(hata fırlatmalı)
        assertThrows(NullPointerException.class,()->{
            str2.length();
        });//iddea ediyorum fırlatır parametrede vermiş olduğum exception

    }


    @Test
    void testDivideForArithmeticException(){
        int sayi1 = 999;
        int sayi2 = 0;//bölenin paydanın 0 olma durumu riskli bir durumdur

        assertThrows(ArithmeticException.class,()->{
            System.out.println(sayi1/sayi2);
        });




    }



}
