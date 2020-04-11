package co.udea.gestionproyectos.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    private final Logger log = LoggerFactory.getLogger(ProyectoController.class);
}
