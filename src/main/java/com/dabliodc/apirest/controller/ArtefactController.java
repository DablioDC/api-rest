package com.dabliodc.apirest.controller;

import com.dabliodc.apirest.model.Artefact;
import com.dabliodc.apirest.repository.ArtefactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/artefacts")
public class ArtefactController {

    @Autowired
    private ArtefactRepository artefactRepository;

    @GetMapping
    public List<Artefact> findAll(@RequestParam(required = false) String name){
        if (name == null) {
            return this.artefactRepository.findAll();
        } else {
            return this.artefactRepository.findByName(name);
        }
    }

    @GetMapping("/{id}")
    public Optional<Artefact> findById(@PathVariable String id){
        return this.artefactRepository.findById(id);
    }

    @PostMapping()
    public ResponseEntity<Artefact> save(@RequestBody Artefact artefact){
        try {
            Artefact _artefact = artefactRepository.save(new Artefact(artefact.getId(), artefact.getDate(), artefact.getName(), artefact.getState(), artefact.getBravery(), artefact.getLow()));
            return new ResponseEntity<>(_artefact, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artefact> update(@PathVariable("id") String id, @RequestBody Artefact artefact) {
        Optional<Artefact> artefactData = artefactRepository.findById(id);

        if (artefactData.isPresent()) {
            Artefact _artefact = artefactData.get();
            _artefact.setDate(artefact.getDate());
            _artefact.setName(artefact.getName());
            _artefact.setState(artefact.getState());
            _artefact.setBravery(artefact.getBravery());
            _artefact.setLow(artefact.getLow());
            return new ResponseEntity<>(artefactRepository.save(_artefact), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Artefact> delete(@PathVariable("id") String id) {
        try {
            artefactRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
