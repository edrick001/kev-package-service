package id.co.bca.spring.kevpackageservice.controller;

import id.co.bca.spring.kevpackageservice.model.PackageDto;
import id.co.bca.spring.kevpackageservice.model.TblPackage;
import id.co.bca.spring.kevpackageservice.service.PackageService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/add-package")
    public @ResponseBody String addPackage(@RequestBody PackageDto input) throws Exception {
        String output = "";

        try{
            output = service.addPackageProcess(input);
        } catch (Exception ex) {
            output = ex.toString();
        }

        return output;
    }

    @PutMapping("/update-package")
    public @ResponseBody String updatePackage(@RequestBody PackageDto input) throws Exception {
        String output = "";

        try{
            output = service.updatePackageProcess(input);
        } catch (Exception ex) {
            output = ex.toString();
        }

        return output;
    }

    @PutMapping("/delete-package/{package-id}")
    public @ResponseBody String deletePackage(@PathVariable("package-id") int packageId) throws Exception {
        String output = "";

        try{
            output = service.deletePackageProcess(packageId);
        } catch (Exception ex) {
            output = ex.toString();
        }

        return output;
    }
}
