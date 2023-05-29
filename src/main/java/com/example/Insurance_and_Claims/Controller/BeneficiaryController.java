package com.example.Insurance_and_Claims.Controller;

import com.example.Insurance_and_Claims.Service.BeneficiaryService;
import com.example.Insurance_and_Claims.Model.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {
    @Autowired
    private final BeneficiaryService beneficiaryService;

    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @PostMapping("/add")
    public Beneficiary saveBeneficiary(@RequestBody Beneficiary beneficiary){
        return beneficiaryService.saveBeneficiary(beneficiary);
    }
    @GetMapping(path = "/view")
    public List<Beneficiary> findAllBeneficiary(){
        return beneficiaryService.findAllBeneficiary();
    }

    @GetMapping(path = "/{beneficiary_id}")
    public Optional<Beneficiary> findBeneficiaryById(@PathVariable("beneficiary_id")Long beneficiary_id){
        return beneficiaryService.findById(beneficiary_id);
    }

    @PutMapping(path = "update/{beneficiary_id}")
    public Beneficiary updateBeneficiary(@PathVariable Long beneficiary_id,@RequestBody Beneficiary beneficiary){
        beneficiary.setBeneficiary_id(beneficiary_id);
        return beneficiaryService.updateBeneficiary(beneficiary);
    }
    @DeleteMapping(path="delete/{beneficiary_id}")
    public void deleteBeneficiary(@PathVariable("beneficiary_id")Long beneficiary_id){
        beneficiaryService.deleteBeneficiary(beneficiary_id);
    }
}
