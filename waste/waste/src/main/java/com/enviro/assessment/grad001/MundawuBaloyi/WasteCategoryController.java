package com.enviro.assessment.grad001.MundawuBaloyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/waste")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/add")
    public String addWasteCategory(@ModelAttribute WasteCategory wasteCategory, Model model) {
        wasteCategoryService.createWasteCategory(wasteCategory);
        model.addAttribute("wasteCategory", wasteCategory);
        return "redirect:/waste/details/" + wasteCategory.getName();
    }

    @GetMapping("/details/{name}")
    public String wasteDetails(@PathVariable String name, Model model) {
        String details = getRecyclingDetails(name);
        model.addAttribute("details", details);
        return "details";
    }

    private String getRecyclingDetails(String name) {
        switch (name.toLowerCase()) {
            case "plastic":
                return "Plastics should be sorted by type and recycled at designated facilities. Avoid mixing different types of plastics.";
            case "paper":
                return "Paper should be clean and dry. Recycle in paper bins. Avoid recycling paper with food stains.";
            case "glass":
                return "Glass bottles and jars should be rinsed and sorted by color. Recycle at glass collection points.";
            case "metal":
                return "Metal cans should be rinsed and flattened. Recycle in metal bins.";
            case "electronics":
                return "Electronics should be taken to e-waste recycling centers. Do not dispose of in regular trash.";
            case "batteries":
                return "Batteries should be disposed of at designated battery recycling points.";
            case "organic waste":
                return "Compost organic waste or dispose of it in organic waste bins.";
            case "textiles":
                return "Donate usable textiles or recycle at textile recycling points.";
            case "wood":
                return "Recycle untreated wood at wood recycling centers.";
            case "ceramics":
                return "Dispose of ceramics in general waste or at specific recycling centers.";
            case "light bulbs":
                return "Dispose of light bulbs at designated recycling points.";
            case "tires":
                return "Recycle tires at designated tire recycling centers.";
            default:
                return "No specific recycling instructions available.";
        }
    }
}