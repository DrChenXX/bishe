package com.example.bishe.service.impl;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.entity.CutWork;
import com.example.bishe.model.entity.Salary;
import com.example.bishe.service.SalaryService;
import com.example.bishe.mapper.SalaryMapper;
import com.example.bishe.service.UserService;
import com.example.bishe.service.CutWorkService;
import com.example.bishe.util.AliPayUtil;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
* @description 针对表【salary】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary>
    implements SalaryService {

    @Resource
    private SalaryMapper salaryMapper;

    @Resource
    private CutWorkService cutWorkService;

    @Resource
    private UserService userService;

    @Resource
    private AliPayUtil aliPayUtil;;
    @Override
    public List<Salary> getSalryList() {
        return this.list();
    }

    @Override
    public int generate(Long workId, BigDecimal money) {
        CutWork cutWork = cutWorkService.getWorkById(workId);
        Salary salary = new Salary();
        salary.setWorkerId(cutWork.getWorkerId());
        salary.setTaskId(cutWork.getTaskId());
        salary.setWorkerNumber(userService.getUserById(cutWork.getWorkerId()).getWorkerNumber());
        salary.setWorkerName(userService.getUserById(cutWork.getWorkerId()).getUsername());
        salary.setTaskNumber(cutWork.getTaskNumber());
        salary.setNumber(cutWork.getNumber());
        salary.setMoney(money);
        return salaryMapper.insert(salary);
    }

    @Override
    public int confirm(Long salaryId) {
        Salary salary = salaryMapper.selectById(salaryId);
        salary.setState(1);
        return salaryMapper.updateById(salary);
    }

    @Override
    public String trans(Long salaryId) {
        Salary salary = salaryMapper.selectById(salaryId);
        if (salary.getState() != 1) {
            return null;
        }

        //封装支付工具类所需参数
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("outBizNo",salary.getTaskNumber());
        hashMap.put("transAmount", String.valueOf(salary.getMoney()));
        hashMap.put("identity",userService.getUserById(salary.getWorkerId()).getAlipayId());
        hashMap.put("name", userService.getUserById(salary.getWorkerId()).getAlipayName());
        try {
            HashMap<String, String> res = aliPayUtil.pay(hashMap);
            salary.setOrderId(res.get("orderId"));
            salary.setPayFundOrderId(res.get("payFundOrderId"));
            salary.setTransDate(res.get("transDate"));
            salaryMapper.updateById(salary);
            return res.get("msg");
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteSalary(Long id) {
        return salaryMapper.deleteById(id);
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateById(salary);
    }

    @Override
    public Salary getSalaryById(Long id) {
        return salaryMapper.selectById(id);
    }


}




