#!/usr/bin/env node

let key = process.argv[2]?.length ? process.argv[2] : process.exit(1)

let keygen = key => {
    let idx = 0
    return () => key[idx++ % key.length].charCodeAt()
}

let k = keygen(key)
let enc = buf => {
  for( let i=0; i<buf.length; i++ ) {
    buf[i] ^= k();
  }
  return buf;
}
process.stdin.on('data', chunk => process.stdout.write(enc(chunk)))
