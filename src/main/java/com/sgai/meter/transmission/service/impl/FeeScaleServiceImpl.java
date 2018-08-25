package com.sgai.meter.transmission.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgai.meter.transmission.entity.FeeScale;
import com.sgai.meter.transmission.service.FeeScaleService;
import com.szx.core.service.AbstractMapperService;

@Transactional
@Service
public class FeeScaleServiceImpl extends AbstractMapperService<FeeScale> implements FeeScaleService {

}
