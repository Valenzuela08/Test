package com.example.Insurance_and_Claims.Controller;


import com.example.Insurance_and_Claims.Service.FileClaimService;
import com.example.Insurance_and_Claims.Model.FileClaim;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/fileClaims")
@RestController
public class FileClaimController {

    private FileClaimService fileClaimService;

    public FileClaimController(FileClaimService fileClaimService) {
        this.fileClaimService = fileClaimService;
    }

    @PostMapping("/add")
    public FileClaim saveDependent(@RequestBody FileClaim fileClaim){
        return fileClaimService.saveFileClaim(fileClaim);
    }
    @GetMapping(path = "/view")
    public List<FileClaim> findAllFileClaim(){
        return fileClaimService.findAllFileClaim();
    }

    @GetMapping(path = "/{file_id}")
    public Optional<FileClaim> findFileClaimById(@PathVariable("file_id")Long file_id){
        return fileClaimService.findById(file_id);
    }

    @PutMapping(path = "update/{file_id}")
    public FileClaim updateFileClaim(@PathVariable Long file_id,@RequestBody FileClaim fileClaim){
        fileClaim.setFile_id(file_id);
        return fileClaimService.updateFileClaim(fileClaim);
    }
    @DeleteMapping(path="delete/{file_id}")
    public void deleteFileClaim(@PathVariable("file_id")Long file_id){
        fileClaimService.deleteFileClaim(file_id);
    }


}
