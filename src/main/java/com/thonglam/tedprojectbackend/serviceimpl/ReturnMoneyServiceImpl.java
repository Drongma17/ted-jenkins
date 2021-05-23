package com.thonglam.tedprojectbackend.serviceimpl;

import com.thonglam.tedprojectbackend.dao.ReturnMoneyRepository;
import com.thonglam.tedprojectbackend.dao.SnowBankRepository;
import com.thonglam.tedprojectbackend.dto.ReturnMoney;
import com.thonglam.tedprojectbackend.dto.SnowBank;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.ReturnMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("returnMoneyService")
public class ReturnMoneyServiceImpl implements ReturnMoneyService {

    @Autowired ReturnMoneyRepository returnMoneyRepository;
    @Autowired SnowBankRepository snowBankRepository;


    @Override
    public List<ReturnMoney> getAllReturnMoney() {
        return returnMoneyRepository.findAll();
    }



    @Override
    public ReturnMoney addReturnmoneyToSnowbank(Long snowbankId, ReturnMoney returnMoney) {
      return  snowBankRepository.findById(snowbankId)
                .map(snowBank -> {
                    returnMoney.setSnowBank(snowBank);
                    returnMoney.setGrandTotal(ReturnGrandTotal(snowbankId) + returnMoney.getReturnAmount());
                    snowBank.setTotalReturned(ReturnGrandTotal(snowbankId) + returnMoney.getReturnAmount());
                    snowBankRepository.save(snowBank);
                    return returnMoneyRepository.save(returnMoney);
                }).orElseThrow(()->new NotFoundException("snow bank is not found"));

    }



    @Override
    public List<ReturnMoney> getReturnMoneyBySnowBankId(Long snowbankId) {
        return returnMoneyRepository.getReturnMoneyBySnowBankId(snowbankId);
    }


    @Override
    public String deleteReturnMoney(Long snowbankId, Long returnmoneyId) {
        if(!snowBankRepository.existsById(snowbankId)){
            throw new NotFoundException("snow bank id is not found");
        }
        return returnMoneyRepository.findById(returnmoneyId)
                .map(snowbank ->{
                    returnMoneyRepository.deleteById(returnmoneyId);
                    return "one return money is deleted successfully";
                }).orElseThrow(()->new NotFoundException("snow bank is not found"));
    }




    @Override
    public ReturnMoney updateReturnMoney(Long snowbankId, Long returnmoneyId, ReturnMoney returnMoney) {
        if(!snowBankRepository.existsById(snowbankId)){
            throw new NotFoundException("snow bank id is not found");
        }
        return returnMoneyRepository.findById(returnmoneyId)
                .map(returnMoney1 -> {
                    returnMoney1.setReturnAmount(returnMoney.getReturnAmount());
                    returnMoney1.setPurpose(returnMoney.getPurpose());
                    returnMoney1.setReturnDate(returnMoney.getReturnDate());
                    return returnMoneyRepository.save(returnMoney1);
                }).orElseThrow(()->new NotFoundException("Return Money Id is not found"));
    }





    @Override
    public Double ReturnGrandTotal(Long id){
        SnowBank singleSnowbank = snowBankRepository.getOne(id);
        Double returnAmount=0.0;
        List<ReturnMoney> returnMonies = returnMoneyRepository.getReturnMoneyBySnowBankId(singleSnowbank.getId());
        for(ReturnMoney returnMoney: returnMonies){
            returnAmount =returnAmount +returnMoney.getReturnAmount();
        }
        return returnAmount;
    }


    @Override
    public Optional<SnowBank> getOneReturnMoney(Long returnmoney) {
        return snowBankRepository.findById(returnmoney);
    }
}
