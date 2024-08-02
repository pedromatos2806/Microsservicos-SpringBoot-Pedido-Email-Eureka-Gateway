package com.pedidoms.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.pedidoms.dtos.ClienteDto;
import com.pedidoms.services.ClienteService;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ClienteControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteService clienteService;

	@Autowired
	private JacksonTester<ClienteDto> jsonDto;

	@Test
	@DisplayName("teste no endPoint de criarCliente deve retornar 200")
	void test1() throws Exception {

		ClienteDto dto = new ClienteDto("teste", "teste@hotmail.com");

		var response = mockMvc
				.perform(
						post("/cliente")
						.content(jsonDto.write(dto).getJson())
						.contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		Assertions.assertEquals(200, response.getStatus());

	}

	@Test
	@DisplayName("teste no endPoint de atualizarCliente deve retornar 200")
	void test2() throws Exception {

		ClienteDto dto = new ClienteDto("teste", "teste@hotmail.com");
		Long id = 1L;
		var response = mockMvc.perform(
				put("/cliente/{id}", id)
					.content(jsonDto.write(dto).getJson())
					.contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		Assertions.assertEquals(200, response.getStatus());

	}

}
