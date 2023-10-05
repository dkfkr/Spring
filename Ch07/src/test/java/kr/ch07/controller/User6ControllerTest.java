package kr.ch07.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import kr.ch07.service.User6Service;

@WebMvcTest(controllers = User6Controller.class)
public class User6ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private User6Service service;
    

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/user6/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("/user6/index"))
                .andDo(print());
    }
    
    @Test
    public void register() throws Exception {
    	mockMvc.perform(get("/user6/register"))
    	.andExpect(status().isOk())
    	.andExpect(view().name("/user6/register"))
    	.andDo(print());
    }
    
    @Test
    public void RegisterUser() throws Exception {
        mockMvc.perform(post("/user6/register")
                .param("uid", "newUser")
                .param("name", "New User")
                .param("birth", "1990-01-01")
                .param("gender", "M")
                .param("age", "30")
                .param("addr", "New Address")
                .param("hp", "123-456-7890"))
                .andExpect(status().is3xxRedirection()) // 리다이렉션을 예상
                .andExpect(redirectedUrl("/user6/list"))
                .andDo(print());
    }

    
    @Test
    public void list() throws Exception {
    	mockMvc.perform(get("/user6/list"))
    	.andExpect(status().isOk())
    	.andExpect(view().name("/user6/list"))
    	.andDo(print());
    }

    @Test
    public void ModifyPage() throws Exception {
    	mockMvc.perform(get("/user6/modify"))
            .andExpect(status().isOk())
            .andExpect(view().name("/user6/modify"))
            .andDo(print());
    }

    @Test
    public void ModifyUser() throws Exception {
        mockMvc.perform(post("/user6/modify")
                .param("uid", "existingUser")
                .param("name", "Updated User")
                .param("hp", "987-654-3210")
                .param("age", "35"))
                .andExpect(status().is3xxRedirection()) // 리다이렉션을 예상
                .andExpect(redirectedUrl("/user6/list"))
                .andDo(print());
    }

    @Test
    public void DeleteUser() throws Exception {
        mockMvc.perform(get("/user6/delete")
                .param("uid", "userToDelete"))
                .andExpect(status().is3xxRedirection()) // 리다이렉션을 예상
                .andExpect(redirectedUrl("/user6/list"))
                .andDo(print());
    }
}
