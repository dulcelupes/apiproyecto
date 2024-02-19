package com.pj.workorders.web;

import com.pj.workorders.domain.tecnicos;
import com.pj.workorders.dto.tecnicosDTO;
import com.pj.workorders.repository.tecnicosRepository;
import java.text.ParseException;
import java.util.List;
import java.util.stream.StreamSupport;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tecnicos")
public class tecnicosController {
    
    @Autowired
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private final tecnicosRepository tecnicosRepository;

    
    public tecnicosController(tecnicosRepository tecnicosRepository) {
        this.tecnicosRepository = tecnicosRepository;
    }

    @PostMapping("/guardar")
    public tecnicos tecnicos(@RequestBody tecnicosDTO tecnicos) throws ParseException  {
        tecnicos tecnicosEntidad = convertToEntity(tecnicos);
        try {
            tecnicosRepository.saveAndFlush(tecnicosEntidad);
        } catch (RuntimeException ex) {
            throw new RuntimeException("No se puede guardar, revise que no exista un tecnico con ese nombre de usuario");
        }
        return tecnicosEntidad;
    }

    @GetMapping(path = "/list")
    public List<tecnicos> finAll() {
        return tecnicosRepository.findAll();
    }
    
    private tecnicos convertToEntity(tecnicosDTO t) throws ParseException {
        tecnicos post = modelMapper.map(t, tecnicos.class);
        return post;
    }

    // crea un tecnico fijo para tener informacion
   @PostMapping(path = "/create")
    public tecnicosDTO createtecnicos() {
        tecnicos tecnicos = new tecnicos();
        tecnicos.setUsuario("dulce");
        tecnicos.setNombre("Dulce Guadalupe Romero");
        tecnicos.setPuesto("Programador");
        tecnicosRepository.saveAndFlush(tecnicos);
        return modelMapper.map(tecnicos, tecnicosDTO.class);
     }   
    
    @GetMapping(path = "/listar")
    // listado de todos los tecnicos no regrea el id
    public tecnicosDTO[] getTecnicos() {
        try {
            Iterable<tecnicos> listado = tecnicosRepository.findAll();

            tecnicosDTO[] dtos = StreamSupport.stream(listado.spliterator(), false)
                    .map(e -> convertir(e))
                    .toArray(s -> new tecnicosDTO[s]);

            return dtos;
        } catch (RuntimeException ex) {
            throw new RuntimeException("No se puede mostrar el listado de tecnicos, revise la documentacion");
                //throw ex;
        }
     }

    private tecnicosDTO convertir(tecnicos t) {
        tecnicosDTO post = modelMapper.map(t, tecnicosDTO.class);
        return post;
    }
}
