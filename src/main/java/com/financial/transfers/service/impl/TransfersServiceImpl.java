package com.financial.transfers.service.impl;

import com.financial.transfers.dto.EnrichReturnDto;
import com.financial.transfers.dto.ReceivedTransfersDto;
import com.financial.transfers.dto.TransfersResponseDto;
import com.financial.transfers.entity.SavedAccountsEntity;
import com.financial.transfers.entity.TransfersEntity;
import com.financial.transfers.entity.UserEntity;
import com.financial.transfers.repository.SavedAccountRepository;
import com.financial.transfers.repository.TransfersRepository;
import com.financial.transfers.repository.UserRepository;
import com.financial.transfers.service.TransfersService;
import com.financial.transfers.utils.DateUtils;
import com.financial.transfers.utils.TransfersTypeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class TransfersServiceImpl implements TransfersService {

    private static final Logger logger = LoggerFactory.getLogger(TransfersServiceImpl.class);
    @Autowired
    private TransfersValidatorServiceImpl transfersValidatorService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SavedAccountRepository savedAccountRepository;

    @Autowired
    private TransfersRepository transfersRepository;

    @Override
    public TransfersResponseDto processTransfers(ReceivedTransfersDto received) throws ParseException {

        UserEntity user = new UserEntity(1L, "Felipe", "Carreira", "000.0000.000-00", "100");
        SavedAccountsEntity saved = new SavedAccountsEntity(1L, "Fulano", "Detal", "000.0000.000-00", "200");
        this.userRepository.save(user);
        this.savedAccountRepository.save(saved);

        EnrichReturnDto enrichReturn = transfersValidatorService.validator(received.getValue(),
                received.getTransfersDate(), TransfersTypeUtils.convertToEnum(received.getTransfersType()));
        if (enrichReturn.isError()) {
            logger.error("enrich error...");
            return new TransfersResponseDto("error", true);
        }

        SavedAccountsEntity targetAccount = this.savedAccountRepository.findByAccountNumber(received.getTargetAccount());

        TransfersEntity transfersEntity = new TransfersEntity();
        transfersEntity.setTargetTransfers(targetAccount);
        transfersEntity.setUser(user);
        transfersEntity.setTransferValue(enrichReturn.getCurrentValue());
        transfersEntity.setTransfersDate(DateUtils.toDate(received.getTransfersDate()));

        this.transfersRepository.save(transfersEntity);

        return new TransfersResponseDto("sucess!", false);
    }
}
