package com.karpen.springRestApi.service;

import com.karpen.springRestApi.model.Account;
import com.karpen.springRestApi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findById(Long id) {
        return accountRepository.getOne(id);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account save (Account account) {
        return accountRepository.save(account);
    }

    public void deletedById(Long id) {
        accountRepository.deleteById(id);
    }
}
