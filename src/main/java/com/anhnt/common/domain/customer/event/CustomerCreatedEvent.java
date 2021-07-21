package com.anhnt.common.domain.customer.event;

import io.eventuate.tram.events.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreatedEvent implements DomainEvent {
  private String name;
  private BigDecimal creditLimit;
}
