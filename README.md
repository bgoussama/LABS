# 🔧 JNIDemo — LAB 22

## 🎬 Demo


https://github.com/user-attachments/assets/0e45739d-18d6-4325-a966-0092efd8ecb0



## 📱 Description
Application Android JNI - communication Java et C++ natif.

## ⚡ Fonctions natives
- helloFromJNI() → "Hello from C++ via JNI !"
- factorial(10) → 3628800
- reverseString() → "!lufrewop si INJ"
- sumArray({10,20,30,40,50}) → 150

## 🏗️ Architecture
Java → JNI → C++ (native-lib.cpp) → libnative-lib.so

## 🛠️ Stack
- Language : Java + C++
- Build : CMake 3.22.1
- NDK : Android NDK
- Min SDK : API 24

## 🚀 Installation
1. Cloner le repo
2. Checkout lab22
3. Vérifier NDK + CMake installés dans SDK Manager
4. Sync Gradle
5. Lancer sur émulateur
