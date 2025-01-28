package com.korkmaz.egrosbackend.product_management.application.services.attribute;

import com.korkmaz.egrosbackend.product_management.presentation.dto.request.CreateAttributeRequest;
import com.korkmaz.egrosbackend.product_management.presentation.dto.response.CreateAttributeResponse;

public interface AttributeService {
    CreateAttributeResponse createAttribute(CreateAttributeRequest request);
}