package com.learning.zookeeper.configurationcenter2;

public interface IWatcher {
    void process(byte[] data);
}
