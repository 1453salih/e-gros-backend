package com.korkmaz.egrosbackend.order_management.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequest {

    private Long productId;
    private int quantity;
}
