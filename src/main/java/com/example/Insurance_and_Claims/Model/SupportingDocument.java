package com.example.Insurance_and_Claims.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "Supporting_Document")
public class SupportingDocument {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String fileName;
    private String fileType;

    @Lob
    private byte [] data;

    @ManyToOne
    @JoinColumn(name ="claim_id")
    private FileClaim fileClaim;

    @JsonBackReference
    public FileClaim getFileClaim() {
        return fileClaim;
    }

    public void setFileClaim(FileClaim fileClaim) {
        this.fileClaim = fileClaim;
    }

    public SupportingDocument(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public SupportingDocument() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
