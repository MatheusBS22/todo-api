package com.mbsousa.ToDoApi.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "info", description = "Informações sobre a API")
@RestController
@RequestMapping("/api")
public class InfoController {

    @Operation(summary = "Retorna as informações sobre a API")
    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> info(){
        return ResponseEntity.ok(Map.of(
                "name", "ToDo API",
                "version", "1.0",
                "description", "API REST para gerenciamento de tarefas",
                "rootEndPoint", "/api/v1",
                "documentation", "/swagger-ui/index.html"
        ));

    }

}
