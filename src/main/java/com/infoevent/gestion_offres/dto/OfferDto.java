package com.infoevent.gestion_offres.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OfferDto {
    private Long id;
    private String name;
    private int capacity;
    private BigDecimal price;
    private String description;
    private String includedActivitiesOffer;
    private String offerType;
    private LocalDateTime createdAt;
}

