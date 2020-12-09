package com.tts.weatherapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ZipCode {
    
    public ZipCode(String zipCode) {
        this.zipCode=zipCode;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @NonNull
    private Long id;
    @NonNull
    private String zipCode;
}