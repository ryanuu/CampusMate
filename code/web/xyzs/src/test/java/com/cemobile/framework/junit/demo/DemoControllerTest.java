package com.cemobile.framework.junit.demo;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import com.cemobile.framework.junit.base.BaseControllerTestCase;

public class DemoControllerTest extends BaseControllerTestCase {

	@Test
	public void insert() throws Exception {
		// 参考mockMvc 强大功能
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/demo/submitDemo").accept(MediaType.APPLICATION_JSON)
				.param("name", "czp").param("type", "10"));
		ra.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void query() throws Exception {
		// 参考mockMvc 强大功能
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.post("/demo/list").accept(MediaType.APPLICATION_JSON)
				.param("page", "1").param("rows", "10"));
		ra.andDo(MockMvcResultHandlers.print());
	}
}
