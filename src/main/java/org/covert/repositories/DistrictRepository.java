package org.covert.repositories;
import org.covert.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

}
