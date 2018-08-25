package com.sgai.meter.transmission.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgai.meter.transmission.entity.Area;
import com.sgai.meter.transmission.service.AreaService;
import com.szx.core.service.AbstractMapperService;

@Transactional
@Service
public class AreaServiceImpl extends AbstractMapperService<Area> implements AreaService {

}
