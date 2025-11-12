package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    @Autowired
    private CropRepository cropRepository;

    // CREATE
    @PostMapping
    public CropRecord addCrop(@RequestBody CropRecord crop) {
        return cropRepository.save(crop);
    }

    // READ ALL
    @GetMapping
    public List<CropRecord> getAllCrops() {
        return cropRepository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<CropRecord> getCrop(@PathVariable Long id) {
        return cropRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CropRecord> updateCrop(@PathVariable Long id, @RequestBody CropRecord crop) {
        return cropRepository.findById(id)
                .map(existing -> {
                	existing.setCropName(crop.getCropName());
                	existing.setDiseaseDetected(crop.getDiseaseDetected());
                	existing.setConfidence(crop.getConfidence());
                	existing.setLocation(crop.getLocation());
                	existing.setRecommendation(crop.getRecommendation());
                	cropRepository.save(existing);

                    
                    return ResponseEntity.ok(existing);
                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrop(@PathVariable Long id) {
        return cropRepository.findById(id)
                .map(existing -> {
                    cropRepository.delete(existing);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
