package com.example.Insurance_and_Claims.Repository;

import com.example.Insurance_and_Claims.Model.SupportingDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportingDocumentRepository extends JpaRepository<SupportingDocument,String> {
}
