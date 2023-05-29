package com.example.Insurance_and_Claims.Service.Implementation;


import com.example.Insurance_and_Claims.Repository.FileClaimRepository;
import com.example.Insurance_and_Claims.Service.FileClaimService;
import com.example.Insurance_and_Claims.Model.FileClaim;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileClaimImplementation implements FileClaimService {

    private FileClaimRepository fileClaimRepository;

    public FileClaimImplementation(FileClaimRepository fileClaimRepository) {
        this.fileClaimRepository = fileClaimRepository;
    }


    @Override
    public List<FileClaim> findAllFileClaim() {
        return fileClaimRepository.findAll();
    }

    @Override
    public Optional<FileClaim> findById(Long file_id) {
        return fileClaimRepository.findById(file_id);
    }

    @Override
    public FileClaim saveFileClaim(FileClaim fileClaim) {
        return fileClaimRepository.save(fileClaim);
    }

    @Override
    public FileClaim updateFileClaim(FileClaim fileClaim) {
        return fileClaimRepository.save(fileClaim);
    }

    @Override
    public void deleteFileClaim(Long file_id) {
        fileClaimRepository.deleteById(file_id);
    }
}
