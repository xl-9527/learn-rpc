package com.rpc.dubbo.api.filter.service;

import com.rpc.dubbo.api.filter.Bill;

import java.util.List;

/**
 * @author xl-9527
 * @since 2025/1/16
 **/
public interface BillService {

    Bill getBill(String billId);

    List<Bill> queryList();
}
