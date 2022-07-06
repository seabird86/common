package com.anhnt.common.domain.customer.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetCustomerResponse {  
  private String id;
  private String username;
  private String name;
  private String mobile;
  private LocalDate dateOfBirth;
  private Instant verifiedDatetime;
  private OffsetTime availableTime;
  private BigDecimal balance;
}