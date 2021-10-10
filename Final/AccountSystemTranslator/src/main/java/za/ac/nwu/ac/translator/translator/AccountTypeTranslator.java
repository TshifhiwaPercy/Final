package za.ac.nwu.ac.translator.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();
    AccountTypeDto create(AccountTypeDto accountTypeDto);
    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

}
