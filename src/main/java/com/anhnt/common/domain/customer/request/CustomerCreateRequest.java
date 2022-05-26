package com.anhnt.common.domain.customer.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetTime;

@Data
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerCreateRequest {

  @NotNull
  @NotBlank
  @Size(max = 50)
  @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
  @Email()
  private String username;
  private String name;
  private String mobile;
  private LocalDate dateOfBirth;
  private Instant verifiedDatetime;
  private OffsetTime availableTime;
}
