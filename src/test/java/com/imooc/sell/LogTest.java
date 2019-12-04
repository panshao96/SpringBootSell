package com.imooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class LogTest {

    @Test
    public void test1() {
        String name = "imooc";
        log.debug("debug..........{}", name);
        log.info("info............{}", name);
        log.error("error..........{}", name);
    }
}
