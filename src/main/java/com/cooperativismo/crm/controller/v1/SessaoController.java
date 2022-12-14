package com.cooperativismo.crm.controller.v1;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cooperativismo.crm.model.MessageApi;
import com.cooperativismo.crm.model.Pauta;
import com.cooperativismo.crm.model.Sessao;
import com.cooperativismo.crm.model.Voto;
import com.cooperativismo.crm.model.VotosVO;
import com.cooperativismo.crm.service.PautaService;
import com.cooperativismo.crm.service.SessaoService;
import com.cooperativismo.crm.service.VotoService;


@RestController
@RequestMapping(value = "/sessao/v1")
public class SessaoController {
	@Autowired(required = false)
    PautaService pautaService;
	@Autowired(required = false)
	SessaoService sessaoService;	
	@Autowired(required = false)
	VotoService votoService;
	
	@PostMapping("/cadastrar")	
	public ResponseEntity<?> cadastrarV1(@RequestParam long id,@RequestParam(required = false, defaultValue = "1") int tempo) throws Exception {
		MessageApi messageApi = new MessageApi();
		try {
			 Optional<Pauta> pauta = pautaService.findById(id);	
				if(pauta.get() != null) {
					Pauta p = new Pauta();
					p.setId(pauta.get().getId());
					p.setDataCadastro(pauta.get().getDataCadastro());
					p.setDescricao(pauta.get().getDescricao());
					p.setVotos(pauta.get().getVotos());					
					Sessao sessao = new Sessao(Calendar.getInstance(),tempo,p);			
					return new ResponseEntity<>(sessaoService.cadastrar(sessao),HttpStatus.OK);
						}	
		 		} catch (Exception e) {
		 			messageApi.setMessage(e.getMessage());
		 }
		return new ResponseEntity<>(messageApi,HttpStatus.BAD_GATEWAY);			 
	}
	
	
	@GetMapping("/listar")
    public ResponseEntity<?> listar() throws Exception {       
        MessageApi messageApi = new MessageApi();
		try {
		List<Sessao> lista = sessaoService.getAll();
		if (!(lista.isEmpty()))
			return new ResponseEntity<>(lista,HttpStatus.OK);				
		}catch (Exception e) {
			messageApi.setMessage(e.getMessage());
		}
		return new ResponseEntity<>(messageApi,HttpStatus.BAD_GATEWAY);			
       
    }
	
	
	@GetMapping(value = "/buscar/{id}")
    public ResponseEntity<?> byId(@PathVariable("id") long id) throws Exception {
		MessageApi messageApi = new MessageApi();
		try {
		Optional<Sessao> sessao = sessaoService.findById(id);
		if (sessao.isPresent())
			return new ResponseEntity<>(sessao.get(),HttpStatus.OK);				
		}catch (Exception e) {
			messageApi.setMessage(e.getMessage());
		}
		return new ResponseEntity<>(messageApi,HttpStatus.BAD_GATEWAY);					
       
    }
	
	@GetMapping("/contar-votos/{id}")
    public ResponseEntity<?>  contarVotos(@PathVariable("id") long id) throws Exception {
		int contadorsim = 0;
		int contadorNao = 0;	
		MessageApi messageApi = new MessageApi();			
		Optional<Sessao> sessao = sessaoService.findById(id);
		try {
			 List<Voto> votos  = votoService.findBySessao_id(id);
				for(Voto v : votos) {
					
					if(v.getDescricao().equalsIgnoreCase("sim")) {
						contadorsim = contadorsim + 1;	
					}else {
						contadorNao = contadorNao + 1;
					}
				}
				
				VotosVO vo = new VotosVO();
				vo.setDescricao(sessao.get().getPauta().getDescricao());
				vo.setNao(contadorNao);
				vo.setSim(contadorsim);
				vo.setQuantidadeVotos(contadorNao+contadorsim);			
				return new ResponseEntity<>(vo,HttpStatus.OK);	
		} catch (Exception e) {
			messageApi.setMessage(e.getMessage());
		}
		return new ResponseEntity<>(messageApi,HttpStatus.BAD_GATEWAY);
    }
	
}
