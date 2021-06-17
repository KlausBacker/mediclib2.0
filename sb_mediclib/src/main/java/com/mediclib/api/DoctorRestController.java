package com.mediclib.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.model.Doctor;
import com.mediclib.projection.Views;
import com.mediclib.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/doctor")
@CrossOrigin("*")
public class DoctorRestController {

    @Autowired
    private DoctorService docServ;

    @GetMapping
    @JsonView(Views.DoctorMedSpeciality.class)
    public List<Doctor> findAll() {

        return docServ.findAll();
    }
    @GetMapping("/byspe")
    @JsonView(Views.DoctorMedSpeciality.class)
    public List<Doctor> findAllBySpe(int id) {

        return docServ.findAllBySpe(id);
    }

    @GetMapping("/{id}")
    @JsonView(Views.DoctorMedSpeciality.class)
    public Doctor findById(@PathVariable int id) {

        return this.docServ.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(Views.DoctorMedSpeciality.class)
    public boolean add(@Valid @RequestBody Doctor doctor, BindingResult result) {
    if(result.hasErrors()) {
        return false;
    }
        this.docServ.add(doctor);
        return true;
    }

    @PutMapping("/{id}")
    @JsonView(Views.DoctorComplete.class)
    public boolean update(@PathVariable int id, @Valid @RequestBody Doctor doctor,
                          BindingResult result) {
        if (result.hasErrors()) {
            return false;
        }
        doctor.setId(id);
        docServ.update(doctor);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id) {
        this.docServ.deleteById(id);
        return true;
    }
}
