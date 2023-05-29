package com.example.Insurance_and_Claims.Service.Implementation;

import com.example.Insurance_and_Claims.Model.SupportingDocument;
import com.example.Insurance_and_Claims.Repository.SupportingDocumentRepository;
import com.example.Insurance_and_Claims.Response.ResponseData;
import com.example.Insurance_and_Claims.Service.SupportingDocumentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class SupportingDocumentImplementation implements SupportingDocumentService {

    private final SupportingDocumentRepository supportingDocumentRepository;
    private List<SupportingDocument> ResponseData;

    public SupportingDocumentImplementation(SupportingDocumentRepository supportingDocumentRepository) {
        this.supportingDocumentRepository = supportingDocumentRepository;
    }

//
//    private String uploadPath;
//
//    private String fileExtensions;
//    @Override
//    public List<SupportingDocument> uploadFiles(MultipartFile[] multipartFiles, Map<String, String> headers) {
//        if (multipartFiles==null){
//            log.error("Invalid file Upload");
//            throw new IllegalArgumentException("Invalid file");
//        }
//        Arrays.stream(multipartFiles).forEach(file -> {
//            try{
//                String filename=StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//                String fileExtension=getFileExtension(filename);
//                if (!fileExtensions.contains(fileExtension)){
//                    log.error("Invalid file Upload");
//                    throw new IllegalArgumentException("Invalid file extension");
//                }
//
//                byte[] bytes=file.getBytes();
//                Files.write(Paths.get(uploadPath + file.getOriginalFilename()),bytes);
//
//                var fileNameUpload= FilenameUti.refilename)
//                FileUpload fileUpload=new FileUpload();
//            }catch (IOException ioException){
//                log.error("Upload file error {}",ioException.getLocalizedMessage());
//            }
//        });
//
//        return null;
//    }
//    public String getFileExtension(String filename){
//        int dotIndex= filename.lastIndexOf(".");
//        if(dotIndex<0){
//            return null;
//        }
//        return filename.substring(dotIndex+1);
//    }


    @Override
    public SupportingDocument saveSupportingDocument(MultipartFile file) throws Exception {
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try {
                if (fileName.contains("..")){
                    throw new Exception("Filename contains invalid path sequence"+fileName);

                }
                SupportingDocument supportingDocument= new SupportingDocument(fileName,
                        file.getContentType(),
                        file.getBytes());
                return supportingDocumentRepository.save(supportingDocument);
        }catch (IOException ex) {
            throw new Exception("Could not save File:" +fileName);
        }
    }

    @Override
    public SupportingDocument getSupportingDocument(String id) throws Exception {
        return supportingDocumentRepository
                .findById(id)
                .orElseThrow(()->new Exception("File not found with ID:" +id));
    }

    @Override
    public List<SupportingDocument> findALLSupportingDocument() {
        return supportingDocumentRepository.findAll();
    }
}
