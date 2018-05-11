/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.memoryloadgenerator.memoryloadgenerator;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import java.util.ArrayList;
import java.util.List;

import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

//import com.memoryloadgenerator.memoryloadgenerator.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 *
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 *
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 */
@ExposeToClient
public class MemoryLoadGenerator {

    private static final Logger logger = LoggerFactory.getLogger(MemoryLoadGenerator.class);

    private static List<Integer> memoryList = new ArrayList<Integer>();
    @Autowired
    private SecurityService securityService;

    public int increaseMemoryLoad(int sizeToIncreaseInMB, HttpServletRequest request) {
        int integerCount = (sizeToIncreaseInMB)*1024*(1024/12);
        
        for(int i=0; i<integerCount; i++) {
            memoryList.add(1);
        }
        return memoryList.size();
    }
    
    public int decreaseMemoryLoad(int sizeToDecreaseInMB, HttpServletRequest request) {
        int integerCount = (sizeToDecreaseInMB)*1024*(1024/12);
        for(int i=0; i<integerCount; i++) {
            if(!memoryList.isEmpty())
            memoryList.remove(0);
           System.gc ();
        }
        return memoryList.size();
    }
    
    public int getCurrent(HttpServletRequest request) {
        return memoryList.size();
    }

}
