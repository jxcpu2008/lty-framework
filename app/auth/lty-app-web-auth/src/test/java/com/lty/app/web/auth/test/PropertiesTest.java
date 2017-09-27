package com.lty.app.web.auth.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/application-config.xml"})
public class PropertiesTest {

	@Resource
    private Map<String, String> handlerMapping;
	
    @Test
    public void testHandlerMapping() throws Exception {
        System.out.println(handlerMapping);
        // 下面两个测试都不通过，因为map的key是String，下面两个测试提供的key都是int，即使被包装为Integer，也是没有用
//        assertEquals("com.lty.app.web.auth.message.handler.MyMessageHandler", handlerMapping.get(10000));
//        assertEquals("com.lty.app.web.auth.message.handler.MyMessageHandler", (String) handlerMapping.get(10000));
        
        // 下面三个测试均通过，关键点在于提供的key要为String类型
//        assertEquals("com.lty.app.web.auth.message.handler.MyMessageHandler", handlerMapping.get("10000"));
//        assertEquals("com.lty.app.web.auth.message.handler.MyMessageHandler", handlerMapping.get(String.valueOf(10000)));
//        assertEquals("com.lty.app.web.auth.message.handler.MyMessageHandler", (String) handlerMapping.get(String.valueOf(10000)));
        
//        assertEquals(Class.forName("com.lty.app.web.auth.message.handler.MyMessageHandler"), handlerMapping.get(10000));
        String clazzName = handlerMapping.get("10000");
        Class<?> clazz = Class.forName(clazzName);
        assertEquals(Class.forName("com.lty.app.web.auth.message.handler.MyMessageHandler"), clazz);
    }
}
