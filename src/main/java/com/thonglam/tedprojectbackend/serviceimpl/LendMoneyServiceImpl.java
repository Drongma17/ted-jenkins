package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thonglam.tedprojectbackend.dao.LendMoneyRepository;
import com.thonglam.tedprojectbackend.dao.SnowBankRepository;
import com.thonglam.tedprojectbackend.dto.LendMoney;
import com.thonglam.tedprojectbackend.dto.SnowBank;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.LendMoneyService;


@Service("lendMoneyService")
public class LendMoneyServiceImpl implements LendMoneyService {


    @Autowired
    LendMoneyRepository lendMoneyRepository;
    @Autowired
    SnowBankRepository snowBankRepository;

    @Override
    public List<LendMoney> getAllLendMoney() {
        return lendMoneyRepository.findAll();
    }



    @Override
    public LendMoney addLendMoney(Long customerId, LendMoney lendMoney) {
     return   snowBankRepository.findById(customerId)
                .map(snowBank -> {
                    lendMoney.setSnowBank(snowBank);
                    lendMoney.setLendSum(lendMoneySum(customerId) + lendMoney.getLendAmount());
                    snowBank.setLendAmount(lendMoneySum(customerId)  + lendMoney.getLendAmount());
                    snowBankRepository.save(snowBank);
                    return lendMoneyRepository.save(lendMoney);
                }).orElseThrow(()->new NotFoundException("Snow Bank Id is not found"));
         }



    @Override
    public List<LendMoney> getLendMoneyBySnowBankId(Long customerId) {
        return lendMoneyRepository.getLendMoneyBySnowBankId(customerId);
    }



    @Override
    public String deleteLendMoney(Long customerId, int lendmoneyId) {
        if(!snowBankRepository.existsById(customerId)){
          throw  new NotFoundException("snow bank id is not found ");
        }
        return lendMoneyRepository.findById(lendmoneyId)
                .map(snowbank ->{
                    lendMoneyRepository.delete(snowbank);
                    return "one lend amount is deleted";
                }).orElseThrow(()->new NotFoundException("Snow Bank Id is not found"));
    }




    @Override
    public LendMoney updateLendMoney(Long customerId, int lendmoneyId, LendMoney lendMoney) {
        if(!snowBankRepository.existsById(customerId)){
            throw  new NotFoundException("snow bank id is not found ");
        }
        return lendMoneyRepository.findById(lendmoneyId)
                .map(moneylend ->{
                    moneylend.setLendAmount(lendMoney.getLendAmount());
                    moneylend.setDescription(lendMoney.getDescription());
                    moneylend.setLendDate(lendMoney.getLendDate());
                    moneylend.setPurpose(lendMoney.getPurpose());
                    return lendMoneyRepository.save(moneylend);
                }).orElseThrow(()->new NotFoundException("SNOW BANK ID  is not found"));
    }




    public Double lendMoneySum(Long id){
        SnowBank snowBank = snowBankRepository.getOne(id);
        Double lendedSum=0.0;
        List<LendMoney> lendMonies = lendMoneyRepository.getLendMoneyBySnowBankId(snowBank.getId());
        for(LendMoney lendMoney: lendMonies){
            lendedSum =lendedSum +lendMoney.getLendAmount();
        }
        return lendedSum;
    }


}
