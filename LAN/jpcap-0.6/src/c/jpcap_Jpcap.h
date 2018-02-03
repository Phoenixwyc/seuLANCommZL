/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class jpcap_Jpcap */

#ifndef _Included_jpcap_Jpcap
#define _Included_jpcap_Jpcap
#ifdef __cplusplus
extern "C" {
#endif
#undef jpcap_Jpcap_MAX_NUMBER_OF_INSTANCE
#define jpcap_Jpcap_MAX_NUMBER_OF_INSTANCE 10L
/*
 * Class:     jpcap_Jpcap
 * Method:    nativeOpenLive
 * Signature: (Ljava/lang/String;III)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_jpcap_Jpcap_nativeOpenLive
  (JNIEnv *, jobject, jstring, jint, jint, jint);

/*
 * Class:     jpcap_Jpcap
 * Method:    nativeOpenOffline
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_jpcap_Jpcap_nativeOpenOffline
  (JNIEnv *, jobject, jstring);

/*
 * Class:     jpcap_Jpcap
 * Method:    getDeviceList
 * Signature: ()[Ljpcap/Device;
 */
JNIEXPORT jobjectArray JNICALL Java_jpcap_Jpcap_getDeviceList
  (JNIEnv *, jclass);

/*
 * Class:     jpcap_Jpcap
 * Method:    getDeviceDescription
 * Signature: ()[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_jpcap_Jpcap_getDeviceDescription
  (JNIEnv *, jclass);

/*
 * Class:     jpcap_Jpcap
 * Method:    getPacket
 * Signature: ()Ljpcap/Packet;
 */
JNIEXPORT jobject JNICALL Java_jpcap_Jpcap_getPacket
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_Jpcap
 * Method:    processPacket
 * Signature: (ILjpcap/JpcapHandler;)I
 */
JNIEXPORT jint JNICALL Java_jpcap_Jpcap_processPacket
  (JNIEnv *, jobject, jint, jobject);

/*
 * Class:     jpcap_Jpcap
 * Method:    loopPacket
 * Signature: (ILjpcap/JpcapHandler;)I
 */
JNIEXPORT jint JNICALL Java_jpcap_Jpcap_loopPacket
  (JNIEnv *, jobject, jint, jobject);

/*
 * Class:     jpcap_Jpcap
 * Method:    setFilter
 * Signature: (Ljava/lang/String;Z)V
 */
JNIEXPORT void JNICALL Java_jpcap_Jpcap_setFilter
  (JNIEnv *, jobject, jstring, jboolean);

/*
 * Class:     jpcap_Jpcap
 * Method:    updateStat
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_jpcap_Jpcap_updateStat
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_Jpcap
 * Method:    getErrorMessage
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_jpcap_Jpcap_getErrorMessage
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_Jpcap
 * Method:    close
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_jpcap_Jpcap_close
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif