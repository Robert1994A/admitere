package ro.inf.ucv.admitere.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.inf.ucv.admitere.entity.ContractPage;

@Repository
public interface ContractPageRepository extends JpaRepository<ContractPage, Long> {

	Page<ContractPage> findAll(Pageable pageable);

}