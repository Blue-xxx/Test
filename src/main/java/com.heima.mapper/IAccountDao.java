package com.heima.mapper;

import com.heima.dao.Account;
import com.heima.dao.AccountUser;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();
    List<AccountUser> findAllAccount();
 }
