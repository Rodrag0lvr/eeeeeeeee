package org.hign.platform.u202210584.assessment.domain.services;

import org.hign.platform.u202210584.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202210584.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202210584.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

public interface IMentalStateExamCommandService {
    Optional<MentalStateExam> handle(CreateMentalStateExamCommand command);
}
