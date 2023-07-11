package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/")
    @RequestMapping(value = "/doctor/{id}")
    @ResponseBody
    public Doctor doctor(@PathVariable("id") int id) {
        if (id > 0 && id < 13) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Valide id");
        }
        if (id == 13) {
            return new Doctor(13, "Jodie Whittaker");
        }
        if (!(id > 0 && id <= 13)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + id);
        }
        return null;
    }
}
