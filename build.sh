#!/usr/bin/env zsh
if (( $# == 0 )); then
    find src -name \*.class -type f -delete
    javac src/**/*.java
else
    case $1 in
        -c)
            find src -name \*.class -type f -delete
            ;;
        -b)
            javac src/**/*.java
            ;;
        *)
            echo Invalid arguments
            ;;
    esac
fi
