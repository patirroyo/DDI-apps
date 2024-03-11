package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.http.HttpStatus;

@SpringBootTest 
@AutoConfigureMockMvc
class DemoApplicationTest {

	@Autowired
	MockMvc mockmvc;
	
	@Test
	void testGetAJob() {
		MockHttpServletRequestBuilder requestBuilder = get("/age").queryParam("fechaNacimiento", "1988-05-04");
		try {
			MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn(); 
			ModelAndView modelAndView = mvcResult.getModelAndView();
			assertEquals("getAJobNow", modelAndView.getViewName());
		
		} catch (Exception e) {
			e.printStackTrace();
			fail("No deberia producirse una excepcion");
		}
	}
	
	@Test
	void testRetired() {
        MockHttpServletRequestBuilder requestBuilder = get("/age").queryParam("fechaNacimiento", "1950-05-04");
        try {
            MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn(); 
            ModelAndView modelAndView = mvcResult.getModelAndView();
            assertEquals("retired", modelAndView.getViewName());
        
        } catch (Exception e) {
            e.printStackTrace();
            fail("No deberia producirse una excepcion");
        }
	}
    @Test
	void testWrongDateFormat() {
		MockHttpServletRequestBuilder requestBuilder = get("/age").queryParam("fechaNacimiento", "1950/05/04");
		try {
			MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isBadRequest()).andReturn();
			ModelAndView modelAndView = mvcResult.getModelAndView();
			assertEquals(HttpStatus.BAD_REQUEST, modelAndView.getStatus());
			
			

		} catch (Exception e) {
			e.printStackTrace();
			//fail("No deberia producirse una excepcion");
		}
    }
    
    
    @Test
	void testNavigateToDivision() {
		MockHttpServletRequestBuilder requestBuilder = get("/navigate").queryParam("to", "divisionChecker");
		try {
			MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
			ModelAndView modelAndView = mvcResult.getModelAndView();
			assertEquals("divisionChecker", modelAndView.getViewName());
		} catch (Exception e) {
			e.printStackTrace();
			fail("No deberia producirse una excepcion");
		}
		
	}

    @Test
     void testNavigateToAge() {
		MockHttpServletRequestBuilder requestBuilder = get("/navigate").queryParam("to", "ageChecker");
		try {
			MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
			ModelAndView modelAndView = mvcResult.getModelAndView();
			assertEquals("ageChecker", modelAndView.getViewName());
		} catch (Exception e) {
			e.printStackTrace();
			fail("No deberia producirse una excepcion");
		}
    }
}
