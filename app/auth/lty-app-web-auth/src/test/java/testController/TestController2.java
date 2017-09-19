package testController;

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

import com.lty.framework.common.exceptions.LoginException;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-content.xml", "classpath:/spring-mvc.xml" })
// 当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = true)
// @Transactional
public class TestController2 {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(TestController2.class);
	@SuppressWarnings("unused")
	@Autowired
	private WebApplicationContext wac;

	@SuppressWarnings("unused")
	private MockMvc mockMvc;

	@Before
	public void setup() {
		/* this.mockMvc = webAppContextSetup(this.wac).build(); */
	}

	@Test
	public void testinsertSelective() throws Exception {
		/*
		 * mockMvc.perform( (post("/user/insertSelective").param("id",
		 * "admin12").param("status", "1").param("type", "1").param("loginName",
		 * "admin").param( "password", "1"))).andExpect(status().isOk())
		 * .andDo(print());
		 */
	}

	@Test
	public void testSelectByPrimaryKey() throws Exception {
		/*
		 * MockHttpServletResponse response =
		 * mockMvc.perform((post("/user/selectByPrimaryKey.shtml?id=0")))
		 * .andReturn().getResponse();
		 * logger.info(LogConstant.LOG_MARK+JSON.toJSONString(response));
		 */

	}

	@Test
	public void testShowUser() throws Exception {
		// mockMvc.perform((get("/user/0/showUser.shtml")))
		// .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testGet() throws Exception {
		// mockMvc.perform(post("/user/0/showUser.shtml")).andExpect(status().isOk());

	}

	/*
	 * @Test //有些单元测试你不希望回滚
	 * 
	 * @Rollback(false) public void testInsert() throws Exception {
	 * mockMvc.perform((post("/insertTest"))).andExpect(status().isOk())
	 * .andDo(print()); }
	 */
	@Test
	public void testb() throws Exception {
		/*
		 * mockMvc.perform((get("/spring/testb.do"))).andExpect(status().isOk())
		 * .andDo(print());
		 */
	}

	public static void main(String[] args) {
		throw new LoginException("33", "333");
		// logger.info("222");
	}

}