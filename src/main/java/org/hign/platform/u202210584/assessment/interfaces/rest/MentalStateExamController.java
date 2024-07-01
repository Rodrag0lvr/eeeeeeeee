package org.hign.platform.u202210584.assessment.interfaces.rest;

import org.hign.platform.u202210584.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202210584.assessment.domain.services.IMentalStateExamCommandService;
import org.hign.platform.u202210584.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202210584.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.u202210584.assessment.interfaces.rest.transform.CreateMentalStateExamCommandFromResourceAssembler;
import org.hign.platform.u202210584.assessment.interfaces.rest.transform.MentalStateExamFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/mental-state-exams")
public class MentalStateExamController {
    private final IMentalStateExamCommandService mentalStateExamCommandService;

    public MentalStateExamController(IMentalStateExamCommandService mentalStateExamCommandService) {
        this.mentalStateExamCommandService = mentalStateExamCommandService;
    }

    @PostMapping
    public ResponseEntity<MentalStateExamResource> createEquipment(@RequestBody CreateMentalStateExamResource resource) {
        Optional<MentalStateExam> mentalStateExam = mentalStateExamCommandService.handle(CreateMentalStateExamCommandFromResourceAssembler.toCommandFromResource(resource));
        return mentalStateExam.map(resp ->
                        new ResponseEntity<>(MentalStateExamFromEntityAssembler
                                .toResourceFromEntity(resp), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}