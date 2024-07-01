package org.hign.platform.u202210584.assessment.infrastructure.persistence.jpa;

import org.hign.platform.u202210584.assessment.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMentalStateExamRepository  extends JpaRepository<MentalStateExam, Long> {

}
