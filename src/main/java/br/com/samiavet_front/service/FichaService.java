package br.com.samiavet_front.service;

import java.util.List;

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
	
	public List<FichaClinicaDto> listar(){
		
		return this.ficha_clinica_cliente.listar();
	}
	
	public List<FichaClinicaDto> listarPorNomeAnimal(String nomeAnimal){
		
		return this.ficha_clinica_cliente.listarPorNomeAnimal(nomeAnimal);
	}
	public void excluir(Integer id) {
		this.ficha_clinica_cliente.deletar(id);
	}
	
	public Boolean editar(FichaClinicaDto ficha, String email) {
		
		return this.ficha_clinica_cliente.editar(ficha, email);
	}
}
