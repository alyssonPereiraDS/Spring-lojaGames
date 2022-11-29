package com.generation.lojagames.controller;


import com.generation.lojagames.model.Categoria;
import com.generation.lojagames.model.Produto;
import com.generation.lojagames.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        return ResponseEntity.ok(categoriaRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity <Categoria> getById(@PathVariable Long id){
        return categoriaRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
