#!/bin/bash
cd src
java Star "$@" > ../data/p.dat
j=$?
cd ..
if [ $j -eq 0 ]; then
    head -n 1 data/p.dat >> data/p.dat
    gnuplot -p -e "set terminal png size 1920, 1080 enhanced background rgb 'black'; set output 'data/polygon.png'; unset xtics; unset ytics; unset border; plot 'data/p.dat' using 1:2 with lines notitle"
fi
