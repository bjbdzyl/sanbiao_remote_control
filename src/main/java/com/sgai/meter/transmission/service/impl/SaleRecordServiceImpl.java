package com.sgai.meter.transmission.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgai.meter.transmission.entity.SaleRecord;
import com.sgai.meter.transmission.service.SaleRecordService;
import com.szx.core.service.AbstractMapperService;

@Transactional
@Service
public class SaleRecordServiceImpl extends AbstractMapperService<SaleRecord> implements SaleRecordService {

}
