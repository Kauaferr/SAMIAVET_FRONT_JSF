package br.com.samiavet_front.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.samiavet_front.dto.FichaClinicaDto;

@Service
public class FichaClient {

	
	
	public Boolean cadastrar(FichaClinicaDto ficha, String email) {
		
		HttpEntity<FichaClinicaDto> ficha_flinicaDTO = new HttpEntity<>(ficha);
        RestTemplate rest = new RestTemplate();
        
        ResponseEntity<Boolean> response = rest.postForEntity("http://localhost:8000/samiavet_back/fichas/salvar/" + email, ficha_flinicaDTO, Boolean.class);
		return response.getBody();
	}
}
