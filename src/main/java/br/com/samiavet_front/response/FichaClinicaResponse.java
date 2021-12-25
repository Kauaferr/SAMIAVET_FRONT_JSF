package br.com.samiavet_front.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.samiavet_front.dto.FichaClinicaDto;


@JsonIgnoreProperties(ignoreUnknown = true)
public class FichaClinicaResponse {
	 private HttpStatus status;
	 private List<FichaClinicaDto> ficha_clinica;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<FichaClinicaDto> getFicha_clinica() {
		return ficha_clinica;
	}
	public void setFicha_clinica(List<FichaClinicaDto> ficha_clinica) {
		this.ficha_clinica = ficha_clinica;
	}
	    
	public FichaClinicaResponse() {
		
	}
}
