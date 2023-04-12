package id.co.bca.spring.kevpackageservice.controller;

import id.co.bca.spring.kevpackageservice.model.PackageDto;
import id.co.bca.spring.kevpackageservice.model.TblPackage;
import id.co.bca.spring.kevpackageservice.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PackageController {

    @Autowired
    PackageService service;

    @GetMapping("/inquiry-all-package")
    public @ResponseBody List<TblPackage> inquiryAllPackage() throws Exception {
        List<TblPackage> output = new ArrayList<>();

        try{
            output = service.inquiryAllPackageProcess();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }

        return output;
    }

    @GetMapping("/inquiry-package-by-id")
    public @ResponseBody Optional<TblPackage> inquiryPackageById(@RequestParam("packageId") int packageId) throws Exception {
        Optional<TblPackage> output = Optional.of(new TblPackage());

        try{
            output = service.inquiryPackageByIdProcess(packageId);
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }

        return output;
    }

    @GetMapping("/update-package")
    public @ResponseBody String updatePackage(@RequestBody PackageDto input) throws Exception {
        String output = "";

        try{
            output = service.updatePackage(input);
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }

        return output;
    }
}
