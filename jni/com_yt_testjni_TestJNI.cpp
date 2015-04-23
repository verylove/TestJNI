/*
 * com_TestJNI_jni_TestJNI.cpp
 *
 *  Created on: 2015Äê4ÔÂ23ÈÕ
 *      Author: Yang
 */



#include <stdio.h>
#include <stdlib.h>
#include "com_yt_testjni_TestJNI.h"
#include "Add.h"


CAdd *pCAdd = NULL;

JNIEXPORT jboolean JNICALL Java_com_yt_testjni_TestJNI_Init(JNIEnv *env,jobject obj)
{
	if(pCAdd == NULL)
	{
		pCAdd = new CAdd;
	}
	return pCAdd != NULL;
}

JNIEXPORT jint JNICALL Java_com_yt_testjni_TestJNI_Add(JNIEnv *env,jobject obj,jint x,jint y)
{
	int res = -1;
	if(pCAdd != NULL)
	{
		res = pCAdd->Add(x,y);
	}
	return res;
}


JNIEXPORT void JNICALL Java_com_yt_testjni_TestJNI_Destory(JNIEnv *env,jobject obj)
{
	if(pCAdd != NULL)
	{
		delete pCAdd;
		pCAdd = NULL;
	}
}



















