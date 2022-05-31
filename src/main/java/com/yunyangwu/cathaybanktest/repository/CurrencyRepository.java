package com.yunyangwu.cathaybanktest.repository;

import com.yunyangwu.cathaybanktest.model.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {
}
