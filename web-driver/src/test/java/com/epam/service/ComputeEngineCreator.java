package com.epam.service;

import com.epam.model.ComputeEngine;

public class ComputeEngineCreator {
    private static final String OS = "testdata.computeEngine.os";
    private static final String INSTANCES_NUMBER = "testdata.computeEngine.instancesNumber";
    private static final String PLATFORM = "testdata.computeEngine.platform";
    private static final String VM_CLASS = "testdata.computeEngine.vmClass";
    private static final String TYPE_INSTANCE = "testdata.computeEngine.typeInstance";
    private static final String LOCAL_SSD = "testdata.computeEngine.localSSD";
    private static final String COMMITED_USAGE = "testdata.computeEngine.commitedUsage";
    private static final String DATA_CENTER_LOCATION = "testdata.computeEngine.dataCenterLocation";
    private static final String GPU_NUMBER = "testdata.computeEngine.numberGPU";
    private static final String TYPE_GPU = "testdata.computeEngine.typeGPU";

    public static ComputeEngine withCredentialsFromProperties() {
        return new ComputeEngine(TestDataReader.getTestData(OS),
                Integer.parseInt(TestDataReader.getTestData(INSTANCES_NUMBER)),
                TestDataReader.getTestData(PLATFORM),
                TestDataReader.getTestData(VM_CLASS),
                TestDataReader.getTestData(TYPE_INSTANCE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(COMMITED_USAGE),
                TestDataReader.getTestData(DATA_CENTER_LOCATION),
                TestDataReader.getTestData(GPU_NUMBER),
                TestDataReader.getTestData(TYPE_GPU));
    }
}

