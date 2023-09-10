package com.ricky.desafio_spring.controller;

import com.ricky.desafio_spring.dto.ModeloDto;
import com.ricky.desafio_spring.service.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/modelo/")
@RequiredArgsConstructor
public class ModeloController {

    private final ModeloService modeloService;

    @PostMapping("/cadastrar/{idMarca}")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarModelo(@RequestBody @Valid ModeloDto modelo, @PathVariable String idMarca) {
        modeloService.cadastrarModelo(modelo, idMarca);
    }

    @GetMapping("/get_all_modelos")
    @ResponseStatus(HttpStatus.OK)
    public List<ModeloDto> getAllModelos() {
        return modeloService.getAllModelos();
    }

    @GetMapping("/get_all_modelos_marca/{idMarca}")
    @ResponseStatus(HttpStatus.OK)
    public List<ModeloDto> getAllModelosByMarca(@PathVariable String idMarca) {
        return modeloService.getAllModelosByMarca(idMarca);
    }

    @GetMapping("/get_modelo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ModeloDto getModeloById(@PathVariable String id){
        return modeloService.getModeloById(id);
    }

    @PutMapping("/update_modelo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  void updateModelo(@RequestBody @Valid ModeloDto modelo,@PathVariable String id){
        modeloService.updateModelo(modelo, id);
    }

    @DeleteMapping("/delete_modelo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModeloById(@PathVariable String id){
        modeloService.deleteModeloById(id);
    }
}
