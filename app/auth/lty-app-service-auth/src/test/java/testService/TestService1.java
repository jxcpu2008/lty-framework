package testService;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.lty.app.facade.auth.model.Menu;
import com.lty.app.facade.auth.model.User;
import com.lty.app.facade.auth.vo.UserQueryModel;
import com.lty.app.service.auth.biz.MenuServiceI;
import com.lty.app.service.auth.biz.UserServiceI;
import com.lty.framework.common.constant.LogConstant;
import com.lty.framework.common.page.Page;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-content.xml", })
public class TestService1 {
	private static Logger logger = LoggerFactory.getLogger(TestService1.class);
	@Resource
	private UserServiceI userService;
	@Resource
	private MenuServiceI menuService;

	@Test
	public void test1() {

		User u = userService.selectByPrimaryKey("0");
		logger.info(LogConstant.LOG_MARK + JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void test2() {
		UserQueryModel record = new UserQueryModel();
		record.setRows(3);
		record.setPage(2);
		Page u = userService.findObjectsByPage(record);
		logger.info(LogConstant.LOG_MARK + JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void testfindAllTreeNode() {

		List<Menu> findAllTreeNode = menuService.findAllTreeNode();

		logger.info(LogConstant.LOG_MARK + JSON.toJSONStringWithDateFormat(findAllTreeNode, "yyyy-MM-dd HH:mm:ss"));
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testfindUserAndRoles() {
		UserQueryModel record = new UserQueryModel();
		record.setRows(5);
		record.setPage(1);
		Page u = userService.findUserAndRoles(record);
		logger.info(LogConstant.LOG_MARK + JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		UserQueryModel record = new UserQueryModel();
		record.getPageModel().setTotal(100);
		record.setRows(10);
		record.setPage(2);
		Page pageModel = record.getPageModel();
		System.out.println(pageModel.getStart() + "----");
	}
}
