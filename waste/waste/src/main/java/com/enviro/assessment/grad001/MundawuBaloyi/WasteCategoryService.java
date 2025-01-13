// Service
package com.enviro.assessment.grad001.MundawuBaloyi;

import com.enviro.assessment.grad001.MundawuBaloyi.WasteCategory;
import com.enviro.assessment.grad001.MundawuBaloyi.WasteCategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {


    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Waste category not found"));
    }

    public WasteCategory createWasteCategory(@Valid WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory) {
        WasteCategory existingCategory = getWasteCategoryById(id);
        existingCategory.setName(wasteCategory.getName());
        existingCategory.setDescription(wasteCategory.getDescription());
        return wasteCategoryRepository.save(existingCategory);
    }

    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}