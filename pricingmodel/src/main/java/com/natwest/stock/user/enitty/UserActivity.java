package com.natwest.stock.user.enitty;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_activity")
@Getter
@Setter
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "stock_Symbol")
    private String StockSymbol;
    @Column(name = "activity_date")
    private LocalDateTime ActivityDate;

}
