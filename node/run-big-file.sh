#!/usr/bin/env bash

set -x

head -c $((1024*1024*100)) /dev/urandom > ~/temp/100M.bin
time ./main.sh monkey <~/temp/100M.bin >/dev/null