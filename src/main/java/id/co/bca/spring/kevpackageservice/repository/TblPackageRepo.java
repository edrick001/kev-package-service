package id.co.bca.spring.kevpackageservice.repository;

import id.co.bca.spring.kevpackageservice.model.TblPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblPackageRepo extends JpaRepository<TblPackage, Integer> {

}
