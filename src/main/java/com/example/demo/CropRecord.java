package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CropRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private String diseaseDetected;
    private String confidence;
    private String location;
    private String recommendation;

    public CropRecord() {}

    public CropRecord(String cropName, String diseaseDetected, String confidence, String location, String recommendation) {
        this.cropName = cropName;
        this.diseaseDetected = diseaseDetected;
        this.confidence = confidence;
        this.location = location;
        this.recommendation = recommendation;
    }

    public Long getId() { return id; }
    public String getCropName() { return cropName; }
    public String getDiseaseDetected() { return diseaseDetected; }
    public String getConfidence() { return confidence; }
    public String getLocation() { return location; }
    public String getRecommendation() { return recommendation; }

    public void setCropName(String cropName) { this.cropName = cropName; }
    public void setDiseaseDetected(String diseaseDetected) { this.diseaseDetected = diseaseDetected; }
    public void setConfidence(String confidence) { this.confidence = confidence; }
    public void setLocation(String location) { this.location = location; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }
}
