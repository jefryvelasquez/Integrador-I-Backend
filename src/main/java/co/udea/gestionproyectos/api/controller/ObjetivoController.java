package co.udea.gestionproyectos.api.controller;

import co.udea.gestionproyectos.api.model.Objetivo;
import co.udea.gestionproyectos.api.service.ObjetivoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    private final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    private ObjetivoService objetivoService;

    private ObjetivoController(ObjetivoService objetivoService) {
        this.objetivoService = objetivoService;
    }


    @PostMapping("crear")
    @ApiOperation(value = "Crear un nuevo proyecto", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El objetibo fue creado", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Objetivo> addObjetivo(@RequestBody Objetivo objetivo){
        log.info("REST request crear proyecto");
        return ResponseEntity.ok(objetivoService.addObjetivo(objetivo));

    }

    @GetMapping()
    @ApiOperation(value = "Buscar todos los objetivos", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los objetivos fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Objetivo>> getObjetivos() {
        log.info("REST request buscar todos los proyectos");
        return ResponseEntity.ok(objetivoService.getObjetivos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Objetivo> getObjetivo(@PathVariable Integer id) {
        log.info("REST request buscar objetivo");
        return ResponseEntity.ok(objetivoService.getObjetivo(id));
    }

    @PutMapping("{update}")
    public void updateObjetivo(@RequestBody Objetivo objetivo) {
        log.info("rest Request Actualizar Objetivos");
        objetivoService.updateObjetivo(objetivo);
    }

    @DeleteMapping("/{id}")
    public void deleteObjetivo(@PathVariable("id") Integer id) {//pathvarible me recibe las variables del browser
        objetivoService.deleteObjetivo(id);
    }
}
