package com.yt.testjni;


public class TestJNI {
	public native boolean Init();
    public native int Add(int x, int y);
    public native void Destory();
}
