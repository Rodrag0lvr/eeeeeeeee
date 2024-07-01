package org.hign.platform.u202210584.personnel.application.internal.commandServices;

import org.hign.platform.u202210584.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202210584.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202210584.personnel.domain.services.IExaminerCommandService;
import org.hign.platform.u202210584.personnel.infrastructure.persistence.jpa.IExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExaminerCommandServiceImpl implements IExaminerCommandService {
    private final IExaminerRepository examinerRepository;

    public ExaminerCommandServiceImpl(IExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;

    }

    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
       Examiner examiner = new Examiner(command);
       List<Examiner> existExaminerWithSameNPI = examinerRepository.findByNationalProviderIdentifier(examiner.getNationalProviderIdentifier());
        if(!existExaminerWithSameNPI.isEmpty()){
            throw new IllegalArgumentException("Examiner with the same NPI already exists");
        }

        examinerRepository.save(examiner);
        return Optional.of(examiner);

    }
}
