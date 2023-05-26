package com.devsuperior.CrudClient.services;

import java.util.Optional;


import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.CrudClient.DTO.ClientDTO;
import com.devsuperior.CrudClient.entities.Client;
import com.devsuperior.CrudClient.exceptions.DatabaseException;
import com.devsuperior.CrudClient.exceptions.ResourceNotFoundException;
import com.devsuperior.CrudClient.repositories.ClientRepository;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(()->  new ResourceNotFoundException("Cliente não cadastrado! "));
		return new ClientDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		forms(dto, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
 }
	
	@Transactional(readOnly = true)
	public ClientDTO update(Long id, ClientDTO dto) {
		
		try {
		Client entity = repository.getOne(id);
		forms(dto, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Cliente não cadastrado." + id);
		}
	}
	
	@Transactional(readOnly = true)
	public void delete(long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e ){
			throw new ResourceNotFoundException("id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(" Integrity violation");
		}
		
	}
	
	private void forms(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
	
	


}

