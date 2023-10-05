package kr.ch07.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("beforeAll");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEach");
	}
	
	@AfterAll
	public static void AfterAll() {
		System.out.println("AfterAll");
	}
	
	@AfterEach
	public void AfterEach() {
		System.out.println("AfterEach");
	}
	
	@Test
	public void index() throws Exception  {
		mvc
		.perform(get("/index"))
		.andExpect(status().isOk())
		.andExpect(view().name("/index"))
		.andDo(print());
	}
	
	@Test
	public void include() {
		System.out.println("include");
	}
	
	@Test
	public void layout() {
		System.out.println("layout");
	}
	
}
