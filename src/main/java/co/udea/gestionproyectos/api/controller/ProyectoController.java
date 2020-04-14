package co.udea.gestionproyectos.api.controller;

import co.udea.gestionproyectos.api.model.Proyecto;
import co.udea.gestionproyectos.api.service.ProyectoService;
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
@RequestMapping("/proyectos")
public class ProyectoController {

    private final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    private ProyectoService proyectoService;

    private ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }


    @PostMapping("crear")
    @ApiOperation(value = "Crear un nuevo proyecto", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El proyecto fue creado", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Proyecto> addProyecto(@RequestBody Proyecto proyecto){
        log.info("REST request crear proyecto");
        return ResponseEntity.ok(proyectoService.addProyecto(proyecto));

    }

    @GetMapping()
    @ApiOperation(value = "Buscar todos los proyectos", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los proyectos fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Proyecto>> getProyecetos() {
        log.info("REST request buscar todos los proyectos");
        return ResponseEntity.ok(proyectoService.getProyectos());
    }
}
