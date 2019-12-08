/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leoberson.cursomc.dto;

import com.leoberson.cursomc.domain.Cliente;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author leoberson
 */
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message = "preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "o tamanho deve ser entre 5 e 120 caracteres")
    private String nome;
    @NotEmpty(message = "preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;
    
    public ClienteDTO(){
    }
    
    public ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
          
    
}
