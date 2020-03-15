Let's create a program that creates a class with students and shows where each student is seating. The program should first ask you 2 questions:
	
How many rows does the class have?
	How many students does the class have?

Then calculate how many seats each row has. If you calculate that one row must have more seats than the others, then put the extra seats on the last row.
Next, you have to place student names in each seat. The program will choose a random seat that is empty and ask you to enter the student's name (Use class Random). If a seat is not empty, the program should not ask you to enter a name for that seat. This should continue until all the seats are filled. Each time that you are asked to enter a name for a seat, you should be informed about the empty seats remaining. For example:
X seats are empty!
Please enter student's name for seat [0][2]:
When all seats are filled, the program should thank you and print the structure of the class. Each student in the same row should be separated by tab space. Use \t for tab space like we use \n for new line.