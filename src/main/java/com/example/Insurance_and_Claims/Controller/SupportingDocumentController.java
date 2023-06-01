package com.example.Insurance_and_Claims.Controller;

import com.example.Insurance_and_Claims.Model.SupportingDocument;
import com.example.Insurance_and_Claims.Response.ResponseData;
import com.example.Insurance_and_Claims.Service.SupportingDocumentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/document")

public class SupportingDocumentController   {

    private SupportingDocumentService supportingDocumentService;

    public SupportingDocumentController(SupportingDocumentService supportingDocumentService) {
        this.supportingDocumentService = supportingDocumentService;
    }
    @PostMapping("/upload")
    public ResponseEntity<List<ResponseData>> uploadFile(@RequestPart("files") MultipartFile[] files) throws Exception {
        List<ResponseData> responseDataList = new ArrayList<>();

        for (MultipartFile file : files) {
            SupportingDocument supportingDocument = null;
            String downloadURL = "";

            supportingDocument = supportingDocumentService.saveSupportingDocument(file);
            downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(String.valueOf(supportingDocument.getId()))
                    .toUriString();

            ResponseData responseData = new ResponseData(
                    supportingDocument.getFileName(),
                    downloadURL,
                    file.getContentType(),
                    file.getSize()
            );

            responseDataList.add(responseData);
        }

        return ResponseEntity.ok(responseDataList);
    }

    @GetMapping(path = "/{id}")
    public Optional<SupportingDocument> findDocumentById(@PathVariable("id")String id) throws Exception {
        return supportingDocumentService.findById(id);
    }


//    @PostMapping("/upload")
//    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
//
//        SupportingDocument supportingDocument=null;
//        String downloadURL="";
//        supportingDocument=supportingDocumentService.saveSupportingDocument(file);
//        downloadURL= ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download/")
//                .path(String.valueOf(supportingDocument.getId()))
//                .toUriString();
//
//        return new ResponseData(supportingDocument.getFileName(),downloadURL,file.getContentType(),file.getSize());
//    }
//    @PostMapping("/uploadFiles")
//    public List<ResponseData> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file ->uploadFile(file))
//                .collect(Collectors.toList());
//    }
    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) throws Exception {
        SupportingDocument supportingDocument=null;
        supportingDocument=supportingDocumentService.getSupportingDocument(fileName);
        return ResponseEntity.ok()
                .contentType(   MediaType.parseMediaType(supportingDocument.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                "supportingDocument;filename=\""+supportingDocument.getFileName()+"\"")
                .body( new ByteArrayResource(supportingDocument.getData()));
    }
    @GetMapping("/all")
    public ResponseEntity<List<SupportingDocument>> getAllUploadedDocuments() {
        List<SupportingDocument> uploadedDocuments = supportingDocumentService.getAllUploadedDocuments();
        return ResponseEntity.ok(uploadedDocuments);
    }
}
