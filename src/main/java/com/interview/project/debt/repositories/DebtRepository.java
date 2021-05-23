package com.interview.project.debt.repositories;

import com.interview.project.debt.domain.Debt;
import org.springframework.data.repository.CrudRepository;

public interface DebtRepository extends CrudRepository<Debt,Long> {

}
