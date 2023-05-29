package com.example.Insurance_and_Claims.Service;

import com.example.Insurance_and_Claims.Model.SupportingDocument;
import com.example.Insurance_and_Claims.Response.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface SupportingDocumentService {
    SupportingDocument saveSupportingDocument(MultipartFile file) throws Exception;

    SupportingDocument getSupportingDocument(String id) throws Exception;

    List<SupportingDocument> findALLSupportingDocument();
}
//List<SupportingDocument>uploadFiles(MultipartFile[] multipartFiles, Map<String, String>headers);