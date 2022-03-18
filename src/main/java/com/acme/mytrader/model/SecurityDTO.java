package com.acme.mytrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
public class SecurityDTO {

    private final String security;
    private final double priceThreshold;
    private final int volume;
}
