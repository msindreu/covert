package org.covert.repositories;

import org.covert.models.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionsRepository extends JpaRepository<Solutions, Long> {
}
