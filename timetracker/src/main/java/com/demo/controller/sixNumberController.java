package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timetracker.service.sixNumberService;
import com.timetracker.dto.sixNumber;

@RestController
@RequestMapping("/api/sixNumbers")

public class sixNumberController {
    @Autowired
    private sixNumberService sixNumberService;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public sixNumber savesixNumber(@RequestBody sixNumber sixNumber) {
        return sixNumberService.create(sixNumber);
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public List<sixNumber> getAllsixNumbers() {

        return sixNumberService.read();
    }

    @PutMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public sixNumber updatesixNumber(@RequestBody sixNumber sixNumber) {

        return sixNumberService.update(sixNumber);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Map<String, String> deletesixNumber(@PathVariable String id) {

        return sixNumberService.delete(id);
    }
}
