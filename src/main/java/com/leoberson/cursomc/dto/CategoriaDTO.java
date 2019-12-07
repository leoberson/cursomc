/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leoberson.cursomc.dto;

import com.leoberson.cursomc.domain.Categoria;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author leoberson
 */
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    
    private Integer id;
    @NotEmpty(message = "preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "o tamanho deve ser entre 5 e 80 "
            + "caracteres")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
