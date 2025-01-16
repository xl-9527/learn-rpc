package com.rpc.dubbo.consumer.stub.filter;

import com.rpc.dubbo.api.filter.Bill;
import com.rpc.dubbo.api.filter.service.BillService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Profile;

import java.util.List;

/**
 * @author xl-9527
 * @since 2025/1/16
 **/
@DubboService
@Profile("filter")
public class BillServiceImpl implements BillService {

    @Override
    public Bill getBill(final String billId) {
        return null;
    }

    @Override
    public List<Bill> queryList() {
        return List.of();
    }
}
