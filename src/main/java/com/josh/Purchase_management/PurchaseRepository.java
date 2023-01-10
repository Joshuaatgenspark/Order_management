package com.josh.Purchase_management;

import org.springframework.data.jpa.repository.JpaRepository;
interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
