package com.zoden.repository;

import com.zoden.model.Gallerist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleristRepository extends JpaRepository<Gallerist, Long> {
}
