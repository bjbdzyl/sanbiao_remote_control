package com.sgai.meter.transmission.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgai.meter.transmission.entity.Device;
import com.sgai.meter.transmission.service.DeviceService;
import com.szx.core.service.AbstractMapperService;

@Transactional
@Service
public class DeviceServiceImpl extends AbstractMapperService<Device> implements DeviceService {

}
