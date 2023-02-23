# Tugas Kecil 2 Strategi Algoritma
## Closest Pair of Points for 3D or n-D Points
Matthew Mahendra - 13521007

## Deskripsi Singkat
Program ini adalah program untuk mencari pasangan titik terdekat pada dimensi 2-n dimensi. Program akan menerima n titik serta derajat d yang akan digunakan. Program ini menggunakan algoritma divide and conquer sekaligus algoritma bruteforce untuk menentukan pasangan titik terdekat tersebut.

## Requirement Program
Untuk menjalankan program ini, Anda wajib melakukan instalasi Python dan juga mengunduh repository ini. Python yang digunakan adalah versi 3.11.1. Selain itu, Anda juga harus memiliki package Matplotlib untuk dapat melakukan visualisasi pasangan titik terdekat pada ruang dimensi 2 dan 3

## Cara Menjalankan Program
Program dijalankan pada file Main.py. Dari terminal Anda dapat menjalankan perintah
```
cd src
python Main.py
```

Program akan menerima input n buah titik serta dimensi d pada setiap titik tersebut. Titik yang dihasilkan merupakan hasil pembangkitan secara acak. Kemudian program akan menghitung pasangan titik dengan jarak terdekat, sekaligus menghitung jarak, menampilkan pasangannya, dan memberikan runtimenya.

Jika derajat titik adalah 2 atau 3, maka program akan menanyakan kepada pengguna apakah akan menampilkan visualisasi atau tidak.