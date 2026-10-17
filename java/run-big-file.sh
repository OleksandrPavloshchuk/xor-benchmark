#!/usr/bin/env bash

set -x

ARGS=(
  -cp ./build/classes/java/main
  xor.benchmark.singlethread.Application
  monkey
)

head -c $((1024*1024*100)) /dev/urandom > ~/temp/100M.bin
time java "${ARGS[@]}" <~/temp/100M.bin >/dev/null