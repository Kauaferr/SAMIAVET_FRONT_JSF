package br.com.samiavet_front.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.samiavet_front.dto.FichaClinicaDto;
import br.com.samiavet_front.response.FichaClinicaResponse;

@Service
public class FichaClient {

	
	
	public Boolean cadastrar(FichaClinicaDto ficha, String email) {
		
		HttpEntity<FichaClinicaDto> ficha_flinicaDTO = new HttpEntity<>(ficha);
        RestTemplate rest = new RestTemplate();
        
        ResponseEntity<Boolean> response = rest.postForEntity("http://localhost:8000/samiavet_back/fichas/salvar/" + email, ficha_flinicaDTO, Boolean.class);
		return response.getBody();
	}
	
	public List<FichaClinicaDto> listar(){
		
        RestTemplate rest = new RestTemplate();
        ResponseEntity<FichaClinicaResponse> response = rest.getForEntity("http://localhost:8000/samiavet_back/fichas/listar", FichaClinicaResponse.class);
        List<FichaClinicaDto> fichas = response.getBody().getFicha_clinica();
        return fichas;
	}
	
	public List<FichaClinicaDto> listarPorNomeAnimal(String nomeAnimal){
		
        RestTemplate rest = new RestTemplate();
        ResponseEntity<FichaClinicaResponse> response = rest.getForEntity("http://localhost:8000/samiavet_back/fichas/listar/" + nomeAnimal, FichaClinicaResponse.class);
        List<FichaClinicaDto> fichas = response.getBody().getFicha_clinica();
        return fichas;
	}
	public void deletar(Integer id) {
		 RestTemplate rest = new RestTemplate();
		 rest.delete("http://localhost:8000/samiavet_back/fichas/deletar/" + id);
	}
	
	public Boolean editar(FichaClinicaDto ficha, String email) {
		
		HttpEntity<FichaClinicaDto> ficha_flinicaDTO = new HttpEntity<>(ficha);
        RestTemplate rest = new RestTemplate();
        
        ResponseEntity<Boolean> response = rest.postForEntity("http://localhost:8000/samiavet_back/fichas/editar/" + email, ficha_flinicaDTO, Boolean.class);
		return response.getBody();
	}
}
