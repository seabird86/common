package com.anhnt.common.domain.customer.event;

import io.eventuate.tram.events.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSnapshotEvent implements DomainEvent {
  private Long id;
  private String name;
  private BigDecimal creditLimit;
}
