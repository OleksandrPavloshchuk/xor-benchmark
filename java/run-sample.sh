#!/usr/bin/env bash

set -x

ARGS=(
  -cp ./build/classes/java/main
  xor.benchmark.singlethread.Application
  monkey
)

echo Їжачок | java "${ARGS[@]}" | java "${ARGS[@]}"