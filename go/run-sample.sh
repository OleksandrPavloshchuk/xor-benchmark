#!/usr/bin/env bash

set -x

echo Їжачок \
  | ./build/xor-benchmark monkey \
  | ./build/xor-benchmark monkey