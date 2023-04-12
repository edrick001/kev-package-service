package id.co.bca.spring.kevpackageservice.service;

import id.co.bca.spring.kevpackageservice.model.PackageDto;
import id.co.bca.spring.kevpackageservice.model.TblPackage;
import id.co.bca.spring.kevpackageservice.repository.TblPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    @Autowired
    TblPackageRepo tblPackageRepo;

    public List<TblPackage> inquiryAllPackageProcess(){
        return tblPackageRepo.findAll();
    }

    public Optional<TblPackage> inquiryPackageByIdProcess(int packageId){
        return tblPackageRepo.findById(packageId);
    }

    public String updatePackage(PackageDto data){
        TblPackage
        return "Success Update Data";
    }
}
