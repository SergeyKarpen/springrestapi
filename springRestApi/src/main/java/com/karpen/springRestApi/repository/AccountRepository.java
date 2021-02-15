package com.karpen.springRestApi.repository;

import com.karpen.springRestApi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
