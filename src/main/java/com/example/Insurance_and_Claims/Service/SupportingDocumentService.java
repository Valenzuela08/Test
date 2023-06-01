package com.example.Insurance_and_Claims.Service;

import com.example.Insurance_and_Claims.Model.SupportingDocument;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public interface SupportingDocumentService {
    SupportingDocument saveSupportingDocument(MultipartFile file) throws Exception;

    SupportingDocument getSupportingDocument(String id) throws Exception;

    Optional<SupportingDocument> findById(String id);

    List<SupportingDocument> getAllUploadedDocuments();
}
//List<SupportingDocument>uploadFiles(MultipartFile[] multipartFiles, Map<String, String>headers);