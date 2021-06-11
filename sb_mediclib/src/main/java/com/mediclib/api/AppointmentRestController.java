package com.mediclib.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.model.Address;
import com.mediclib.model.Appointment;
import com.mediclib.projection.Views;
import com.mediclib.service.AdressService;
import com.mediclib.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/appointment")
@CrossOrigin("*")
public class AppointmentRestController {

    @Autowired
    private AppointmentService appServ;

    @GetMapping
    @JsonView(Views.Appointment.class)
    public List<Appointment> findAll() {

        return appServ.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.Appointment.class)
    public Appointment findById(@PathVariable int id) {

        return this.appServ.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(Views.Appointment.class)
    public boolean add(@Valid @RequestBody Appointment appointment, BindingResult result) {
    if(result.hasErrors()) {
        return false;
    }
        this.appServ.add(appointment);
        return true;
    }

    @PutMapping("/{id}")
    @JsonView(Views.Appointment.class)
    public boolean update(@PathVariable int id, @Valid @RequestBody Appointment appointment,
                          BindingResult result) {
        if (result.hasErrors()) {
            return false;
        }
        appointment.setId(id);
        appServ.update(appointment);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id) {
        this.appServ.deleteById(id);
        return true;
    }
}
