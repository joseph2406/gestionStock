package tn.gestionstock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import tn.gestionstock.Dto.ClientDto;
import tn.gestionstock.service.ClientService;
@RestController
public class ClientController implements ClientApi{
	private final ClientService cltSer;
	
	public ClientController(ClientService cltSer) {
		super();
		this.cltSer = cltSer;
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
		
		return  cltSer.save(clientDto);
	}

	@Override
	public ClientDto findById(Integer id) {
		return  cltSer.findById(id);
	}

	@Override
	public List<ClientDto> findAll() {
		
		return  cltSer.findAll();
	}

	@Override
	public void delete(Integer id) {
		 cltSer.delete(id);
		
	}

}
