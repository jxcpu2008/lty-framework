package testExample;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-content.xml", "classpath:/spring-mvc.xml" })
// 当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = true)
// 记得要在XML文件中声明事务哦~~~我是采用注解的方式
@Transactional
public class ExampleTests {

	@Autowired
	private WebApplicationContext wac;

	@SuppressWarnings("unused")
	private MockMvc mockMvc;

	@Before
	public void setup() {
		// webAppContextSetup 注意上面的static import
		// webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS
		// WebApplicationContext context =
		// ContextLoader.getCurrentWebApplicationContext();
		// 如果控制器包含如上方法 则会报空指针
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	/*
	 * @Test //有些单元测试你不希望回滚
	 * 
	 * @Rollback(false) public void ownerId() throws Exception {
	 * mockMvc.perform((get("/spring/rest/4.do"))).andExpect(status().isOk())
	 * .andDo(print()); }
	 * 
	 * @Test public void test() throws Exception {
	 * mockMvc.perform((get("/spring/test.do"))).andExpect(status().isOk())
	 * .andDo(print()) .andExpect(model().attributeHasNoErrors("teacher")); }
	 * 
	 * @Test public void testb() throws Exception {
	 * mockMvc.perform((get("/spring/testb.do"))).andExpect(status().isOk())
	 * .andDo(print()); }
	 * 
	 * @Test public void getAccount() throws Exception {
	 * mockMvc.perform((post("/spring/post.do").param("abc", "def")))
	 * .andExpect(status().isOk()).andDo(print()); }
	 */
}
