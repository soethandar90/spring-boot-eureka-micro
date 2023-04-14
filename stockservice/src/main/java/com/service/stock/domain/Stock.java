package com.service.stock.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("stock")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Stock implements Serializable {
    @Id
    private String productNumber;
    private int numberInStock;
    private String locationCode;
}
