package br.com.samiavet_front.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.samiavet_front.client.FichaClient;
import br.com.samiavet_front.dto.FichaClinicaDto;

@Service
public class FichaService {
	@Autowired
	private FichaClient ficha_clinica_cliente;
	
	public FichaService(FichaClient ficha_clinica_cliente) {
		this.ficha_clinica_cliente = ficha_clinica_cliente;
	}

	public FichaService() {
		
		
	
	}

	
	public FichaClient getFicha_clinica_cliente() {
		return ficha_clinica_cliente;
	}

	

	
	public void setFicha_clinica_cliente(FichaClient ficha_clinica_cliente) {
		this.ficha_clinica_cliente = ficha_clinica_cliente;
	}



	public Boolean cadastrar(FichaClinicaDto ficha, String email) {
		
		return this.ficha_clinica_cliente.cadastrar(ficha, email);
	}
}
