package com.karpen.springRestApi.rest;

import com.karpen.springRestApi.model.Account;
import com.karpen.springRestApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/karpen/api/")
public class AccountRestController {

    private final AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ResponseBody
    @GetMapping(value = "/accounts")
    @PreAuthorize("hasAnyAuthority('admin', 'moderator')")
    public String findAll() {
        List<Account> accounts = accountService.findAll();
        return accounts.toString();
    }

    @ResponseBody
    @GetMapping(value = "/account/{id}")
    @PreAuthorize("hasAnyAuthority('moderator', 'admin')")
    public String findById(@PathVariable("id") Long id) {
        return String.valueOf(accountService.findById(id));
    }

    @ResponseBody
    @DeleteMapping(value = "/account-deleted/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String deletedById (@PathVariable("id") Long id) {
        accountService.deletedById(id);
        return "deleted account with id = " + id;
    }

    @ResponseBody
    @PostMapping(value = "/account-save")
    @PreAuthorize("hasAuthority('admin')")
    public String save (@RequestBody Account account) {
        accountService.save(account);
        return "save account with id = " + account.getId();
    }



}
