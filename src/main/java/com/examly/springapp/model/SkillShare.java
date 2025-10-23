package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_shares")
public class SkillShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String skillName;
    
    @Column(nullable = false)
    private String category;
    
    @Column(nullable = false)
    private String skillLevel;
    
    @Column(nullable = false)
    private String userEmail;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false)
    private String availability;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getSkillLevel() { return skillLevel; }
    public void setSkillLevel(String skillLevel) { this.skillLevel = skillLevel; }
    
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
}