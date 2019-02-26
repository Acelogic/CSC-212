#!/bin/bash
echo "Welcome to autoCommit" 
git status && git add . && git status && echo "Enter Your Commit Message" &&
read msg
git commit -m "${msg}"
echo "Would you like to Force This ?"
read rsp
if[$rsp == "yes"]
then
git push origin master -f
else
git push origin master
fi

