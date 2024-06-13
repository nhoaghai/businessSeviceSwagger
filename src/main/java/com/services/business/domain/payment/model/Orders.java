package com.services.business.domain.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.services.business.domain.member.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "serial_number")
//    @GeneratedValue(strategy = GenerationType.UUID)
    private String serialNumber;

    @Column(name = "payment_at")
    private Date paymentAt;

    @ManyToOne
    @JoinColumn(name = "total_expenses_id", referencedColumnName = "total_expenses_id")
    @JsonIgnore
    private TotalExpenses totalExpenses;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;


}
