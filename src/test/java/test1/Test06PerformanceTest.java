package test1;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class Test06PerformanceTest {


    @Test//performans testi
    void testPerformanceSum(){
        assertTimeout(Duration.ofMillis(5),()->{//verilen sürede tamamlanırsa test gecer
            long sum=0;
            for (long i=1;i<=1000000;i++){
                sum+=i;
            }
        });
    }
    //assert yazdıktan sonra methodun ismi yazılacak böylece kontrol edilir.

    //2. parametrede verilen kod 1. parametrede verilen sürede gerceklesirse test passed olur
    //degilse failed olur, buna performans testi denir




}
