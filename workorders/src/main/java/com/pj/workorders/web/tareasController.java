/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.web;


import com.pj.workorders.domain.tareas;
import com.pj.workorders.dto.tareasDTO;
import com.pj.workorders.enums.GenStatus;
import java.util.stream.StreamSupport;
import com.pj.workorders.repository.tareasRepository;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP1
 */

@RestController
@RequestMapping("/api/tareas")
public class tareasController {
    @Autowired
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private final tareasRepository tareasRepository;
    
    public tareasController(tareasRepository tareasRepository) {
        this.tareasRepository = tareasRepository;
    }    
    
    // guarda una tarea
    @PostMapping("/guardar")
    public tareas createTareas(@RequestBody tareasDTO tareas) throws ParseException  {
        tareas tareasEntidad = modelMapper.map(tareas, tareas.class);
        try {
            tareasRepository.saveAndFlush(tareasEntidad);
        } catch (RuntimeException ex) {
            throw ex;
        }
        return tareasEntidad;
    }    
    
    @GetMapping(path = "/list")
    public List<tareas> finAll() {
        return tareasRepository.findAll();
    }    
    
    
    @GetMapping(path = "/listar")
    // listado de todos los tareas
    public tareasDTO[] getTareas() {
        try {
            Iterable<tareas> listado = tareasRepository.findAll();

            tareasDTO[] dtos = StreamSupport.stream(listado.spliterator(), false)
                    .map(e -> convertir(e))
                    .toArray(s -> new tareasDTO[s]);

            return dtos;
        } catch (RuntimeException ex) {
            throw new RuntimeException("No se puede mostrar el listado de tareas, revise la documentacion");
                //throw ex;
        }
     }
    
    private tareasDTO convertir(tareas t) {
        tareasDTO post = modelMapper.map(t, tareasDTO.class);
        return post;
    }
}
