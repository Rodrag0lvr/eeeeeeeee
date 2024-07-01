package org.hign.platform.u202210584.personnel.infrastructure.persistence.jpa;

import org.hign.platform.u202210584.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202210584.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExaminerRepository  extends JpaRepository<Examiner, Long>{
    List<Examiner> findByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}
