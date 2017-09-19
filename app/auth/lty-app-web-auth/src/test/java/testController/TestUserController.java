package testController;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author liuwei 2015-4-7
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-content.xml", "classpath:/spring-mvc.xml" })
// 当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = true)
// @Transactional
public class TestUserController {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(TestUserController.class);
	@Autowired
	private WebApplicationContext wac;

	@SuppressWarnings("unused")
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void testinsertSelective() throws Exception {
		/*
		 * mockMvc.perform(
		 * (post("/user/deleteByPrimaryKey.shtml"))).andExpect(status().isOk())
		 * .andDo(print());
		 */
	}

}