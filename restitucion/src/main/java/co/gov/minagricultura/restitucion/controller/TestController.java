package co.gov.minagricultura.restitucion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    private ResponseEntity<String> test(){
        return ResponseEntity.ok("Restitución App está funcionando");
    }
}
