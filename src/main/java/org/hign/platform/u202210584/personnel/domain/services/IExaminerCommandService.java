package org.hign.platform.u202210584.personnel.domain.services;

import org.hign.platform.u202210584.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202210584.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

public interface IExaminerCommandService {
    Optional<Examiner>handle(CreateExaminerCommand command);
}
