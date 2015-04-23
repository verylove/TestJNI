LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := com_yt_testjni_TestJNI.cpp
LOCAL_SRC_FILES += Add.cpp

LOCAL_C_INCLUDES += \
	$(JNI_H_INCLUDE)

LOCAL_SHARED_LIBRARIES := \
	libnativehelper \
	libcutils \
	libutils \
	libbinder \
	libskia \
    libui \
    libsurfaceflinger_client

LOCAL_C_INCLUDES += \
	external/skia/include/core \
	external/skia/include/effects \
	external/skia/include/images \
	external/skia/src/ports \
	external/skia/include/utils

LOCAL_MODULE:= TestJNI
LOCAL_MODULE_TAGS := optional
LOCAL_PRELINK_MODULE := false

include $(BUILD_SHARED_LIBRARY)    
