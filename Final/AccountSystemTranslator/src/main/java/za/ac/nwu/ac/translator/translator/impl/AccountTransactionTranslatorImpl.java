package za.ac.nwu.ac.translator.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private final AccountTransactionRepository repo;
    public AccountTransactionTranslatorImpl(AccountTransactionRepository repo){
        this.repo = repo;
    }
    @Override
    public AccountTransaction save(AccountTransaction accountTransaction){
        try{
            return repo.save(accountTransaction);
        }
        catch(Exception ex){
            throw new RuntimeException("Unable to save to the DB",ex);
        }
    }
    @Override
    public List<AccountTransaction> getAllAccountTransactions(){
        List<AccountTransaction> accountTransactions;
        try{
            accountTransactions = new ArrayList<>(repo.findAll());
        }
        catch(Exception ex){
            throw new RuntimeException("Unable to read from the DB",ex);
        }
        return accountTransactions;
    }
    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId){
        try{
            return repo.findById(transactionId).orElse(null);
        }
        catch (Exception ex){
            throw new RuntimeException("Unable to read from the DB",ex);
        }
    }
}
