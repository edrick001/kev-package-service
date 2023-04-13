package id.co.bca.spring.kevpackageservice.service;

import id.co.bca.spring.kevpackageservice.model.PackageDto;
import id.co.bca.spring.kevpackageservice.model.TblPackage;
import id.co.bca.spring.kevpackageservice.repository.TblPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public String addPackageProcess(PackageDto data) throws Exception {
        String output = "";

        try{
            TblPackage dataToBeUpdate = new TblPackage();

            if (data.getId()!=0) {
                Optional<TblPackage> existingData = tblPackageRepo.findById(data.getId());

                if (existingData.isPresent()) throw new Exception("DATA ALREADY EXIST");
            }

            dataToBeUpdate.setId(data.getId());
            dataToBeUpdate.setName(data.getName());
            dataToBeUpdate.setDescription(data.getDescription());
            dataToBeUpdate.setAmount(Double.parseDouble(data.getAmount()));

            tblPackageRepo.save(dataToBeUpdate);

            output = "Success Add Data";
        } catch (Exception e){
            output = e.toString();
            throw new Exception(e);
        }

        return output;
    }

    @Transactional
    public String updatePackageProcess(PackageDto data) throws Exception {
        String output = "";

        try{
            TblPackage dataToBeUpdate = new TblPackage();

            Optional<TblPackage> existingData = tblPackageRepo.findById(data.getId());

            if (existingData.isEmpty()) throw new Exception("DATA NOT FOUND");

            dataToBeUpdate.setId(data.getId());
            dataToBeUpdate.setName(data.getName());
            dataToBeUpdate.setDescription(data.getDescription());
            dataToBeUpdate.setAmount(Double.parseDouble(data.getAmount()));

            tblPackageRepo.save(dataToBeUpdate);

            output = "Success Update Data";
        } catch (Exception e){
            output = e.toString();
            throw new Exception(e);
        }

        return output;
    }

    @Transactional
    public String deletePackageProcess(int packageId) throws Exception {
        String output = "";

        try{
            tblPackageRepo.deleteById(packageId);

            output = "Success Update Data";
        } catch (Exception e){
            output = e.toString();
        }

        return output;
    }
}
