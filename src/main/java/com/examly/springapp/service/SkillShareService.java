package com.examly.springapp.service;

import com.examly.springapp.exception.SkillShareNotFoundException;
import com.examly.springapp.model.SkillShare;
import com.examly.springapp.repository.SkillShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillShareService {
    
    @Autowired
    private SkillShareRepository skillShareRepository;
    
    public SkillShare addSkillShare(SkillShare skillShare) {
        // Validate required fields
        if (skillShare.getSkillName() == null || skillShare.getSkillName().trim().isEmpty()) {
            throw new IllegalArgumentException("Skill name is required");
        }
        if (skillShare.getCategory() == null || skillShare.getCategory().trim().isEmpty()) {
            throw new IllegalArgumentException("Category is required");
        }
        if (skillShare.getSkillLevel() == null || skillShare.getSkillLevel().trim().isEmpty()) {
            throw new IllegalArgumentException("Skill level is required");
        }
        if (skillShare.getUserEmail() == null || skillShare.getUserEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("User email is required");
        }
        if (skillShare.getAvailability() == null || skillShare.getAvailability().trim().isEmpty()) {
            throw new IllegalArgumentException("Availability is required");
        }
        return skillShareRepository.save(skillShare);
    }
    
    public List<SkillShare> getAllSkillShares() {
        return skillShareRepository.findAll();
    }
    
    public SkillShare getSkillShareById(Long id) {
        return skillShareRepository.findById(id)
                .orElseThrow(() -> new SkillShareNotFoundException("SkillShare not found with id: " + id));
    }
    
    public SkillShare updateSkillShare(Long id, SkillShare skillShare) {
        SkillShare existing = getSkillShareById(id);
        existing.setSkillName(skillShare.getSkillName());
        existing.setCategory(skillShare.getCategory());
        existing.setSkillLevel(skillShare.getSkillLevel());
        existing.setUserEmail(skillShare.getUserEmail());
        existing.setDescription(skillShare.getDescription());
        existing.setAvailability(skillShare.getAvailability());
        return skillShareRepository.save(existing);
    }
    
    public void deleteSkillShare(Long id) {
        SkillShare skillShare = getSkillShareById(id);
        skillShareRepository.delete(skillShare);
    }
}