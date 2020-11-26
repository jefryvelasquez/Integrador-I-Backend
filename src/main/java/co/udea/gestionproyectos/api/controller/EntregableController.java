package co.udea.gestionproyectos.api.controller;

import co.udea.gestionproyectos.api.model.EntregablesObjetivo;
import co.udea.gestionproyectos.api.model.ObjetivoEspecifico;
import co.udea.gestionproyectos.api.model.Proyecto;
import co.udea.gestionproyectos.api.service.EntregableService;
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
@RequestMapping("/entregables")
public class EntregableController {

    private final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    private EntregableService entregableService;

    public EntregableController(EntregableService entregableService) {
        this.entregableService = entregableService;
    }

    @PostMapping("crear")
    @ApiOperation(value = "Crear un nuevo entregable", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El entregable fue creado", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<EntregablesObjetivo> addEntregable(@RequestBody EntregablesObjetivo entregable){
        log.info("REST request crear entregable");
        ObjetivoEspecifico pro = new ObjetivoEspecifico();
        pro.setId(entregable.getId());
        entregable.setIdObjetivoEspecifico(pro);
        return ResponseEntity.ok(entregableService.addEntregable(entregable));
    }

    @GetMapping()
    @ApiOperation(value = "Buscar todos los entregables", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los entregables fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<EntregablesObjetivo>> getEntregables() {
        log.info("REST request buscar todos los entregables");
        return ResponseEntity.ok(entregableService.getEntregables());
    }

    @GetMapping("{id}")
    public ResponseEntity<EntregablesObjetivo> getEntregable(@PathVariable Integer id) {
        log.info("REST request buscar entregable");
        return ResponseEntity.ok(entregableService.getEntregable(id));
		
    }

    @PutMapping("{update}")
    public void updateEntregable(@RequestBody EntregablesObjetivo entregable) {
        log.info("rest Request Actualizar Entregables");
        entregableService.updateEntregable(entregable);
		
    }

    @DeleteMapping("/{id}")
    public void deleteEntregable(@PathVariable("id") Integer id) {//pathvarible me recibe las variables del browser
        entregableService.deleteEntregable(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<EntregablesObjetivo>> getEntregableObjetivo(@RequestParam(value = "idproyecto") Integer idObjetivo) {
        log.info("REST request buscar todos los entregables por objetivo");
        return ResponseEntity.ok(entregableService.getEntregableObjetivo(idObjetivo));
		
    }
}
