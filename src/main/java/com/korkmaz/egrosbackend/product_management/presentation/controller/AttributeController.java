package com.korkmaz.egrosbackend.product_management.presentation.controller;


import com.korkmaz.egrosbackend.product_management.application.services.attribute.AttributeService;
import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateAttributeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/attributes")
@RequiredArgsConstructor
public class AttributeController {

    private final AttributeService attributeService;

    @PostMapping
    public ResponseEntity<CreateAttributeResponse> createAttribute(
            @Valid @RequestBody CreateAttributeRequest request) {
        CreateAttributeResponse response = attributeService.createAttribute(request);
        return ResponseEntity.ok(response);
    }
}
