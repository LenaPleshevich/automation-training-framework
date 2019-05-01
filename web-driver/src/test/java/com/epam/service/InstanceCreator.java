package com.epam.service;

import com.epam.model.Instance;

public class InstanceCreator {
    private static final String OS = "testdata.calculator.os";
    private static final String INSTANCES_NUMBER = "testdata.calculator.instancesNumber";
    private static final String PLATFORM = "testdata.calculator.platform";
    private static final String VM_CLASS = "testdata.calculator.vmClass";
    private static final String TYPE_INSTANCE = "testdata.calculator.typeInstance";
    private static final String LOCAL_SSD = "testdata.calculator.localSSD";
    private static final String COMMITED_USAGE = "testdata.calculator.commitedUsage";
    private static final String DATA_CENTER_LOCATION = "testdata.calculator.dataCenterLocation";
    private static final String GPU_NUMBER = "testdata.calculator.numberGPU";
    private static final String TYPE_GPU = "testdata.calculator.typeGPU";

    public static Instance withCredentialsFromProperties() {
        return new Instance(TestDataReader.getTestData(OS),
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

