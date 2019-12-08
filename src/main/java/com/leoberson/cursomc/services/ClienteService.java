package com.leoberson.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoberson.cursomc.domain.Cliente;
import com.leoberson.cursomc.dto.ClienteDTO;
import com.leoberson.cursomc.repositories.ClienteRepository;
import com.leoberson.cursomc.services.exceptions.DataIntegrityException;
import com.leoberson.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }
    }
    
    public List<Cliente> findAll(){
        return repo.findAll();
    }
    
   public Page<Cliente> findPage(Integer page, Integer linesPerPage, 
           String orderby, String direction){
       PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
               Sort.Direction.valueOf(direction), orderby);
       return repo.findAll(pageRequest);
   }
   
   public Cliente fromDTO(ClienteDTO objDto){
       return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
   }
   
   private void updateData(Cliente newObj, Cliente obj){
       newObj.setNome(obj.getNome());
       newObj.setEmail(obj.getEmail());
   }

}
