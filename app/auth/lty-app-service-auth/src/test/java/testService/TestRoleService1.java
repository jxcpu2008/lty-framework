package testService;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.app.service.auth.biz.RoleServiceI;
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
public class TestRoleService1 {
	private static Logger logger = LoggerFactory.getLogger(TestRoleService1.class);

	@Resource
	private RoleServiceI roleService;

	@Test
	public void test3() {

		RoleQueryModel record = new RoleQueryModel();
		record.setRows(10);
		record.setPage(1);
		@SuppressWarnings("rawtypes")
		Page u = roleService.findRoleAndResources(record);
		logger.info(LogConstant.LOG_MARK + JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

}
