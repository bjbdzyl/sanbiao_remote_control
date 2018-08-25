package com.sgai.meter.transmission.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgai.meter.transmission.entity.Household;
import com.sgai.meter.transmission.service.HouseholdService;
import com.szx.core.service.AbstractMapperService;

@Transactional
@Service
public class HouseholdServiceImpl extends AbstractMapperService<Household> implements HouseholdService {

}
