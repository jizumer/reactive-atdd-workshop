#!/bin/bash
set -eux

declare -r HOST="http://localhost:8080/status"

wait-for-url() {
    echo "Testing $1"
    timeout -s TERM 45 bash -c \
    'while [[ "$(curl -s -o /dev/null -L -w ''%{http_code}'' ${0})" != "200" ]];\
    do echo "Waiting for ${0}" && sleep 2;\
    done' ${1}
    echo "Health check OK!"
    curl -I $1
}
wait-for-url ${HOST}