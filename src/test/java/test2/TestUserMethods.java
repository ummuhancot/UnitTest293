package test2;

import mockito2.UserRepo;
import mockito2.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TestUserMethods {

    //UserServicede getUser metodunu test edelim
    //1-id:1,(2,3) degeri verildiğinde return Dear Furkan
    //2- reponun findUsernameById metodu 1 kere çağrılmalı
    //3-id:99 throws RuntimeException fırlatmalı

    @Test
    void testGetUser(){

        UserRepo repo=mock(UserRepo.class);
        when(repo.findUsernameById(1)).thenReturn("Furkan");
        when(repo.findUsernameById(99)).thenReturn(null);


        UserService service=new UserService(repo);

        //1-pozitif : id=1
        assertEquals("Dear Furkan",service.getUser(1));
        verify(repo,times(1)).findUsernameById(1);


        //2-negatif: id=99
        assertThrows(RuntimeException.class,()->{
            service.getUser(99);
        });
        verify(repo,times(1)).findUsernameById(99);

    }

    //findUsernameById metodu da ayrıca test edilmeli


}
