package api.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.ecommerce.domain.entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, String> {
    
}
