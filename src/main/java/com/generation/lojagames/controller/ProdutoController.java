package com.generation.lojagames.controller;

import com.generation.lojagames.model.Produto;
import com.generation.lojagames.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok(produtoRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity <Produto> getById(@PathVariable Long id){
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity <List<Produto>> getByNome(@PathVariable String nome){
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }
    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));

    }
    @PutMapping
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){
        if (produtoRepository.existsById(produto.getId())){
            return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}