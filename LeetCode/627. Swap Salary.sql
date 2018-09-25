# Write your MySQL query statement below

update salary set sex= CHAR(ASCII('f') + ASCII('m') - ASCII(sex));