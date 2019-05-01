package com.epam.service;

import com.epam.model.Instance;

public class InstanceCreator {
    private static final String OS = "testdata.instance.os";
    private static final String INSTANCES_NUMBER = "testdata.instance.instancesNumber";
    private static final String PLATFORM = "testdata.instance.platform";
    private static final String VM_CLASS = "testdata.instance.vmClass";
    private static final String TYPE_INSTANCE = "testdata.instance.typeInstance";
    private static final String LOCAL_SSD = "testdata.instance.localSSD";
    private static final String COMMITED_USAGE = "testdata.instance.commitedUsage";
    private static final String DATA_CENTER_LOCATION = "testdata.instance.dataCenterLocation";
    private static final String GPU_NUMBER = "testdata.instance.numberGPU";
    private static final String TYPE_GPU = "testdata.instance.typeGPU";

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

