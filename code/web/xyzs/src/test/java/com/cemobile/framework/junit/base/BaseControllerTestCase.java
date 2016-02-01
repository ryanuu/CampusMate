package com.cemobile.framework.junit.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = {
        "classpath*:spring-dispatcher-servlet.xml",
        "classpath*:spring-security.xml",
        "classpath*:spring-res.xml",
        "classpath*:spring-view.xml",
        "classpath*:spring-cache.xml",
        "classpath*:spring-osworkflow.xml",
        "classpath:spring-db.xml"

})
public class BaseControllerTestCase {
	@Autowired
	protected WebApplicationContext wac;
	protected MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	// @Test
	// public void testDemo() throws Exception {
	// ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
	// .post("/demo/list").accept(MediaType.TEXT_HTML)
	// .param("page", "1").param("rows", "10"));
	// }
}
