package br.com.samiavet_front.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.samiavet_front.dto.FichaClinicaDto;
import br.com.samiavet_front.service.FichaService;
import br.com.samiavet_front.util.JsfUtil;

@ManagedBean(name="MBFichaClinica")
@ViewScoped
public class FichaClinicaBean {
	
	private FichaClinicaDto FichaClinica;
	private ArrayList<FichaClinicaDto> itens;
	
    @ManagedProperty(value = "#{fichaService}")
	private FichaService fichaService;
	
    


	public FichaClinicaBean() {
		this.FichaClinica = new FichaClinicaDto(); 
	}
    
	public FichaClinicaDto getFichaClinica() {
		return FichaClinica;
	}



	public void setFichaClinica(FichaClinicaDto fichaClinica) {
		FichaClinica = fichaClinica;
	}



	public ArrayList<FichaClinicaDto> getItens() {
		return itens;
	}



	public void setItens(ArrayList<FichaClinicaDto> itens) {
		this.itens = itens;
	}



	public FichaService getFichaService() {
		return fichaService;
	}



	public void setFichaService(FichaService fichaService) {
		this.fichaService = fichaService;
	}



	

	public void printar() {
		
		Random n1 = new Random();
		
		this.FichaClinica.setId(n1.nextInt(1000000000));
		
		LocalDate data = LocalDate.now();
		
		String converterData = String.valueOf(data);
		this.FichaClinica.setData_registro_animal(converterData);
		
		
		
		Boolean validacao = this.fichaService.cadastrar(this.FichaClinica, this.FichaClinica.getEmail());

		if(validacao == true) {
			String nomeAnimalMaiusculo = this.FichaClinica.getNome_animal().toUpperCase();
			JsfUtil.adicionarMensagemDeSucesso(nomeAnimalMaiusculo +  " FOI CADASTRADO COM SUCESSO", null);
			this.FichaClinica = new FichaClinicaDto();


		}else if( validacao == false) {
			
			JsfUtil.adicionarMensagemDeErro("ESTE E-MAIL JÁ ESTÁ CADASTRADO NO SISTEMA", null);
		}
		

		
	}
}
