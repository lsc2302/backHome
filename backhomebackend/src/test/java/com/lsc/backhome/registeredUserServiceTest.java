package com.lsc.backhome;
import com.lsc.backhome.service.impl.RegisteredUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BackhomeApplication.class)

public class registeredUserServiceTest {
    @Autowired
    private RegisteredUserServiceImpl registeredUserServiceImpl;

    @Test
    public void test1() {
        System.out.println(registeredUserServiceImpl.getUserProfile("admin"));
    }
}