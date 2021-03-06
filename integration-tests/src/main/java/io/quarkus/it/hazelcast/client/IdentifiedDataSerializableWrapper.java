package io.quarkus.it.hazelcast.client;

import java.io.IOException;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

public class IdentifiedDataSerializableWrapper implements IdentifiedDataSerializable {

    static final int CLASS_ID = 42;

    private String value;

    public IdentifiedDataSerializableWrapper() {
    }

    public IdentifiedDataSerializableWrapper(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        value = in.readUTF();
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeUTF(value);
    }

    @Override
    public int getFactoryId() {
        return IdentifiedDataSerializableWrapperFactory.FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
