package com.cooperativismo.crm.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativismo.crm.model.MessageApi;
import com.cooperativismo.crm.model.Pauta;
import com.cooperativismo.crm.model.Sessao;
import com.cooperativismo.crm.model.Voto;
import com.cooperativismo.crm.service.PautaService;
import com.cooperativismo.crm.service.SessaoService;
import com.cooperativismo.crm.service.VotoService;

@RestController
@RequestMapping(value = "/votar")
public class VotarController {
	
	@Autowired(required = false)
   SessaoService sessaoService;
	@Autowired(required = false)
   VotoService votoService;
   		
   
   		@PostMapping	
		public ResponseEntity<?> votar(@RequestParam long id,@RequestParam String votar,@RequestParam String identificador) throws Exception {
   			MessageApi messageApi = new MessageApi();
   			Voto verificacao = new Voto();
			try {
				Optional<Sessao> sessao = sessaoService.findById(id);
				verificacao = votoService.findByIdentificadorAndSessao_id(identificador,id);
				if(verificacao != null) {
					messageApi.setMessage("Você Já votou");
				}else {
					sessao.get().getDataCadastro().add(Calendar.MINUTE, sessao.get().getTempoExpira());
					if(sessao.get().getDataCadastro().after(Calendar.getInstance())) {
						Voto voto = new Voto();
						voto.setDataCadastro(Calendar.getInstance());			
						voto.setIdentificador(identificador);
						voto.setSessao(sessao.get());
						voto.setDescricao(votar);	
						return new ResponseEntity<>(votoService.cadastrar(voto),HttpStatus.OK);
					}else {
						messageApi.setMessage("Esssa Sessão expirou, não é possivel mais votar");
					}
					
				}
				
			} catch (Exception e) {
				messageApi.setMessage(e.getMessage());
			}    			
			return new ResponseEntity<>(messageApi,HttpStatus.BAD_GATEWAY);
		}
   		
   		@GetMapping("/listar")
	    public List<Voto> listar() throws Exception {
	        return votoService.findAll();
	    }
   		
   		@GetMapping(value = "/buscar/{id}")
	    public ResponseEntity<?> byId(@PathVariable("id") long id) throws Exception {
   			MessageApi messageApi = new MessageApi();
			try {
			Optional<Voto> voto = votoService.findById(id);
			if (voto.isPresent())
				return new ResponseEntity<>(voto.get(),HttpStatus.OK);				
			}catch (Exception e) {
				messageApi.setMessage(e.getMessage());
			}
			return new ResponseEntity<>(messageApi,HttpStatus.BAD_GATEWAY);					
	       
	    }

}
