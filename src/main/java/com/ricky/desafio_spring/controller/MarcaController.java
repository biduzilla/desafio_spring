package com.ricky.desafio_spring.controller;

import com.ricky.desafio_spring.dto.MarcaDto;
import com.ricky.desafio_spring.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/marca/")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMarca(@RequestBody @Valid MarcaDto marcaDto) {
        marcaService.cadastrarMarca(marcaDto);
    }

    @GetMapping("/all_marcas")
    @ResponseStatus(HttpStatus.OK)
    public List<MarcaDto> getAllMarcas() {
        return marcaService.getAllMarca();
    }

    @GetMapping("/get_marca/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MarcaDto getMarcaById(@PathVariable String id) {
        return marcaService.getMarcaById(id);
    }

    @PutMapping("/update_marca/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateMarca(@RequestBody @Valid MarcaDto marcaDto, @PathVariable String id) {
        marcaService.updateMarca(marcaDto, id);
    }

    @DeleteMapping("/delete_marca/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteMarcaById(@PathVariable String id) {
        marcaService.deleteMarcaById(id);
    }
}
