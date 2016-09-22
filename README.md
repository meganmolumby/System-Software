# System-Software
Molumby, Megan N00942101
System Software~COP3404
Date:22 Sept 2016

i. Purpose of the project
	Implement the symbol table that will be used by the assembler during pass 1 and pass 2 
using an efficient hashing table. The main routine reads a file name off the command line. The input
file consists of a character string and an optional number, one per line. The actions follow the following
rules: 
	1) upon seeing moss 25
 		hash moss creating a location in an array.
 		if moss already exists, report an error, for example:
 		(ERROR moss already exists at location 8)
 		if moss does not exist, store the name and its number
 		when moss is stored print a lines such as:
		stored moss 25 at location 8 (where 8 is the array index where moss is stored
		reporting collisions, if necessary)

	2) upon seeing eno
 		hash eno to find the location in the array where eno may
 		or may not exist.
 		if eno does not exist, report an error
 		(ERROR eno not found)
 		if eno does exist, report the location in the array and its number.
 		(eno found at location 12 with value 433)
Creates an output file with at least one line per input line, with the apropriate message.

ii. Source file(s)

	project1.java
	HashTable.java
	DataItem.java

iii. Input file(s)
	
	input.txt

iv. Output file(s)

	output.txt
	
v. Instructions to execute the project


To execute:
	1.Unzip file
	2.Type make.
	3. Type java project1 input.txt
	4. Open output file to view the output. 
