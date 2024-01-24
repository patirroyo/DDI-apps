package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; //para no poner todo el rato la palabra MockMvcResultMatchers
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest2 {

//	@Autowired //cojo el propio de la aplicación porque uso un test completo de SpringBoot
//	StudentController controller;
	
	@Autowired //viene con Spring por lo que lo voy a poder utilizar desde el principio
	MockMvc mockmvc;//me permite simular una petición entera del modelo mvc, sin tener que hacer parte por parte como con selenium
	
	@Test
	void testInsertStudentForm() {
		//MockHttpServletRequestBuilder requestbuilder = MockMvcRequestBuilders.get("/insertStudent");//este objeto simula que le doy a un boton y simulo la petición hattp
		MockHttpServletRequestBuilder requestbuilder = get("/insertStudent")
															//.queryParam("id", "1")
															.queryParam("nombre", "Alberto")
															.queryParam("apellido", "Saz");
		try {
			//mockmvc.perform(requestbuilder).andExpect(MockMvcResultMatchers.status().isOk());
			MvcResult mvcResult = mockmvc.perform(requestbuilder).andExpect(status().isOk()).andReturn();
			
			ModelAndView modelAndView = mvcResult.getModelAndView();;
			assertEquals("fin", modelAndView.getViewName());
			assertNotNull( modelAndView.getModel().get("estudiantes"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("no debería producirse una excepción");
		}
	}
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
