/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.workorders.web;

import com.pj.workorders.domain.tareas;
import com.pj.workorders.domain.tecnicos;
import com.pj.workorders.domain.tickets;
import com.pj.workorders.dto.ticketsDTO;
import com.pj.workorders.enums.GenStatus;
import com.pj.workorders.repository.impl.ticketsRepoImpl;
import com.pj.workorders.repository.tareasRepository;
import com.pj.workorders.repository.tecnicosRepository;
import com.pj.workorders.repository.ticketsRepository;
import java.text.ParseException;
import java.util.List;
import java.util.stream.StreamSupport;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP1
 */

@RestController
@RequestMapping("/api/tickets")
public class ticketsController {

    @Autowired
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private final ticketsRepository ticketsRepository;
    
    @Autowired
    private tareasRepository tareasRepo;
    
    @Autowired
    private tecnicosRepository tecnicosRepo;
    
    
    public ticketsController(ticketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }       
    
    
    // guarda una tickets
    @PostMapping("/guardar")
    public tickets createTickets(@RequestBody ticketsDTO tickets) throws ParseException  {
        Long idTecnico = tickets.tecnicos_id;
        Long idTareas = tickets.tareas_id;
        tickets ticketsEntidad = modelMapper.map(tickets, tickets.class);
        
        tecnicos tecnicos = tecnicosRepo.findById(idTecnico).get();
        
        tareas tareas = tareasRepo.findById(idTareas).get();
        
        ticketsEntidad.setTareas(tareas);
        ticketsEntidad.setTecnicos(tecnicos);
        try {
            ticketsRepository.saveAndFlush(ticketsEntidad);
           // ticketsRepository.save(ticketsEntidad);
        } catch (RuntimeException ex) {
            throw ex;
        }
        return ticketsEntidad;
    }    
    
    //@GetMapping("/tickets-por-tecnico")
    //public List<tickets> getListar(@RequestParam(required = true) Long idtecnico) {
    //    tecnicos tecnicos = tecnicosRepo.findById(idtecnico).get();
    //    return ticketsRepository.getticketsBytecnicos(tecnicos);
    //}    
    
    @PutMapping("/cambiar-status/{idticket}/{status}")
    public tickets updateTickets(@RequestParam Long idticket, @RequestParam GenStatus estatus) {
        tickets t = ticketsRepository.findById(idticket).get();
        t.setStatus(estatus);
        return ticketsRepository.save(t);
    }
    
    @GetMapping(path = "/list")
    public List<tickets> finAll() {
        return ticketsRepository.findAll();
    }    
    
        
    @GetMapping(path = "/listar")
    // listado de todos los tickets
    public ticketsDTO[] getTickets() {
        try {
            Iterable<tickets> listado = ticketsRepository.findAll();

            ticketsDTO[] dtos = StreamSupport.stream(listado.spliterator(), false)
                    .map(e -> convertir(e))
                    .toArray(s -> new ticketsDTO[s]);

            return dtos;
        } catch (RuntimeException ex) {
            throw new RuntimeException("No se puede mostrar el listado de tickets, revise la documentacion");
                //throw ex;
        }
     }
    
    private ticketsDTO convertir(tickets t) {
        ticketsDTO post = modelMapper.map(t, ticketsDTO.class);
        return post;
    }
    
}
