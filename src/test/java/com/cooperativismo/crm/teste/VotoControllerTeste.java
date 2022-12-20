package com.cooperativismo.crm.teste;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.cooperativismo.crm.controller.v1.VotarController;
import com.cooperativismo.crm.repository.SessaoRepository;
import com.cooperativismo.crm.repository.VotoRepository;
import com.cooperativismo.crm.service.SessaoService;
import com.cooperativismo.crm.service.VotoService;



@WebMvcTest
public class VotoControllerTeste {

	
	 @Autowired(required = false)
	 private VotarController votar;
	
	 @InjectMocks
		private VotarController votarController;
	
	   		
		 @Mock
		 private  SessaoService sessaoService;
		 
		 @Mock
		 private SessaoRepository sessaoRepository;
		 
		 @Mock
		 private VotoRepository votoRepository;
		
		 @Mock
		 private  VotoService votoService;
		 
		 
		 
		 @BeforeEach
			public void setup() {
				standaloneSetup(this.votarController);		
			}	 
		
	 @Test
		public void BuscaVotos() throws Exception {
			assertTrue(votar.listar().hasBody());		
		}
	 
	 @Test
		public void BuscaVotoById() throws Exception {
			assertTrue(votar.byId(1).hasBody());		
		}
	 
	 @Test
		public void FalhaBuscaVotoById() throws Exception {
			assertTrue(votar.byId(-1).hasBody());		
		}
}
