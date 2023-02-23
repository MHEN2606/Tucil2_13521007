# Tugas Kecil 2 Strategi Algoritma
## Closest Pair of Points for 3D or n-D Points
Matthew Mahendra - 13521007

## Deskripsi Singkat
Program ini adalah program untuk mencari pasangan titik terdekat pada dimensi 2-n dimensi. Program akan menerima n titik serta derajat d yang akan digunakan. Program ini menggunakan algoritma divide and conquer sekaligus algoritma bruteforce untuk menentukan pasangan titik terdekat tersebut.

## Requirement Program
Untuk menjalankan program ini, Anda wajib melakukan instalasi Java Development Kit (JDK) dan juga mengunduh repository ini. JDK yang digunakan pada pengembangan program ini adalah versi 19.0.1 yang dikeluarkan pada 18 Oktober 2022. Untuk menampilkan visualisasi untuk titik di dimensi 2 dan 3, digunakan Python dengan package Matplotlib untuk visualisasi. Python yang digunakan adalah versi 3.11.1

## Cara Menjalankan Program
Program dijalankan dengan menggunakan menjalankan file batch `run.bat` yang tersedia pada folder src. Karena menggunakan .bat, maka program hanya dapat dijalankan pada sistem operasi windows.

Program akan menerima input n buah titik serta derajat d pada setiap titik tersebut. Titik yang dihasilkan merupakan hasil randomizer. Kemudian program akan menghitung pasangan titik dengan jarak terdekat, sekaligus menghitung jarak, menampilkan pasangannya, dan memberikan runtimenya.

Jika derajat titik adalah 2 atau 3, maka program juga akan menampilkan visualisasi.