package org.hign.platform.u202210584.personnel.interfaces.rest;

import org.hign.platform.u202210584.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202210584.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202210584.personnel.domain.services.IExaminerCommandService;
import org.hign.platform.u202210584.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.u202210584.personnel.interfaces.rest.resources.ExaminerResource;
import org.hign.platform.u202210584.personnel.interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.u202210584.personnel.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/examiners", produces =  MediaType.APPLICATION_JSON_VALUE)
public class ExaminerController {
    private final IExaminerCommandService examinerCommandService;


    public ExaminerController(IExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    @PostMapping
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource) {
        CreateExaminerCommand command = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Examiner> examiner = examinerCommandService.handle(command);
        return examiner.map(resp ->
                        new ResponseEntity<>(ExaminerResourceFromEntityAssembler.toResourceFromEntity(resp), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


}
