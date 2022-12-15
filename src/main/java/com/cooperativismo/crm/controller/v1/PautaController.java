package com.cooperativismo.crm.controller.v1;


import org.springframework.web.bind.annotation.*;

import com.cooperativismo.crm.model.MessageApi;
import com.cooperativismo.crm.model.Pauta;
import com.cooperativismo.crm.model.Voto;
import com.cooperativismo.crm.model.VotosVO;
import com.cooperativismo.crm.service.PautaService;
import com.cooperativismo.crm.service.VotoService;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
 @RequestMapping(value = "/pauta/v1")
public class PautaController {
	@Autowired(required = false)
  PautaService pautaService;
	@Autowired(required = false)
 VotoService votoService;
	
		@PostMapping(value = "/cadastrar")
		public ResponseEntity<?> cadastrarV1(@RequestParam String descricao) {
			Pauta pauta = new Pauta();
			MessageApi messageApi = new MessageApi();
			try {				 
					pauta.setDataCadastro(Calendar.getInstance());
					pauta.setDescricao(descricao);					
					pautaService.cadastrar(pauta);
					return new ResponseEntity<>(pauta,HttpStatus.OK);
			} catch (Exception e) {
				messageApi.setMessage(e.getMessage());
			}
			return new ResponseEntity<>(messageApi,HttpStatus.BAD_GATEWAY);					
		}		
		
		@GetMapping("/listar")
	    public List<Pauta> listar() throws Exception {
	        return pautaService.getAll();
	    }		
		
		
		@GetMapping(value = "/buscar/{id}")
	    public ResponseEntity<?> byId(@PathVariable("id") long id) throws Exception {
			MessageApi messageApi = new MessageApi();
			try {
			Optional<Pauta> pauta = pautaService.findById(id);
			if (pauta.isPresent())
				return new ResponseEntity<>(pauta.get(),HttpStatus.OK);				
			}catch (Exception e) {
				messageApi.setMessage(e.getMessage());
			}
			return new ResponseEntity<>(messageApi,HttpStatus.BAD_GATEWAY);					
	       
	    }		
		
		
		
		
}
