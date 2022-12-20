package com.cooperativismo.crm.teste;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.cooperativismo.crm.controller.v1.PautaController;
import com.cooperativismo.crm.repository.PautaRepository;
import com.cooperativismo.crm.service.PautaService;
import io.restassured.http.ContentType;
import org.springframework.http.HttpStatus;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;



@WebMvcTest
public class PautaControllerTeste {	 
	
	 
	 @Autowired(required = false)
	 private PautaController pauta;
	
	 @InjectMocks
		private PautaController pautaController;
		 
		 @Mock
		 private  PautaRepository pautaRepository;
		
		 @Mock
		 private  PautaService pautaService;
		 
		 @BeforeEach
			public void setup() {
				standaloneSetup(this.pautaController);		
			}
	 
		 @Test
			public void sucessoCreatePauta() {		
				given().param("descricao","CadastroTesteJunit")
				   .accept(ContentType.JSON)
				   .post("/pauta/v1/cadastrar")
				   .then()
				   .statusCode(HttpStatus.OK.value());			 
			}
	 @Test
		public void BuscaPautas() throws Exception {
			assertTrue(pauta.listar().hasBody());		
		}
	 
	 @Test
		public void BuscaPautaById() throws Exception {
			assertTrue(pauta.byId(1).hasBody());		
		}
	 
	 @Test
		public void FalhaBuscaPautaById() throws Exception {
			assertTrue(pauta.byId(-1).hasBody());		
		}

	
}
