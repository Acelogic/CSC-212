#!/bin/bash
echo "Welcome to autoCommit" 
git status && git add . && git status && echo "Enter Your Commit Message" &&
read msg
git commit -m "${msg}"
echo "Would you like to Force This y/n ?"
read rsp
if [$rsp = "y"]; then
git push origin master -f
else
git push origin master
fi

