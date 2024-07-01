package org.hign.platform.u202210584.assessment.application.internal.services.commandServices;

import org.hign.platform.u202210584.assessment.application.internal.acl.ExternalMentalStateExamService;
import org.hign.platform.u202210584.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202210584.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202210584.assessment.domain.services.IMentalStateExamCommandService;
import org.hign.platform.u202210584.assessment.infrastructure.persistence.jpa.IMentalStateExamRepository;
import org.hign.platform.u202210584.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202210584.personnel.infrastructure.persistence.jpa.IExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentalStateExamCommandServiceImpl  implements IMentalStateExamCommandService {
    private final IMentalStateExamRepository mentalStateExamRepository;
    private final ExternalMentalStateExamService externalMentalStateExamService;

    public MentalStateExamCommandServiceImpl(IMentalStateExamRepository mentalStateExamRepository , ExternalMentalStateExamService externalMentalStateExamService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalMentalStateExamService = externalMentalStateExamService;
    }

    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {


        MentalStateExam mentalStateExam = new MentalStateExam(command);

        mentalStateExam.setExaminerNationalProviderIdentifier(command.examinerNationalProviderIdentifier());
        mentalStateExamRepository.save(mentalStateExam);
        return Optional.of(mentalStateExam);

    }


}
