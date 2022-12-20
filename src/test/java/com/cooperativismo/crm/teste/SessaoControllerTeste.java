package com.cooperativismo.crm.teste;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import com.cooperativismo.crm.controller.v1.SessaoController;
import com.cooperativismo.crm.service.PautaService;
import com.cooperativismo.crm.service.SessaoService;
import com.cooperativismo.crm.repository.PautaRepository;
import com.cooperativismo.crm.repository.SessaoRepository;
import io.restassured.http.ContentType;

@WebMvcTest
public class SessaoControllerTeste {
	
	@Autowired(required = false)
	 private SessaoController sessao;
	
	 @InjectMocks
		private SessaoController sessaoController;
		 
		 @Mock
		 private  SessaoRepository SessaoRepository ;
		
		 @Mock
		 private  SessaoService sessaoService;
		 
		 @Mock
		 private PautaService pautaService;
		 
		 @Mock
		 private PautaRepository pautaRepository;
		 
		 @BeforeEach
			public void setup() {
				standaloneSetup(this.sessaoController);	
					
			}
		 
		 
	 
		 @Test
			public void sucessoCreateSessaoComTempo() {		
				given().param("id",1).and().param("tempo", 5)					
				   .accept(ContentType.JSON)
				   .post("/sessao/v1/cadastrar")
				   .then()
				   .statusCode(HttpStatus.OK.value());		 
			}
		 
		 @Test
			public void sucessoCreateSessaoSemTempo() {		
				given().param("id","1")
				   .accept(ContentType.JSON)
				   .post("/sessao/v1/cadastrar")
				   .then()
				   .statusCode(HttpStatus.OK.value());			 
			}
	 @Test
		public void sucessoBuscaSessoes() throws Exception {
			assertTrue(sessao.listar().hasBody());		
		}
	 
	 @Test
		public void sucessoBuscarSessaoById() throws Exception {
			assertTrue(sessao.byId(1).hasBody());		
		}
	 
	 @Test
		public void falhaBuscaSessaoById() throws Exception {
			assertTrue(sessao.byId(-1).hasBody());		
		}

}
